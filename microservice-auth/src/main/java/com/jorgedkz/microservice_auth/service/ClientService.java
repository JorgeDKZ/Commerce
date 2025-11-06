package com.jorgedkz.microservice_auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jorgedkz.microservice_auth.entities.Client;
import com.jorgedkz.microservice_auth.exceptions.ClientServiceException;
import com.jorgedkz.microservice_auth.repository.ClientRepository;
import com.jorgedkz.microservice_auth.service.interfaces.ClientServiceInterface;

@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final boolean CLIENT_NOT_ENABLE = false;

    @Override
    public Client encodeClientBufferPassword(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return client;
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(encodeClientBufferPassword(client));
    }

    @Override
    public Client findByClientName(String userName) {
        return findByClientName(userName);
    }

    @Override
    public void validateClient(Client client) {
        if (!validate(client)) {
            throw new ClientServiceException("The client or the password is wrong");
        }
    }

    private boolean validate(Client client) {
        Client clientValided = findByClientName(client.getUserName());
        return !(clientValided == null || passwordEncoder.matches(client.getPassword(), clientValided.getPassword()));
    }

    @Override
    public void deleteClientByName(String clientName) {
        Client client = clientRepository.findByName(clientName);
        deleteClient(client);
    }

    @Override
    public void deleteClientById(Long clientID) {
        Client client = clientRepository.findById(clientID).get();
        deleteClient(client);
    }

    @Override
    public void deleteClientByValidation(Client clientName) {
        if (validate(clientName)) {
            throw new ClientServiceException("The client or the password is wrong");
        } else {
            deleteClient(clientName);
        }
    }

    private void deleteClient(Client client) {
        if (client == null) {
            throw new ClientServiceException("This client was removed");
        }
        if (!client.isEnable()) {
            throw new ClientServiceException("The client do not exist");
        }

        client.setEnable(CLIENT_NOT_ENABLE);
    }

    @Override
    public String getRoles(String clientName) {
        return clientRepository.findByName(clientName).getRole();
    }

    @Override
    public boolean clientHasRole(String clientName, String role) {
        String clientRole = clientRepository.findByName(clientName).getRole();

        return clientRole.equals(clientRole);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByClientId(Long userId) {
        return findByClientId(userId);
    }

}
