package com.jorgedkz.microservice_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgedkz.microservice_auth.DTO.ClientFullInformation;
import com.jorgedkz.microservice_auth.DTO.ClientInformation;
import com.jorgedkz.microservice_auth.Enum.Roles;
import com.jorgedkz.microservice_auth.client.ClientsComunication;
import com.jorgedkz.microservice_auth.entities.Client;
import com.jorgedkz.microservice_auth.service.ClientService;
import com.jorgedkz.microservice_auth.service.JwtService;
import com.jorgedkz.microservice_auth.validations.validatorInterface.UniqueName;
import com.nimbusds.jose.JOSEException;

import io.jsonwebtoken.security.InvalidKeyException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private ClientService userService;
    @Autowired
    private ClientsComunication clientsComunication;
    @Autowired
    private JwtService tokenCreation;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public void loginUser(@UniqueName @RequestBody ClientFullInformation entity) {
        Client newClient = new Client(entity.getUserName(), entity.getPassword(), Roles.USER);
        userService.saveClient(newClient);
        newClient = userService.findByClientName(newClient.getUserName());
        ClientInformation newInformationCliente = new ClientInformation(newClient.getId(), entity.getName(),
                entity.getSurnames(), entity.getEmail(), entity.getPhone());
        clientsComunication.addClient(newInformationCliente);

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@UniqueName @RequestBody ClientFullInformation entity)
            throws InvalidKeyException, JOSEException {
        // Create a new user to auth database
        Client newClient = new Client(entity.getUserName(), entity.getPassword(), Roles.USER);
        userService.saveClient(newClient);
        //Find client to get id
        newClient = userService.findByClientName(newClient.getUserName());
        // Create a new user to user database
        ClientInformation newInformationCliente = new ClientInformation(newClient.getId(), entity.getName(),
                entity.getSurnames(), entity.getEmail(), entity.getPhone());
        clientsComunication.addClient(newInformationCliente);

        System.out.println("Registered client: " + newInformationCliente.toString());
        return new ResponseEntity<String>(tokenCreation.generateToken(newClient.getUserName(), newClient.getRole()),
                HttpStatus.CREATED);
    }

}
