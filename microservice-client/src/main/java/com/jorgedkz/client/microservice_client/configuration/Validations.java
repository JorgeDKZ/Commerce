package com.jorgedkz.client.microservice_client.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jorgedkz.client.microservice_client.service.ClientService;
import com.jorgedkz.client.microservice_client.validations.ClientExistByIdValidation;
import com.jorgedkz.client.microservice_client.validations.ClientExistByNameValidation;
import com.jorgedkz.client.microservice_client.validations.UniqueNameValidation;

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
