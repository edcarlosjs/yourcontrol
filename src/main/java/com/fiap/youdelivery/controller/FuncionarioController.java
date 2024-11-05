package com.fiap.youdelivery.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fiap.youdelivery.dto.FuncionarioDTO;
import com.fiap.youdelivery.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
      
	//atributo
	private final FuncionarioService funcionarioService;

	
	
	public FuncionarioController (FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService; 
	}

	@GetMapping  //Consultando todos os registros de morador
	public ResponseEntity<Page<FuncionarioDTO>>findAll(@RequestParam(value = "page", defaultValue = "0")Integer page, @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		var funcionario = funcionarioService.findALL(pageRequest);
		return ResponseEntity.ok(funcionario);
	}
	
	@GetMapping("/{id}") //Consultando registros por id
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable long id){
		var funcionario = funcionarioService.findById(id);
		return ResponseEntity.ok(funcionario);
	}
	
	
	@PostMapping //Gravando o registro 
	public ResponseEntity<FuncionarioDTO> save(@Valid @RequestBody FuncionarioDTO dto){
		var funcionario = funcionarioService.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((funcionario.getId())).toUri(); //Boiler Plate
		return ResponseEntity.created(uri).body(funcionario);	
	}
	
	@PutMapping("/{id}") //Atualizando informação por id
	public ResponseEntity<FuncionarioDTO> update(@Valid @RequestBody FuncionarioDTO dto, @PathVariable Long id){
		var funcionario = funcionarioService.update(id, dto);
		return ResponseEntity.ok(funcionario);
	}
	
	/*Ex.: Diferença de @PathVariable para @ RequestParam
	  RequestPARAM = //localhost:8080/morador?id=1
	  PathVariable = //localhost:8080/morador/1
	*/
	@DeleteMapping("/{id}") //Deletando registro por id
	public ResponseEntity<Void> delete(@PathVariable Long id){
		funcionarioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

