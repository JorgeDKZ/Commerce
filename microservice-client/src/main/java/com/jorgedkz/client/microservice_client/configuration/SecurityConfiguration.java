package com.jorgedkz.client.microservice_client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {

    /**
     * Password encoder bean
     * 
     * @return PasswordEncoder
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        // Create new password encoder
        return new BCryptPasswordEncoder();
    }
}
