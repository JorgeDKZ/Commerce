package com.jorgedkz.microservice_auth.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientInformation {

    private Long userId;
    private String name;
    private String surnames;
    private String email;
    private Long phone;
}
