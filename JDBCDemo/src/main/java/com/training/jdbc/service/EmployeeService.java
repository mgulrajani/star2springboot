package com.training.jdbc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.training.jdbc.entities.Employee;
@Service
public interface EmployeeService {

	
	public Employee addEmployee(Employee e);
	public List<Employee> addMultipleEmployees(List<Employee> e);
	public Employee getById(int id);
	public List<Employee> getAll();
	
	
}
