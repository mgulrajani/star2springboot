package com.training.datajpa.services;

import java.util.List;

import com.training.datajpa.entities.Car;

import jakarta.persistence.EntityNotFoundException;

public interface CarService {

	
	public Car addCar(Car car);
	
	public Car updateCar(long id ,Car car);
	
	public Car findById(long id) throws EntityNotFoundException;
	
	public List<Car> findAll();
	
	List<Car> findByModel(String model);
	List<Car> findByMake(String make);
	
}
