package com.fiap.youdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.youdelivery.dto.EncomendaDTO;
import com.fiap.youdelivery.entities.Encomenda;
import com.fiap.youdelivery.service.EncomendaService;

@RestController
@RequestMapping("/encomenda")
public class EncomendaController {
	@Autowired
    private EncomendaService encomendaService;

    @PostMapping("/registro")
   // @PreAuthorize("hasRole('FUNCIONARIO')")
    public ResponseEntity<Encomenda> registrarEncomenda(@RequestBody EncomendaDTO encomendaDTO) {
        Encomenda encomenda = encomendaService.registrarEncomenda(encomendaDTO);
        return ResponseEntity.ok(encomenda);
    }
    
    @PutMapping("/baixa")
    public ResponseEntity<EncomendaDTO> darBaixaEncomenda(@RequestBody EncomendaDTO encomendaDTO) {
        Encomenda encomenda = encomendaService.darBaixaEncomenda(encomendaDTO.getId());
        return ResponseEntity.ok(EncomendaDTO.fromEntity(encomenda));
    }
    
//    @PutMapping("/baixa/{id}")
//    public ResponseEntity<Void> darBaixaEncomenda(@PathVariable Long id) {
//        encomendaService.darBaixaEncomenda(id);
//        return ResponseEntity.ok().build();
//    }
}

