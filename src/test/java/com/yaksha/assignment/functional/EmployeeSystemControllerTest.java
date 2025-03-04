package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yaksha.assignment.Employee;
import com.yaksha.assignment.utils.XMLParserUtils;

public class EmployeeSystemControllerTest {

	@After
	public void afterAll() {
		testReport();
	}

	@Test
	public void testClassPathXmlContextLoadsEmployeeCorrectly() throws IOException {
		// Load the context from the classpath-based XML configuration
		ApplicationContext contextClasspath = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Retrieve the beans from the context
		Employee employee = contextClasspath.getBean("employee1", Employee.class);

		// Assert that the employee bean is correctly instantiated
		boolean employeeNotNull = employee != null;

		// Assert that the 'id', 'name', and dependencies are set correctly
		boolean employeeDetailsCorrect = "E123".equals(employee.getId()) && "John Doe".equals(employee.getName())
				&& "IT Department".equals(employee.getDepartment().getName())
				&& "1234 Elm Street".equals(employee.getAddress().getStreet());

		// Use yakshaAssert to validate the test result
		yakshaAssert(currentTest(), employeeNotNull && employeeDetailsCorrect, businessTestFile);
	}

	@Test
	public void testEmployeeBeanPropertyFields() throws IOException {
		String filePath = "src/main/resources/applicationContext.xml";

		// Check if the "id" property exists and has the correct value
		boolean idPropertyExists = XMLParserUtils.checkPropertyExists(filePath, "employee1", "id", "E123");

		// Check if the "name" property exists and has the correct value
		boolean namePropertyExists = XMLParserUtils.checkPropertyExists(filePath, "employee1", "name", "John Doe");

		// Validate the results using yakshaAssert
		yakshaAssert(currentTest(), idPropertyExists && namePropertyExists, businessTestFile);
	}

	@Test
	public void testDepartmentBeanPropertyFields() throws IOException {
		String filePath = "src/main/resources/applicationContext.xml";

		// Check if the "name" property exists and has the correct value
		boolean namePropertyExists = XMLParserUtils.checkPropertyExists(filePath, "department1", "name",
				"IT Department");

		// Validate the results using yakshaAssert
		yakshaAssert(currentTest(), namePropertyExists, businessTestFile);
	}

	@Test
	public void testAddressBeanPropertyFields() throws IOException {
		String filePath = "src/main/resources/applicationContext.xml";

		// Check if the "street" property exists and has the correct value
		boolean streetPropertyExists = XMLParserUtils.checkPropertyExists(filePath, "address1", "value",
				"1234 Elm Street");

		// Check if the "city" property exists and has the correct value
		boolean cityPropertyExists = XMLParserUtils.checkPropertyExists(filePath, "address1", "value", "New York");

		// Validate the results using yakshaAssert
		yakshaAssert(currentTest(), streetPropertyExists && cityPropertyExists, businessTestFile);
	}

	@Test
	public void testMissingPropertyInXMLShouldFailTest() throws IOException {
		String filePath = "src/main/resources/applicationContext.xml"; // Path to the XML file

		// Check if the 'employee1' bean has the 'name' property set to a non-existent
		// value
		boolean result = XMLParserUtils.checkXMLStructure(filePath, "employee1", "name", "Non-Existent Value");

		// Using yakshaAssert to validate the test result
		yakshaAssert(currentTest(), !result, businessTestFile);
	}
}
