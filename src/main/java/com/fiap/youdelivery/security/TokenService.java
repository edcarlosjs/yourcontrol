package com.fiap.youdelivery.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.fiap.youdelivery.entities.Usuarios;

@Service
public class TokenService {

	
	@Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Usuarios usuarios){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                .withIssuer("youdelivery")
                .withSubject(usuarios.getUsername())
                .withExpiresAt(getExpirationDate())
                .sign(algorithm);
            return token;


        } catch (JWTCreationException e) {
           throw new RuntimeException("ERRO AO GERAR TOKEN", e);
       
        }
    }

        public String validateToken(String token){
            try {
                Algorithm algorithm = Algorithm.HMAC256(secret);

                return JWT.require(algorithm)
                    .withIssuer("youdelivery")
                    .build()
                    .verify(token)
                    .getSubject();
            } 
            
            catch (JWTVerificationException exception) {
                return "Falha na validação do Token";
            }
        }

        private Instant getExpirationDate(){
            return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
        }
    }
