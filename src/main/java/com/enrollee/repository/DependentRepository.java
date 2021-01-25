package com.enrollee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.enrollee.model.Dependent;

@Repository
public interface DependentRepository extends CrudRepository<Dependent, Long>{
	
}
