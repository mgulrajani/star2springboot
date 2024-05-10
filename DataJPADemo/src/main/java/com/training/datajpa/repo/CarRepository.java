package com.training.datajpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.datajpa.entities.Car;

public interface CarRepository  extends JpaRepository<Car, Long>{
	
	List<Car> findByModel(String model);
	List<Car> findByMake(String make);
	

}
