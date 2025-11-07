package com.jorgedkz.microservice_auth.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientFullInformation {

    @NotBlank
    @NotNull
    @Size(min = 5)
    private String userName;
    @NotBlank
    @NotNull
    @Size(min = 3)
    private String name;
    @NotBlank
    @NotNull
    @Size(min = 3)
    private String surnames;
    @NotBlank
    @NotNull
    @Size(min = 8)
    private String password;
    @Email
    private String email;
    private long phone;
}
