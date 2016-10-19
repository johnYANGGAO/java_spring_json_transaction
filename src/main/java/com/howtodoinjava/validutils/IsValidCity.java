package com.howtodoinjava.validutils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CityValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidCity {
	
	String message() default "please provide a valid city ;"
			+ " accepted cities are beijing , liuan ,hefei ,shanghai (choose anyone) ";

	// Required by validation runtime
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
