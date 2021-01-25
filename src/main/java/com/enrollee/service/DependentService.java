package com.enrollee.service;

import com.enrollee.model.Dependent;

public interface DependentService {

	Iterable<Dependent> getAllDependents();

	String createDependent(Long enrolleeId, Dependent dependent);

	String updateDependent(Long id, Dependent dependent);

	Dependent getDependent(Long id);

	String deleteDependent(Long id);
	
}
