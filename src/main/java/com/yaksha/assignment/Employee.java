package com.yaksha.assignment;

public class Employee {

	private String id;
	private String name;
	private Department department;
	private Address address;

	// Constructor-based Dependency Injection
	public Employee(String id, String name, Department department, Address address) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.address = address;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	// Method to display employee details
	public void displayEmployeeDetails() {
		System.out.println("Employee ID: " + id);
		System.out.println("Employee Name: " + name);
		System.out.println("Department: " + department.getName());
		System.out.println("Address: " + address.getStreet() + ", " + address.getCity());
	}
}
