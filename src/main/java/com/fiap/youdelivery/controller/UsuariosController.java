package com.fiap.youdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.youdelivery.dto.UsuariosDTO;
import com.fiap.youdelivery.service.UsuariosService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("")
public class UsuariosController {

	@Autowired
	private final UsuariosService usuariosService;

	
	public UsuariosController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	}

	@PostMapping("/registro")
	public ResponseEntity<UsuariosDTO> registrando (@RequestBody @Valid UsuariosDTO data) {
		UsuariosDTO savedUser = usuariosService.save(data);
		return ResponseEntity.ok(savedUser);
	}
	
//    @PostMapping("/registro")
//    public ResponseEntity<UsuariosDTO> cadastrarUsuario(@RequestBody UsuarioCadastroDTO usuarioCadastroDTO) {
//        UsuariosDTO novoUsuario = usuariosService.saveUsuarioComMoradorOuFuncionario(usuarioCadastroDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
//    }
}
