package com.jorgedkz.microservice_auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgedkz.microservice_auth.entities.DTO.UserBuffer;
import com.jorgedkz.microservice_auth.exceptions.UserBadValidation;
import com.jorgedkz.microservice_auth.exceptions.UserExistException;
import com.jorgedkz.microservice_auth.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/securityLogin")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody UserBuffer entity) {
        if (userService.validateUser(entity)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            throw new UserBadValidation();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserBuffer entity) {
        if (userService.saveUser(entity)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            throw new UserExistException(entity);
        }
    }


}
