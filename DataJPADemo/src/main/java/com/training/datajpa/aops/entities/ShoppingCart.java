package com.training.datajpa.aops.entities;

import org.springframework.stereotype.Component;

@Component


public class ShoppingCart {
	
	public void checkOut() {
		
		System.out.println("checkout method of ShoppingCart invoked");
	}

}
