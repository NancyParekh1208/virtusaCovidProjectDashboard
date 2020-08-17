package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository< Patient, Long>{
	
	Patient findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastname, String phonenumber);
}
