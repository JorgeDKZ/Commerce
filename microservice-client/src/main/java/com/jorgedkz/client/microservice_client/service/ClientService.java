package com.jorgedkz.client.microservice_client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgedkz.client.microservice_client.entity.Client;
import com.jorgedkz.client.microservice_client.persistence.ClientRepository;

@Service
public class ClientService implements InterfaceClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client findByName(String name){
        return clientRepository.findByName(name);
    }


}
