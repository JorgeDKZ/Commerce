package com.jorgedkz.microservice_auth.Enum;

public enum Roles {

    /**
     * Roles of the application
     * ADMIN: have the same permissions as User and can manage users
     * USER: can access to the resources of the application 
     */
    ADMIN("ADMIN"), 
    USER("USER");

    String role;

    Roles(String role) {
        this.role = role;
    }
}
