package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.PassRequest;
import com.example.demo.model.StateWise;
import com.example.demo.services.CovidDataService;
import com.example.demo.services.PassService;



@Controller
public class PassController {
	
	@Autowired
	PassService passService;
	
	@Autowired
	CovidDataService covidDataService;
	
	@GetMapping("/pass")
	public String showpass(Model model)
	{
		//model.addAttribute(passrequest);
		return "pass";
	}
	
	@GetMapping("/shownewpass")
    public String showPass(Model model)
    {
		PassRequest passrequest = new PassRequest();
        model.addAttribute("passrequest", passrequest);
    	return "pass";
    }
	
	@GetMapping("/checkPass")
	public String checkForPassWithId(Model model)
	{
		PassRequest pass=new PassRequest();
		model.addAttribute("pass", pass);
		return "checkForPass";
	}
	
	@GetMapping("/checkForPass")
	public String checkPassForm(Model model)
	{
		//model.addAttribute("passrequest",passrequest);
		return "checkForPass";
	}
	
	@PostMapping("/checkPassStatus")
	public String seePassStatus(@ModelAttribute("pass") PassRequest pass, Model model)
	{
		
		long id=pass.getId();
		PassRequest passrequest=passService.getPassRequestById(id);
		//PassRequest passrequest=passService.getPassRequestById(pass.getId());
		String source_name=passrequest.getSourceName();
		String destination_name=passrequest.getDestinationName();
		List<StateWise> stateWiseList = covidDataService.getStateWiseList();
		String s1=new String();
		String s2=new String();
		int source_count=0,destination_count=0;
		for(int i=0;i<stateWiseList.size();i++)
		{
			StateWise s=stateWiseList.get(i);
			if(s.getStateName()==source_name)
			{
				s1=s.getActive();
				source_count=Integer.parseInt(s1);
				continue;
			}
			if(s.getStateName()==destination_name)
			{
				s2=s.getActive();
				destination_count=Integer.parseInt(s2);
				continue;
			}
		}
		if(source_count<=100000 && destination_count<=100000)
		{
			passrequest.setStatus("confirmed");
			passService.savePassRequest(passrequest);
		}
		else
		{
			passrequest.setStatus("denied");
			passService.savePassRequest(passrequest);
		}
		//model.addAttribute(passrequest);
		//model.addAttribute("pass",passrequest);
		pass.setFirstName(passrequest.getFirstName());
		pass.setLastName(passrequest.getLastName());
		pass.setPhoneNumber(passrequest.getPhoneNumber());
		pass.setStatus(passrequest.getStatus());
		pass.setSourceName(passrequest.getSourceName());
		pass.setDestinationName(passrequest.getDestinationName());
		model.addAttribute(pass);
		return "checkForPass";
	}
	
	    @PostMapping("/savePassRequest")
	    public String savePassRequest(@ModelAttribute("passrequest") PassRequest passrequest, Model model) {
	        // save pass to database
	        passService.savePassRequest(passrequest);
	        
	        model.addAttribute("success", "pass request is saved successfully");
	        //List<StateWise> stateWiseList = covidDataService.getStateWiseList();
	        return "pass";
	    }
}
