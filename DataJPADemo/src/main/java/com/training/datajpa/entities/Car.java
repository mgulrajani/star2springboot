package com.training.datajpa.entities;

import jakarta.annotation.Nonnull;
import org.hibernate.annotations.GeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Car {

	public Car(String make, String model, Type type) {
		
		this.make=make;
		this.model=model;
		this.type =type;
		
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	 
	@Nonnull
	 
	private String make;
	private String model;
	private Type type;
	
	
}
