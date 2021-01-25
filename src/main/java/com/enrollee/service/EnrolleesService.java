package com.enrollee.service;

import com.enrollee.model.Enrollees;

public interface EnrolleesService {

	Iterable<Enrollees> getAllEnrolles();

	String createEnrollee(Enrollees enrollees);

	String updateEnrollee(Long id, Enrollees enrollees);

	Enrollees getEnrollee(Long id);

	String deleteEnrolle(Long id);
	
}
