package com.jorgedkz.microservice_auth.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jorgedkz.microservice_auth.component.RSAkeyProvider;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.RSAKey;

import java.util.Date;

@Service
public class JwtService {

    /**
     * Expiration time in milliseconds for the JWT token
     */
    @Value("${jwt.expiration}")
    private Long expirationTime;

    /**
     * RSA Key for signing the JWT token
     */
    private RSAKey rsaKey;

    public JwtService(RSAkeyProvider rsa) {
        this.rsaKey = rsa.getRsaKey();
    }

    /**
     * This method extract the username from a JWT token
     * @param token - the JWT token of the user
     * @return String - the username of the user
     * @throws SignatureException
     * @throws ExpiredJwtException
     * @throws UnsupportedJwtException
     * @throws MalformedJwtException
     * @throws IllegalArgumentException
     * @throws JOSEException
     */
    public String extractUsername(String token) throws SignatureException, ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, IllegalArgumentException, JOSEException {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    /**
     * This method extract the roles of a JWT token
     * @param token - the JWT token of the user
     * @return String - the roles of the user
     * @throws SignatureException
     * @throws ExpiredJwtException
     * @throws UnsupportedJwtException
     * @throws MalformedJwtException
     * @throws IllegalArgumentException
     * @throws JOSEException
     */
    public String extractRoles(String token) throws SignatureException, ExpiredJwtException,
            UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, JOSEException {
        Claims claims = extractAllClaims(token);
        return claims.get("role", String.class);
    }

    /**
     * This method check if a JWT token is valid
     * @param token - the JWT token of the user
     * @return boolean - true if the token is valid, false otherwise
     */
    public boolean isTokenValid(String token) {
        try {
            Claims claims = extractAllClaims(token);
            Date expiration = claims.getExpiration();
            return expiration.after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method extract all claims of a JWT token
     * @param token - the JWT token of the user
     * @return Claims - all claims of the JWT token
     * @throws SignatureException
     * @throws ExpiredJwtException
     * @throws UnsupportedJwtException
     * @throws MalformedJwtException
     * @throws IllegalArgumentException
     * @throws JOSEException
     */
    private Claims extractAllClaims(String token) throws SignatureException, ExpiredJwtException,
            UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, JOSEException {
        return Jwts.parserBuilder()
                .setSigningKey(rsaKey.toPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * This method generate a JWT token
     * @param username - the username of the client
     * @param role - the role of the client
     * @return String - the JWT token
     * @throws InvalidKeyException
     * @throws JOSEException
     */
    public String generateToken(String username, String role) throws InvalidKeyException, JOSEException {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(new Date().toInstant().plusMillis(expirationTime)))
                .signWith(rsaKey.toPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }
}