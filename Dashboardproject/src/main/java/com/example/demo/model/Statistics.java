package com.example.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics implements Serializable{
	
	private static final long serialVersionUID = 1L;

	    @JsonProperty("statewise")
	    private StateWise[] stateWise;	    

	    public StateWise[] getStateWise() {
	        return stateWise;
	    }

	    public void setStateWise(StateWise[] stateWise) {
	        this.stateWise = stateWise;
	    }
}
