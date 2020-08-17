package com.example.demo.services;

import java.util.List;

import com.example.demo.model.PassRequest;

public interface PassService {
	
	List<PassRequest> getAllPassRequests();
	void savePassRequest(PassRequest passrequest);
	PassRequest getPassRequestById(long id);
	PassRequest searchPassRequest(PassRequest passrequest);
}
