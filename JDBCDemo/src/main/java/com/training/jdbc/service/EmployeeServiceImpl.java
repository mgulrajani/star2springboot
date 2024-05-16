package com.training.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.jdbc.entities.Employee;
import com.training.jdbc.repo.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee addEmployee(Employee e) {
		return repo.addEmployee(e);
	}

	@Override
	public List<Employee> addMultipleEmployees(List<Employee> e) {
		return repo.addMultipleEmployees(e);
	}

	@Override
	public Employee getById(int id) {
		
		return repo.getById(id);
	}

	@Override
	public List<Employee> getAll() {
		
		return repo.getAll();
	}
	

}
