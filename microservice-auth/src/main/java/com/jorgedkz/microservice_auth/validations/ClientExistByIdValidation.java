package com.jorgedkz.microservice_auth.validations;

import com.jorgedkz.microservice_auth.service.ClientService;
import com.jorgedkz.microservice_auth.validations.validatorInterface.ClientExistById;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClientExistByIdValidation implements ConstraintValidator<ClientExistById, Long> {

    private ClientService clientService;

    public ClientExistByIdValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if (clientService.findByClientId(value) == null) {
            return false;
        }
        return true;
    }
}
