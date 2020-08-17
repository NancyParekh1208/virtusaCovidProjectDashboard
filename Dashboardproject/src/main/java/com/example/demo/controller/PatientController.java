package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Patient;
import com.example.demo.model.StateWise;
import com.example.demo.services.CovidDataService;
import com.example.demo.services.PatientService;

@Controller
public class PatientController {
	
	@Autowired
	CovidDataService covidDataService;
	
	@Autowired
	private PatientService patientService;
	// display list of patients
    @GetMapping("/admin")
    public String viewHomePage(Model model) {
        model.addAttribute("listPatients", patientService.getAllPatients());
        return "admin";
    }
    @GetMapping("/home")
    public String viewPage(Model model) {
        //model.addAttribute("listPatients", patientService.getAllPatients());
        return "home";
    }
    
    @GetMapping("/statewiselist")
    public String stateWiseDetailsPage(Model model)
    {
    	List<StateWise> stateWiseList = covidDataService.getStateWiseList();
		model.addAttribute("stateWiseList",stateWiseList);
    	return "statewiselist";
    }
    
    @GetMapping("/showNewPatientForm")
    public String showNewPatientForm(Model model) {
        // create model attribute to bind form data
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "admin/new_patient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient) {
        // save patient to database
        patientService.savePatient(patient);
        return "redirect:/admin";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get patient from the service
        Patient patient = patientService.getPatientById(id);

        // set patient as a model attribute to pre-populate the form
        model.addAttribute("patient", patient);
        return "admin/update_patient";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.patientService.deletePatientById(id);
        return "redirect:/admin";
    }
    
    @GetMapping("/searchPatientForm")
    public String searchPatientForm(Model model) {
    	Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "searchPatient";
    }
    @GetMapping("/searchPatient")
    public String search(Model model) {
        
 	   Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "searchPatient";
    	
    }
    
   @PostMapping("/searchPatient")
    public Patient searchPatient(@ModelAttribute("patient") Patient patient){
	   
    	return patientService.searchPatient(patient);
	   
    }
   
     
}
