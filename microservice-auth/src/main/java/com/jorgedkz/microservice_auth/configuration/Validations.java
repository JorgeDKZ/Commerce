package com.jorgedkz.microservice_auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jorgedkz.microservice_auth.service.ClientService;
import com.jorgedkz.microservice_auth.validations.ClientExistByIdValidation;
import com.jorgedkz.microservice_auth.validations.ClientExistByNameValidation;
import com.jorgedkz.microservice_auth.validations.UniqueNameValidation;

@Configuration
public class Validations {

    @Autowired
    private ClientService clientService;

    @Bean
    public UniqueNameValidation createUniqueNameValidation() {
        return new UniqueNameValidation(clientService);
    }

    @Bean
    public ClientExistByIdValidation createClientExistByIdValidation() {
        return new ClientExistByIdValidation(clientService);
    }

    @Bean
    public ClientExistByNameValidation createClientExistByNameValidation() {
        return new ClientExistByNameValidation(clientService);
    }

}
