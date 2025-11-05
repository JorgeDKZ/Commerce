package com.jorgedkz.microservice_auth.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "clients")
public class ClientInformation {

    private Long userId;
    private String name;
    private String surnames;
    private String password;
    private String email;
    private Long phone;
}
