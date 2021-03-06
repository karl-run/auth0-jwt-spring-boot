package com.github.jwt.auth0.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

@Getter
@Service
public class Auth0JwtConfig {

    @Value("${basic-auth.username:}")
    private String username;

    @Value("${basic-auth.password:}")
    private String password;

    @Value("${jwt-secret:}")
    private String jwtSecret;

    @Value("${jwt-secret-encoded:true}")
    private String jwtSecretEncoded;

    @Value("${jwt-key:jwt}")
    private String jwtKey;

    public boolean isJwtSecretEncoded() {
        return Boolean.valueOf(jwtSecretEncoded);
    }

    public byte[] getSecret() {
        if (isJwtSecretEncoded()) {
            return Base64Utils.decodeFromUrlSafeString(jwtSecret);
        } else {
            return jwtSecret.getBytes();
        }
    }

}
