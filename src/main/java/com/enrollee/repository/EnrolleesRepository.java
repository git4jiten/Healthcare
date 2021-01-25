package com.enrollee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollee.model.Enrollees;

@Repository
public interface EnrolleesRepository extends CrudRepository<Enrollees, Long>{
	
}
