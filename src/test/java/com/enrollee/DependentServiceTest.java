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
import com.enrollee.service.DependentService;
import com.enrollee.service.EnrolleesService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EnrolleeApplication.class)
public class DependentServiceTest {

	@Autowired
	private EnrolleesService enrolleesService;
	
	@Autowired
	private DependentService dependentService;
	
	
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
		
		enrolleesService.createEnrollee(e);
	}
	@Test
	public void getAllDependents(){
		List<Dependent> all= (List<Dependent>) dependentService.getAllDependents();
		assertTrue(all.size()>0);
		
	}
	
	@Test
	public void getDependentBasedOnId(){
		Dependent c= dependentService.getDependent(2l);
		assertTrue(c.getId()!=null);
	}
	@Test
	public void update(){
		Dependent e = new Dependent();
		e.setName("XYZ");
		e.setActivationStatus(true);
		e.setBirthDate(Calendar.getInstance());
		String c= dependentService.updateDependent(2l, e);
		assertTrue("Updated".equals(c));
	}
}
