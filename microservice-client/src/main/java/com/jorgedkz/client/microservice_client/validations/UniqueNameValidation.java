package com.jorgedkz.client.microservice_client.validations;

import com.jorgedkz.client.microservice_client.entity.Client;
import com.jorgedkz.client.microservice_client.service.ClientService;
import com.jorgedkz.client.microservice_client.validations.validatorInterface.UniqueName;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueNameValidation implements ConstraintValidator<UniqueName, Client> {

    private ClientService clientService;

    public UniqueNameValidation(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean isValid(Client value, ConstraintValidatorContext context) {

        if (clientService.findByName(value.getName()) == null) {
            return true;
        }
        return false;
    }

}
