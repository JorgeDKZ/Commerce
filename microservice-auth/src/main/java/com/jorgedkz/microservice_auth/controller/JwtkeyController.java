package com.jorgedkz.microservice_auth.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jorgedkz.microservice_auth.component.RSAkeyProvider;
import com.nimbusds.jose.jwk.RSAKey;

import java.util.List;
import java.util.Map;

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
    public Map<String, Object> getPublicKey() {

        RSAKey publicKey = key.getRsaKey().toPublicJWK();
        return Map.of("keys", List.of(publicKey.toJSONObject()));
    }

}
