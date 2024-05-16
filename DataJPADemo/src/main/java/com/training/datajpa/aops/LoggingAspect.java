package com.training.datajpa.aops;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component	
@Aspect
public class LoggingAspect {

	//this class is an Aspect  --AOP
	//deal with some cross cutting concerns of the application
	//eg of cross cutting concern -- there are multiple locations ,classes which needs to address those concerns --
	
	//logging  , authentication , 
	
	//any method which we create in an Aspect is an advice
	
	
	//JoinPoint  is the encapsulated object which is the method itself which is advised
	
	
	//PointCut is the expression which methods are advised
	
	
	@Before(value="(execution(* com.training.datajpa.aops.entities.ShoppingCart.checkOut()))")
	public void adviceBeforeCheckOut(JoinPoint jp) {
		
		
		System.out.println("before checking out of Shopping cart" +jp.getSignature());
	}
	
}
