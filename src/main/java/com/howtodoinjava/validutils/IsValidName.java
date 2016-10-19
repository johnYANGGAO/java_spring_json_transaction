package com.howtodoinjava.validutils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ ElementType.FIELD })
@Constraint(validatedBy = NameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidName {

	// String listOfName () default "gaoyang";
	String listOfName();

	String message() default "permission denied , you have no rights to use this application";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
