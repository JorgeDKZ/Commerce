package com.jorgedkz.microservice_auth.validations;

import com.jorgedkz.microservice_auth.service.ClientService;
import com.jorgedkz.microservice_auth.validations.validatorInterface.ClientExistByName;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientExistByNameValidation implements ConstraintValidator<ClientExistByName, String> {

    private ClientService clientService;

    public ClientExistByNameValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (clientService.findByClientName(value) == null) {
            return false;
        }
        return true;
    }
}
