package com.jorgedkz.microservice_auth.component;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.nimbusds.jose.jwk.RSAKey;

@Component
public class RSAkeyProvider {

    public RSAKey key;

    public RSAkeyProvider() throws NoSuchAlgorithmException {
        // Create a new instante of generator of keys
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        // After generate the pair of kays
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // Separate the keys in public and private
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        this.key = new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();
    }

    public RSAKey getRsaKey() {
        return this.key;
    }

}
