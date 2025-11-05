package com.jorgedkz.client.microservice_client.validations;

import com.jorgedkz.client.microservice_client.service.ClientService;
import com.jorgedkz.client.microservice_client.validations.validatorInterface.ClientExistByName;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientExistByNameValidation implements ConstraintValidator<ClientExistByName, String> {

    private ClientService clientService;

    public ClientExistByNameValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (clientService.findByName(value) == null) {
            return false;
        }
        return true;
    }
}
