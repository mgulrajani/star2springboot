package com.training.jdbc;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.training.jdbc.entities.Employee;
import com.training.jdbc.service.EmployeeService;
import com.training.jdbc.service.EmployeeServiceImpl;

@SpringBootApplication
public class JdbcDemoApplication {
	
	
	public static void main(String[] args) {
		ApplicationContext ct = SpringApplication.run(JdbcDemoApplication.class, args);
		
		EmployeeService service =  ct.getBean(EmployeeServiceImpl.class);
				
		Employee e = new Employee("Priya", new BigDecimal(344343));
		
		e = service.addEmployee(e);
		
		
		
		System.out.println("data added");
		
		Employee empFound =  service.getById(e.getId());
		
		System.out.println(empFound);
		
	}

}
