package com.jorgedkz.client.microservice_client.validations;

import com.jorgedkz.client.microservice_client.service.ClientService;
import com.jorgedkz.client.microservice_client.validations.validatorInterface.ClientExistById;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientExistByIdValidation implements ConstraintValidator<ClientExistById, Long> {

    private ClientService clientService;

    public ClientExistByIdValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if (clientService.findById(value) == null) {
            return false;
        }
        return true;
    }
}
