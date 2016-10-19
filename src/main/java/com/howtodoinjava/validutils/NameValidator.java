package com.howtodoinjava.validutils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<IsValidName, String> {
	
	private String listOfName;

	public void initialize(IsValidName constraintAnnotation) {

		this.listOfName = constraintAnnotation.listOfName();

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {

			return false;

		}
		if (value.matches(listOfName)) {

			return true;

		} else {

			return false;
		}
	}

}
