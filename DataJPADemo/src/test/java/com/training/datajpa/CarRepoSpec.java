package com.training.datajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import com.training.datajpa.entities.Car;
import com.training.datajpa.entities.Type;
import com.training.datajpa.repo.CarRepository;

@DataJpaTest

@Profile({"test"})

public class CarRepoSpec {

	
	@Autowired
	CarRepository repo;
	
	@Autowired
	private TestEntityManager em;
	
	Car car;
	
	
	@BeforeEach
	public void testSetUp() {
		//1.Arrange 
		car = new Car("BMW","Zoom ",Type.RUV);
	    car = em.persist(car);
		
	}
	
	@Test
	public void testFindById() {
		
		//2.Act

		//Optional<Car> carFound = repo.findById(1L);
		Long id = (Long)em.getId(car);
		
		
		Car c1 = em.find(Car.class, id);
		//3.Assertion
		
		System.out.println(c1);
		assertEquals("Zoom ", c1.getModel());
		
	}
	
}
