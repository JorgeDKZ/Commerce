package com.jorgedkz.microservice_auth.service.interfaces;

import com.jorgedkz.microservice_auth.entities.Client;

/**
 * @author JorgeDKZ
 *         Interface that defines the methods of the ClientService
 */
public interface ClientServiceInterface {

    public Client encodeClientBufferPassword(Client client);

    public void saveClient(Client client);

    public Client findByClientName(String userName);

    public void validateClient(Client client);

    public void deleteClientByName(String clientName);

    public void deleteClientById(Long clientID);

    public void deleteClientByValidation(Client clientName);

    public String getRoles(String clientName);

    public boolean clientHasRole(String clientName, String role);
}
