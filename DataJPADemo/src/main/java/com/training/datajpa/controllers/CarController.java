package com.training.datajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.datajpa.entities.Car;
import com.training.datajpa.services.CarService;


@RestController
@RequestMapping("/cars")
public class CarController {
	
	@Autowired
	
	private CarService service;
	
	
	@GetMapping
	public ResponseEntity<List<Car>>  getAllCars(){
		
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
		
		
	}
	
	
	
	//for adding a Car , means POST --adding a new resource to the collection
	@PostMapping
	public ResponseEntity<Car> addCar(@RequestBody Car car){
		
		Car newlyAddedCar = service.addCar(car);
		
		return new ResponseEntity<Car>(newlyAddedCar,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Car>  getCarById(@PathVariable long id){
		
		return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("model/{model}")
	public ResponseEntity<List<Car>>  getCarsByModel(@PathVariable String model){
		
		return new ResponseEntity<>(service.findByModel(model),HttpStatus.OK);
		
		
	}

	@GetMapping("make/{make}")
	public ResponseEntity<List<Car>>  getCarsByMake(@PathVariable String make){
		
		return new ResponseEntity<>(service.findByMake(make),HttpStatus.OK);
		
		
	}

}
