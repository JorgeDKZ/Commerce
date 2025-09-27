package com.jorgedkz.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jorgedkz.orderservice.persistence.DTO.ClientDTO;

@FeignClient(name = "microservice-client", path = "/api/clients")
public interface ClientComunication {

    @GetMapping("/search/{id}")
    public ResponseEntity<ClientDTO> findUser(@PathVariable Long id);
    
}
