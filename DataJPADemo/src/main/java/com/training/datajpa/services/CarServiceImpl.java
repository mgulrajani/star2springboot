package com.training.datajpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.datajpa.entities.Car;
import com.training.datajpa.repo.CarRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CarServiceImpl  implements CarService{

	
	@Autowired
	private  CarRepository repo;
	
	@Override
	public Car addCar(Car car) {
		// TODO Auto-generated method stub
		return repo.save(car);
	}

	@Override
	public Car updateCar(long id, Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car findById(long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(EntityNotFoundException::new);
		
	}

	@Override
	public List<Car> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Car> findByModel(String model) {
		// TODO Auto-generated method stub
		return repo.findByModel(model);
	}

	@Override
	public List<Car> findByMake(String make) {
		// TODO Auto-generated method stub
		return repo.findByMake(make);
	}

}
