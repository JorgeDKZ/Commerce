package com.jorgedkz.microservice_auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jorgedkz.microservice_auth.entities.Client;
import com.jorgedkz.microservice_auth.repository.ClientRepository;
import com.jorgedkz.microservice_auth.service.interfaces.ClientServiceInterface;

@Service
public class ClientService implements ClientServiceInterface{

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Client encodeClientBufferPassword(Client user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encodeClientBufferPassword'");
    }
    @Override
    public void saveUser(Client user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }
    @Override
    public Client findByUserName(String userName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUserName'");
    }
    @Override
    public void validateUser(Client user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateUser'");
    }
    @Override
    public void deleteUser(String userName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    @Override
    public void deleteUser(Long userID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    @Override
    public void deleteUser(Client userName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }
    @Override
    public String[] getRoles(String userName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoles'");
    }
    @Override
    public boolean userHasRole(String userName, String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'userHasRole'");
    }

}
