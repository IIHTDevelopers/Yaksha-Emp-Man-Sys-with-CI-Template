package com.yaksha.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeManagementApplication {

	public static void main(String[] args) {
		// Load the Spring context from the XML configuration file
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve the Employee bean from the Spring container
		Employee employee = context.getBean("employee1", Employee.class);

		// Display employee details
		employee.displayEmployeeDetails();
	}
}
