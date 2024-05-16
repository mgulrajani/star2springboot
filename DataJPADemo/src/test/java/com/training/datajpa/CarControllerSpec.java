package com.training.datajpa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.training.datajpa.controllers.CarController;
import com.training.datajpa.entities.Car;
import com.training.datajpa.entities.Type;
import com.training.datajpa.services.CarService;

@WebMvcTest(CarController.class)
public class CarControllerSpec {

	@Autowired
	private MockMvc mockMvc;
	
	
	//Controllers consumes service
	
	@MockBean
	private CarService service;
	
	
	private Car car ;
	
	
	//below methods are static at the class level
	@BeforeAll
	public static void setUp() throws Exception{
		System.out.println("Some tasks needs to be performed only once before all the tests , at the class level goes here");
	}
	
	
	@AfterAll
	public static void tear() throws Exception{
		System.out.println("Some tasks needs to be performed only once after all the tests , at the class level goes here");
	}
	
	
	//methods are at the instance level , they will invoke before every test
	
	@BeforeEach
	//1.A Arrange
	public  void setUpBeforeEach() throws Exception{
		System.out.println("Some tasks needs to be performed  once before every tests , at the instance level goes here");
	
		car = new Car(111,"Toyota","crysta ",Type.RUV);
		
		
	}
	
	
@AfterEach	
	public  void setUpAfterEach() throws Exception{
		System.out.println("Some tasks needs to be performed  once after every tests , at the instance level goes here");
	
		car = null;
		
		
	}
//json

/*
 * {
 * "model":"Toyota",
 * "make":"crysta",
 * "type":"RUV" }
 * 
 * 
 * 
 */
   
     @Test
     void testAddCar() {
    	 
    	 //here we are not going to use actual service object
    	 //we are mocking the service object
    	 //we are training this mock object  , if controller asks service to addCar  , it should  return that car
    	 //2. A Act
    	 Mockito.when(service.addCar(car)).thenReturn(car);
    	 
    	 try {
    		 
    		 mockMvc.perform(MockMvcRequestBuilders.post("/cars").
    				 contentType(MediaType.APPLICATION_JSON)
    				 .content("{"+"\"model\":\"Toyota\",\"make\":\"crysta\",\"type\":\"RUV\"}"))
    		 			.andExpect(MockMvcResultMatchers.status().isCreated());
    		  //3.Assertion
    		 
    		 
    	 }catch (Exception e) {e.printStackTrace();}
    	 
     }
	
	
	
	
	
}
