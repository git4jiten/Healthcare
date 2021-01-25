package com.enrollee.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Enrollees implements Serializable{
	private static final long serialVersionUID = 5399699272570115667L;

	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private boolean activationStatus;
	@NotNull
	private Calendar birthDate;
	private String phoneNumber;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "enrollees")
    private Set<Dependent> dependent = new HashSet<>();
	
	public Enrollees(){
		
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Dependent> getDependent() {
		return dependent;
	}

	public void setDependent(Set<Dependent> dependent) {
		this.dependent = dependent;
	}
	
}
