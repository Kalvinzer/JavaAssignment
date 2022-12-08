package com.example.javaassignment.web.dto.validation.annotation;

import com.example.javaassignment.web.dto.validation.impl.NumberValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NumberValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnsureNumber {

  String message() default "Invalid number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
