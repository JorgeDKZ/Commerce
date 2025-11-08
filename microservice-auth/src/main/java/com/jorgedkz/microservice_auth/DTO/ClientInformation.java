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

    private Long authId;
    private String name;
    private String surnames;
    private String email;
    private Long phone;

    @Override
    public String toString() {
        return "ClientInformation [email=" + email + ", name=" + name + ", phone=" + phone + ", surnames=" + surnames
                + ", userId=" + authId + "]";
    }
}
