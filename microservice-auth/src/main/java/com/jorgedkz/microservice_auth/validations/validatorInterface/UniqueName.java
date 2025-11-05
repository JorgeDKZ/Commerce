package com.jorgedkz.client.microservice_client.validations.validatorInterface;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jorgedkz.client.microservice_client.validations.UniqueNameValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueNameValidation.class)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)

public @interface UniqueName {
    String message() default "That name is already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
