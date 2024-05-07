package com.training.entities;

import java.time.LocalDate;
import java.util.List;

public class Employee {

	public Employee(String name, Department department) {
		super();
		this.name = name;
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", address=" + address
				+ ", dob=" + dob + ", projects=" + projects + "]";
	}


	private long id;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String name;
	private Department department;
	private Address address;
	private LocalDate dob;
	private List<Project> projects;
	
	
	public Employee(long id, String name, Department department, Address address, LocalDate dob,
			List<Project> projects) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.address = address;
		this.dob = dob;
		this.projects = projects;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
	//data members
	//default constructor
	//getters and setters 
	//toString
	//HashSet -- equals and hashCode impl
	
	

}
