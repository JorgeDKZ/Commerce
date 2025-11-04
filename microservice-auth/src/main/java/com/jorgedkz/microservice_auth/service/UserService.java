package com.jorgedkz.microservice_auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jorgedkz.microservice_auth.entities.User;
import com.jorgedkz.microservice_auth.entities.DTO.UserBuffer;
import com.jorgedkz.microservice_auth.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean saveUser(UserBuffer user) {

        User dataUser = findByUserName(user.getUserName());
        if (dataUser == null) {
            User newUser = new User(user.getUserName(), encodeUserBufferPassword(user).getPassword(),
                    new String[] { "USER" });
            userRepository.save(newUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findById(userName).orElse(null);
    }

    @Override
    public boolean validateUser(UserBuffer user) {
        User dataUser = findByUserName(user.getUserName());

        if (dataUser == null || !passwordEncoder.matches(user.getPassword(), dataUser.getPassword())) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public String[] getRoles(String userName) {
        User user = findByUserName(userName);
        if (user != null) {
            return user.getRoles();
        } else {
            return null;
        }
    }

    @Override
    public UserBuffer encodeUserBufferPassword(UserBuffer user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return user;
    }

    @Override
    public boolean deleteUserByPassword(UserBuffer user) {
        if (validateUser(user)) {
            User buferUser = findByUserName(user.getUserName());
            buferUser.setEnabled(false);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUser(String userName) {
        User user = findByUserName(userName);
        if (user != null) {
            user.setEnabled(false);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean userHasRole(String userName, String role) {
        User user = findByUserName(userName);
        if (user != null) {
            List<String> roles = List.of(user.getRoles());
            return roles.contains(role);
        } else {
            return false;
        }
    }

}
