package com.foro.hub.service.imp;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.foro.hub.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    String valor = System.getenv("JWT_SECRET");
    
    public String generarToken(Usuario usuario)
    {
        try {
            Algorithm algorithm = Algorithm.HMAC256(valor);
            return  JWT.create()
                    .withIssuer("foro hub")
                    .withSubject(usuario.getNombre())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException(exception);
        }
    }

    public String getSubject(String token) {
        if (token == null){
            throw new RuntimeException();
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm =  Algorithm.HMAC256(valor);
            verifier = JWT.require(algorithm)
                    .withIssuer("foro hub")
                    .build()
                    .verify(token);
            verifier.getSubject();

        } catch (JWTVerificationException exception){
        }
        if (verifier.getSubject() == null){
            throw new RuntimeException("verificacion no válida");
        }
        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusMinutes(5).toInstant(ZoneOffset.of("-05:00"));
    }
}
