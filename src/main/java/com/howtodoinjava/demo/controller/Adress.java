package com.howtodoinjava.demo.controller;

import com.howtodoinjava.validutils.IsValidCity;

public class Adress {
	private String country;
	@IsValidCity
	private String city;
	private String street;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
