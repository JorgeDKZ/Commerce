package com.jorgedkz.microservice_auth.service.interfaces;

import com.jorgedkz.microservice_auth.entities.Client;

/**
 * @author JorgeDKZ
 *         Interface that defines the methods of the ClientService
 */
public interface ClientServiceInterface {

    public Client encodeClientBufferPassword(Client user);

    public void saveUser(Client user);

    public Client findByUserName(String userName);

    public void validateUser(Client user);

    public void deleteUser(String userName);

    public void deleteUser(Long userID);

    public void deleteUser(Client userName);

    public String[] getRoles(String userName);

    public boolean userHasRole(String userName, String role);
}
