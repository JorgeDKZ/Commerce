package com.jorgedkz.microservice_auth.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * UserBuffer class to receive the user data from the client
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserBuffer {

    private String userName;
    private String password;
}
