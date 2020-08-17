package com.example.demo.services;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.example.demo.model.StateWise;


public interface CovidDataServiceInterface {
	
	void fetchAllData() throws IOException, InterruptedException, ParseException, java.text.ParseException;
	List<StateWise> getStateWiseList();
}
