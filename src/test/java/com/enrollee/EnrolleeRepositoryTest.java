package com.enrollee;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enrollee.model.Dependent;
import com.enrollee.model.Enrollees;
import com.enrollee.repository.EnrolleesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EnrolleeApplication.class)
public class EnrolleeRepositoryTest {

	@Autowired
	private EnrolleesRepository repo;
	
	@Test
	public void checkCURDOperations(){
		Enrollees e = new Enrollees();
		e.setName("XYZ");
		e.setActivationStatus(true);
		e.setBirthDate(Calendar.getInstance());
		e.setPhoneNumber("123456789");
		
		Dependent d = new Dependent();
		d.setName("ABC");
		d.setActivationStatus(true);
		d.setBirthDate(Calendar.getInstance());
		
		d.setEnrollees(e);

		Set<Dependent> dep = new HashSet<Dependent>();
		e.setDependent(dep);
		
		repo.save(e);
		List<Enrollees> all= (List<Enrollees>) repo.findAll();
		assertTrue(all.size()>0);
	}
}
