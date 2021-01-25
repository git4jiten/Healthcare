package com.enrollee.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enrollee.model.Dependent;
import com.enrollee.model.Enrollees;
import com.enrollee.repository.DependentRepository;
import com.enrollee.repository.EnrolleesRepository;
import com.enrollee.service.DependentService;

@Service 
public class DependentServiceImpl implements DependentService {
	@Autowired
	private EnrolleesRepository enrolleesRepository;
	@Autowired
	private DependentRepository dependentRepository;


	@Override
	public Iterable<Dependent> getAllDependents() {
		return dependentRepository.findAll();
	}

	@Override
	public String updateDependent(Long id, Dependent dependent) {
		Dependent dep = getDependent(id);
		dep.setActivationStatus(dependent.isActivationStatus());
		dep.setBirthDate(dependent.getBirthDate());
		dep.setName(dependent.getName());
		dependentRepository.save(dep);
		return "Updated";
	}

	@Override
	public Dependent getDependent(Long id) {
		Optional<Dependent> dependent = dependentRepository.findById(id);
		return dependent.isPresent() ?  dependent.get() : new Dependent();
	}

	@Override
	public String deleteDependent(Long id) {
		dependentRepository.deleteById(id);
		return "Deleted";
	}

	@Override
	public String createDependent(Long enrolleeId, Dependent dependent) {
		Optional<Enrollees> e = enrolleesRepository.findById(enrolleeId);
		if(e.isPresent()) {
			dependent.setEnrollees(e.get());
			dependentRepository.save(dependent);
			return "Saved";
		}
		return "Not Saved";
	}

}
