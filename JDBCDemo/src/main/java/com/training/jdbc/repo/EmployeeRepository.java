package com.training.jdbc.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.training.jdbc.entities.Employee;
@Repository
public interface EmployeeRepository {
	
	public Employee addEmployee(Employee e);
	public List<Employee> addMultipleEmployees(List<Employee> e);
	public Employee getById(int id);
	public List<Employee> getAll();
	
	

}
