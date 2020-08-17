package com.example.demo.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.example.demo.model.StateWise;
import com.example.demo.model.Statistics;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CovidDataService implements CovidDataServiceInterface{
	
	private  static String DATA_URL="https://api.covid19india.org/data.json";
	 
	public List<StateWise> stateWiseList = new ArrayList<>();
	 
	public List<StateWise> getStateWiseList() {
		return stateWiseList;
	}

	public void setStateWiseList(List<StateWise> stateWiseList) {
		this.stateWiseList = stateWiseList;
	}
	
	@Override
	@PostConstruct
	public void fetchAllData() throws IOException, InterruptedException, ParseException
	{
		 HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create(DATA_URL))
	                .build();
	        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
	        //System.out.println(httpResponse.body());
	        JSONParser jsonParser = new JSONParser();
	        org.json.simple.JSONObject jsonObject = (JSONObject) jsonParser.parse(httpResponse.body());
	        ObjectMapper objectMapper = new ObjectMapper();
	        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	        Statistics statistics = objectMapper.readValue(jsonObject.toString(),Statistics.class);
	        this.stateWiseList = Arrays.asList(statistics.getStateWise());
	        }
}
