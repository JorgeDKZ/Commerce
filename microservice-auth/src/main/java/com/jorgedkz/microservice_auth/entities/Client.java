package com.jorgedkz.microservice_auth.entities;

import com.jorgedkz.microservice_auth.Enum.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String role;
    private boolean isEnable;

    public Client(String userName, String password,Roles role){
        this.userName = userName;
        this.password = password;
        this.role = role.name();
        this.isEnable = true;

    }
}