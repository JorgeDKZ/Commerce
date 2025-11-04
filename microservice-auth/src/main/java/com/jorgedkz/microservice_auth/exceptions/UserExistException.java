package com.jorgedkz.microservice_auth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jorgedkz.microservice_auth.entities.DTO.UserBuffer;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserExistException extends RuntimeException {
    
    public UserExistException(UserBuffer user) {
        super("The user " + user.getUserName() + " already exists");
    }

}
