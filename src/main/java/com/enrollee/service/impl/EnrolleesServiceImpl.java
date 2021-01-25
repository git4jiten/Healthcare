package com.enrollee.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollee.model.Dependent;
import com.enrollee.model.Enrollees;
import com.enrollee.repository.EnrolleesRepository;
import com.enrollee.service.EnrolleesService;

@Service 
public class EnrolleesServiceImpl implements EnrolleesService {
	@Autowired
	private EnrolleesRepository repository;

	@Override
	public String createEnrollee(Enrollees enrollees) {
		enrollees = map(enrollees);
		repository.save(enrollees);
		return "Saved";
	}

	private Enrollees map(Enrollees enrollees) {
		for(Dependent dep : enrollees.getDependent()){
			dep.setEnrollees(enrollees);
			enrollees.getDependent().add(dep);
		}
		return enrollees;
	}

	@Override
	public Iterable<Enrollees> getAllEnrolles() {
		return repository.findAll();
	}

	@Override
	public String updateEnrollee(Long id, Enrollees enrollees) {
		Enrollees e = getEnrollee(id);
		e.setActivationStatus(enrollees.isActivationStatus());
		e.setBirthDate(enrollees.getBirthDate());
		e.setName(enrollees.getName());
		e.setPhoneNumber(enrollees.getPhoneNumber());
		repository.save(e);
		return "Updated";
	}

	@Override
	public Enrollees getEnrollee(Long id) {
		Optional<Enrollees> contact =  repository.findById(id);
		return contact.isPresent() ? contact.get() : new Enrollees();
	}

	@Override
	public String deleteEnrolle(Long id) {
		repository.deleteById(id);
		return "Deleted";
	}

}
