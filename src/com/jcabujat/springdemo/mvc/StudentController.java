package com.jcabujat.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}")
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showForm")
	public String shorForm(Model model) {
		
		// add a student object to the model
		model.addAttribute("student", new Student());
		
		//add the country options to the model
		model.addAttribute("theCountryOptions", countryOptions);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		// print the input data from student object
		System.out.println("Student details: \n First name: " + student.getFirstName()
				                          + "\n Last name : " + student.getLastName());
		return "student-confirmation";
	}

}
