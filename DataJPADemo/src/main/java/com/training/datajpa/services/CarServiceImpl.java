package com.training.datajpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.datajpa.entities.Car;
import com.training.datajpa.exception.CarIdNotFoundException;
import com.training.datajpa.repo.CarRepository;

@Service
public class CarServiceImpl  implements CarService{

	
	@Autowired
	private  CarRepository repo;
	
	@Override
	public Car addCar(Car car) {
		
		return repo.save(car);
	}

	@Override
	public Car updateCar(long id, Car car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car findById(long id) throws CarIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Car> car =  repo.findById(id);
		
		if (!car.isPresent()) {
			throw new CarIdNotFoundException("Car not found with this id");
			
		}
		return car.get();
		
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
