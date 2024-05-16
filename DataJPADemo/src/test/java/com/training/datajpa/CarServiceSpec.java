package com.training.datajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.training.datajpa.entities.Car;
import com.training.datajpa.entities.Type;
import com.training.datajpa.exception.CarIdNotFoundException;
import com.training.datajpa.repo.CarRepository;
import com.training.datajpa.services.CarServiceImpl;

@SpringBootTest

public class CarServiceSpec {

	@Autowired
	private CarServiceImpl service;
	
	@MockBean
	private CarRepository repo;
	
	Car car ;
	
	//1.Arrange
	
	@BeforeEach
	public void testSetUp() {
		
		car = new Car(111,"Toyota","crysta ",Type.RUV);
		
		
		//using Mockito for mocking the repo  ,service .findbyid --calls repo.findById
		Mockito.when(repo.findById(111L)).thenReturn(Optional.of(car));
		
		
		
		
	}
	
	
	@Test
	public void testFindBy() throws CarIdNotFoundException {
		
		//2Act --because here I am calling the method under test
		
		 Car carFound =  service.findById(111);
		 
		 //3. Assertion
		 
		 assertEquals("Toyota", carFound.getMake());
		 
		 
		
		
	}
	
	
	@Test
	public void testAddCar() {
		
		//1.Arrange ,training the mock object
		Mockito.when(repo.save(car)).thenReturn(car);
		
		//2.Act  ,testing the method  addCar of the Service 
		Car newCar = service.addCar(car);
		
		
		//3.Assertion
		
		
		assertEquals(111, newCar.getId());

		assertEquals("crysta ", newCar.getModel());
		
		
	}
	
	
	
}
