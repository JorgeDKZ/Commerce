package com.jorgedkz.microservice_auth.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserServiceException extends RuntimeException {
    
    public UserServiceException(String messaje) {
        super(messaje);
    }



}
