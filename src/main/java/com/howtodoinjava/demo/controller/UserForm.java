package com.howtodoinjava.demo.controller;

import java.sql.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.howtodoinjava.validutils.IsValidName;

public class UserForm {
	@Size(min = 3, max = 15)
	// @IsValidName()//default
	@IsValidName(listOfName = "gaoyang|GaoYang|gaoYang|Gaoyang")
	private String name;
	private int age;
	private long mobilePhone;
	private String gender;
	private Adress address;
	@Past
	private Date gratuDate;

	public Date getGratuDate() {
		return gratuDate;
	}

	public void setGratuDate(Date gratuDate) {
		this.gratuDate = gratuDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(long mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Adress getAddress() {
		return address;
	}

	public void setAddress(Adress address) {
		this.address = address;
	}

}
