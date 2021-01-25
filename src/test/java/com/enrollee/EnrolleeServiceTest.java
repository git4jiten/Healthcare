package com.enrollee;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.enrollee.model.Dependent;
import com.enrollee.model.Enrollees;
import com.enrollee.service.EnrolleesService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EnrolleeApplication.class)
public class EnrolleeServiceTest {

	@Autowired
	private EnrolleesService service;
	
	@Before
	public void before(){
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
		dep.add(d);
		
		e.setDependent(dep);
		
		service.createEnrollee(e);
	}
	@Test
	public void getAllContacts(){
		List<Enrollees> all= (List<Enrollees>) service.getAllEnrolles();
		assertTrue(all.size()>0);
		
	}
	
	@Test
	public void getEnrolleeBasedOnId(){
		Enrollees c= service.getEnrollee(1l);
		assertTrue(c.getId()!=null);
	}
	@Test
	public void update(){
		Enrollees e = new Enrollees();
		e.setName("XYZ");
		e.setActivationStatus(true);
		e.setBirthDate(Calendar.getInstance());
		e.setPhoneNumber("123456789");
		String c= service.updateEnrollee(1l, e);
		assertTrue("Updated".equals(c));
	}
}
