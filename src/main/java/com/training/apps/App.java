package com.training.apps;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.training.entities.Employee;

public class App {
	public static void main(String[] args) {
		
		
		/**just to create this object e which is of Employee type ,
		 *  my client code had to provide 
		department
		address
		projects
		dob
		
		*/
		
		
		//BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		
		Employee e = (Employee)context.getBean("emp1");
		
		System.out.println(e);
		
		System.out.println(e.hashCode());
		Employee e2 =  (Employee)context.getBean("emp1");
		
		e2.setDob(LocalDate.of(2000, 3, 1));
		
		System.out.println(e2);
		
		System.out.println(e2.hashCode());
		
		
		
	}	
}
