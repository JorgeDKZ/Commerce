package com.jorgedkz.microservice_auth.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.jorgedkz.microservice_auth.component.RSAkeyProvider;
import com.jorgedkz.microservice_auth.entities.Client;
import com.nimbusds.jose.JOSEException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.InvalidKeyException;


@Service
public class TokenCreation {

    RSAkeyProvider RSAKey;

    public TokenCreation(RSAkeyProvider RSAKey) {
        this.RSAKey = RSAKey;
    }

    public String getToken(Client client) throws InvalidKeyException, JOSEException {
        //One hour
        final long time = 3600000;

        return Jwts.builder()
                .setSubject(client.getUserName())
                .claim("role", client.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + time))
                .signWith(RSAKey.getRsaKey().toPrivateKey(), SignatureAlgorithm.RS256)
                .setHeaderParam("kid", RSAKey.getRsaKey().getKeyID())
                .compact();
    }
}
