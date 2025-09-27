package com.jorgedkz.client.microservice_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jorgedkz.client.microservice_client.entity.Client;
import com.jorgedkz.client.microservice_client.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Client entity) {
        clientService.save(entity);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id) {

        Client client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(client);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok(clientService.findAll());
    }
    

}
