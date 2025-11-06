package com.jorgedkz.microservice_auth.validations;

import com.jorgedkz.microservice_auth.entities.Client;
import com.jorgedkz.microservice_auth.service.ClientService;
import com.jorgedkz.microservice_auth.validations.validatorInterface.UniqueName;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidation implements ConstraintValidator<UniqueName, Client> {

    private ClientService clientService;

    public UniqueNameValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(Client value, ConstraintValidatorContext context) {

        if (clientService.findByClientName(value.getUserName()) == null) {
            return true;
        }
        return false;
    }

}
