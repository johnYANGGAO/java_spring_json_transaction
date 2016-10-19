package com.howtodoinjava.validutils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityValidator implements ConstraintValidator<IsValidCity, String> {

	public void initialize(IsValidCity constraintAnnotation) {

	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {

			return false;

		}
		if (value.matches("BeiJing|Liuan|Hefei|ShangHai")) {

			return true;

		} else {

			return false;
		}
	}

}
