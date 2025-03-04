package com.yaksha.assignment;

public class Address {

	private String street;
	private String city;

	// Constructor
	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	// Getter and Setter
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
