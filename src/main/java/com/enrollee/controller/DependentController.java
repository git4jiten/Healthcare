package com.enrollee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrollee.model.Dependent;
import com.enrollee.service.DependentService;

@RestController
public class DependentController {
	
	@Autowired
	private DependentService service;
	
	@GetMapping("/getAllDependents")
	public Iterable<Dependent> getAllDependents(){
		return service.getAllDependents();
	}
	
	@PostMapping("/createDependent/{enrolleeId}")
	public String createDependent(@PathVariable Long enrolleeId, @RequestBody Dependent dependent){
		return service.createDependent(enrolleeId,dependent);
	}
	
	@PutMapping("/updateDependent/{id}")
	public String updateDependent(@PathVariable Long id,@RequestBody Dependent dependent){
		return service.updateDependent(id,dependent);
	}
	
	@GetMapping("/getDependent/{id}")
	public Dependent getDependent(@PathVariable Long id){
		return service.getDependent(id);
	}
	
	@DeleteMapping("/deleteDependent/{id}")
	public String deleteDependent(@PathVariable Long id){
		return service.deleteDependent(id);
	}

}
