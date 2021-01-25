package com.enrollee.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dependent implements Serializable	{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7299092886813010587L;
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private boolean activationStatus;
	private Calendar birthDate;
	
	@ManyToOne
    @JoinColumn(name = "enrollees_id", nullable = false)
    private Enrollees enrollees;
	
	public Dependent(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}
/*
	public Enrollees getEnrollees() {
		return enrollees;
	}
	*/

	public void setEnrollees(Enrollees enrollees) {
		this.enrollees = enrollees;
	}

	
}