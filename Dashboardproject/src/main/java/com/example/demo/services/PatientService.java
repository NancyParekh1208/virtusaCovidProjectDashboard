package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Patient;

public interface PatientService {
	
	List<Patient> getAllPatients();
	void savePatient(Patient patient);
	Patient getPatientById(long id);
	void deletePatientById(long id);
	Patient searchPatient(Patient patient);
}
