package com.training.datajpa.aops;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.training.datajpa.entities.Car;

@Component
@Aspect

public class CarLoggingAspect {

	 private final Logger log =  LoggerFactory.getLogger(this.getClass());
	 
	 
	 @Before(value="(execution(* com.training.datajpa.controllers.CarController.addCar(..)))")
	 public void adviceBeforeAddCar(JoinPoint jp) {
		 
		 log.info("Going to add a car object"+jp.getSignature()+LocalDateTime.now());
		 
		 
	 }
	 
	 
	 @Before(value="(execution(* com.training.datajpa.services.CarServiceImpl.addCar(..)))")
	 public void adviceBeforeAddCarService(JoinPoint jp) {
		 
		 log.info("Going to add a car object in Service ,Controller has called Service"+jp.getSignature()+LocalDateTime.now());
		 
		 
	 }
	 @After(value="(execution(* com.training.datajpa.controllers.CarController.addCar(..)))")
	 public void adviceAfterAddCar(JoinPoint jp) {
		 
		 log.info("Added a car object"+jp.getSignature()+LocalDateTime.now());
		 
		 
	 }
	 
	 @After(value="(execution(* com.training.datajpa.services.CarServiceImpl.addCar(..)))")
	 public void adviceAfterAddCarService(JoinPoint jp) {
		 
		log.info("Added a car object in Service ,Controller has called Service"+jp.getSignature()+LocalDateTime.now());
		 
		 
	 }
	 
	
	 
	 @AfterThrowing(value="(execution(* com.training.datajpa.services.CarServiceImpl.findById(..)))",throwing="e")
	 public void afterThrowing(JoinPoint jp ,Exception e){
		 
		 log.error("fetch failed"+e + jp.getSignature());
		 
		 
		 
	 }
	 
	 @AfterReturning(value="(execution(* com.training.datajpa.services.CarServiceImpl.findById(..)))",returning="car")
	 public void afterR(JoinPoint jp ,Car  car){
		 
		 log.info("Returning Car object"+car);
		 
		 
		 
	 }
	 
		/*
		 * @Around(
		 * value="(execution(* com.training.datajpa.services.CarServiceImpl.findById(..)))"
		 * ) public void aroundFind(ProceedingJoinPoint jp){
		 * 
		 * log.info("called fetch by id"); try { Car car = (Car) jp.proceed();
		 * 
		 * } catch (Throwable e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } log.info("after fetch");
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
}
