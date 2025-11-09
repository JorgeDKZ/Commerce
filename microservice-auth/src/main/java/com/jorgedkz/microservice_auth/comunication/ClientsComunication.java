package com.jorgedkz.microservice_auth.comunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.jorgedkz.microservice_auth.DTO.ClientInformation;

@FeignClient(name = "microservice-client", path = "/api/clients")
public interface ClientsComunication {

    @PostMapping("/create")
    public void addClient(ClientInformation client);
}
