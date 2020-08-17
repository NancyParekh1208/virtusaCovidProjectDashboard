package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.PassRequest;


@Repository
public interface PassRepository extends JpaRepository< PassRequest, Long> {
	
	PassRequest findBySourceNameAndDestinationName(String sourceName, String destinationName);
}
