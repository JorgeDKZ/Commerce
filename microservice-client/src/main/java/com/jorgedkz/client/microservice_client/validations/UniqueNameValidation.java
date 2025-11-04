package com.jorgedkz.client.microservice_client.validations;

import com.jorgedkz.client.microservice_client.service.ClientService;
import com.jorgedkz.client.microservice_client.validations.validatorInterface.UniqueName;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidation implements ConstraintValidator<UniqueName, String> {

    private ClientService clientService;

    public UniqueNameValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {


        
    }

}
