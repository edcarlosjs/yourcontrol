package com.fiap.youdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.youdelivery.dto.AutenticacaoDTO;
import com.fiap.youdelivery.dto.TokenResponseDTO;
import com.fiap.youdelivery.entities.Usuarios;
import com.fiap.youdelivery.security.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("")
public class AutenticacaoController {


    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<Object> login (@RequestBody @Valid  AutenticacaoDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuarios) auth.getPrincipal());
        return ResponseEntity.ok(new TokenResponseDTO(token));
    }
	
}
