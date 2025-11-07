package com.jorgedkz.client.microservice_client.service;

import java.util.List;

import com.jorgedkz.client.microservice_client.entity.Client;

public interface InterfaceClientService {

    public List<Client> findAll();

    public Client findById(Long id);

    public void save(Client client);

    public Client findByName(String name);

}
