package com.fiap.youdelivery.contrtoller;

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

import com.fiap.youdelivery.dto.MoradorDTO;
import com.fiap.youdelivery.service.MoradorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/morador")
public class MoradorController {
      
	//atributo
	private final MoradorService moradorService;

	
	
	public MoradorController (MoradorService moradorService) {
		this.moradorService = moradorService; 
	}

	@GetMapping  //Consultando todos os registros de morador
	public ResponseEntity<Page<MoradorDTO>>findAll(@RequestParam(value = "page", defaultValue = "0")Integer page, @RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		var morador = moradorService.findALL(pageRequest);
		return ResponseEntity.ok(morador);
	}
	
	@GetMapping("/{id}") //Consultando registros por id
	public ResponseEntity<MoradorDTO> findById(@PathVariable long id){
		var morador = moradorService.findById(id);
		return ResponseEntity.ok(morador);
	}
	
	
	@PostMapping //Gravando o registro 
	public ResponseEntity<MoradorDTO> save(@Valid @RequestBody MoradorDTO dto){
		var morador = moradorService.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand((morador.getId())).toUri(); //Boiler Plaet
		return ResponseEntity.created(uri).body(morador);	
	}
	
	@PutMapping("/{id}") //Atualizando informação por id
	public ResponseEntity<MoradorDTO> update(@Valid @RequestBody MoradorDTO dto, @PathVariable Long id){
		var morador = moradorService.update(id, dto);
		return ResponseEntity.ok(morador);
	}
	
	/*Ex.: Diferença de @PathVariable para @ RequestParam
	  RequestPARAM = //localhost:8080/morador?id=1
	  PathVariable = //localhost:8080/morador/1
	*/
	@DeleteMapping("/{id}") //Deletando registro por id
	public ResponseEntity<Void> delete(@PathVariable Long id){
		moradorService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

