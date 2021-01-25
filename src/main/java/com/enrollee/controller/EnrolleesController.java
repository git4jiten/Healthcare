package com.enrollee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrollee.model.Enrollees;
import com.enrollee.service.EnrolleesService;

@RestController
public class EnrolleesController {
	
	@Autowired
	private EnrolleesService service;
	
	@GetMapping("/getAllEnrollees")
	public Iterable<Enrollees> getAllEnrolles(){
		return service.getAllEnrolles();
	}
	
	@PostMapping("/createEnrollee")
	public String createEnrollee(@RequestBody Enrollees enrollees){
		return service.createEnrollee(enrollees);
	}
	
	@PutMapping("/updateEnrollee/{id}")
	public String updateEnrollee(@PathVariable Long id,@RequestBody Enrollees enrollees){
		return service.updateEnrollee(id,enrollees);
	}
	
	@GetMapping("/getEnrollee/{id}")
	public Enrollees getEnrollee(@PathVariable Long id){
		return service.getEnrollee(id);
	}
	
	@DeleteMapping("/deleteEnrolle/{id}")
	public String deleteEnrolle(@PathVariable Long id){
		return service.deleteEnrolle(id);
	}

}
