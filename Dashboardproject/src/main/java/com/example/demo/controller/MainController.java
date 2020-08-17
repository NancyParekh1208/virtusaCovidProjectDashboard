package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.StateWise;
import com.example.demo.services.CovidDataService;
import com.example.demo.services.PassService;

@Controller
public class MainController {
	
	@Autowired
	CovidDataService covidDataService;
	
	@Autowired
	PassService passService;
	
	@GetMapping("/")
	public String welcome(Model model) {
		List<StateWise> stateWiseList = covidDataService.getStateWiseList();
		model.addAttribute("stateWiseList",stateWiseList);
	    return "LandingPage";
	}
	@GetMapping("/Landingpage")
    public String root(Model model) {
		List<StateWise> stateWiseList = covidDataService.getStateWiseList();
		model.addAttribute("stateWiseList",stateWiseList);
        return "Landingpage";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    
    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
  /* @RequestMapping(value="/home", method=RequestMethod.GET)
    public ModelAndView home()
    {
    	ModelAndView modelAndView=new ModelAndView();
    	modelAndView.setViewName("home");
    	return modelAndView;
    }
    */
   /* @RequestMapping(value="/admin", method=RequestMethod.GET)
    public ModelAndView adminHome(Model model)
    {
    	ModelAndView modelAndView=new ModelAndView();
    	modelAndView.setViewName("admin");
    	return modelAndView;
    }*/
    
    @GetMapping("/showListPasses")
	public String showPassPage(Model model)
	{
    	model.addAttribute("passlist", passService.getAllPassRequests());
		return "showPassPage";
	}
	
	@GetMapping("/showPassPage")
	public String passPage(Model model)
	{
		model.addAttribute("passlist", passService.getAllPassRequests());
		return "showPassPage";
	}
    
}
