package com.jorgedkz.microservice_auth.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jorgedkz.microservice_auth.component.RSAkeyProvider;
import com.nimbusds.jose.jwk.RSAKey;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/key")
public class JwtkeyController {

    private RSAkeyProvider key;

    public JwtkeyController(RSAkeyProvider key) {
        this.key = key;
    }

    @GetMapping("/.wellKnown/jwks.json")
    public ResponseEntity<RSAKey> getPublicKey() {

        RSAKey publicKey = key.getRsaKey().toPublicJWK();
        return ResponseEntity.ok().body(publicKey);
    }

}
