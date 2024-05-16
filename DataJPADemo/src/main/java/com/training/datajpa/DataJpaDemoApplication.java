package com.training.datajpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.training.datajpa.aops.entities.ShoppingCart;

@EnableAspectJAutoProxy
@SpringBootApplication
public class DataJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaDemoApplication.class, args);
		
	    ShoppingCart sc = new ShoppingCart();
	    sc.checkOut();
	    
		
		
	}

}
