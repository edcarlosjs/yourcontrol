package com.fiap.youdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.youdelivery.dto.NotificacaoDTO;
import com.fiap.youdelivery.service.NotificacaoService;

@RestController
@RequestMapping("/notificacoes")
public class NotificacaoController {
	@Autowired
	private NotificacaoService notificacaoService;

	@PutMapping("/confirmar")
	public ResponseEntity<NotificacaoDTO> confirmarRecebimento(@RequestBody NotificacaoDTO dto) {
		var notificacao = notificacaoService.confirmarRecebimento(dto.getId());
		return ResponseEntity.ok(NotificacaoDTO.fromEntity(notificacao));
	}

//    @PutMapping("/confirmar/{id}")
//    public ResponseEntity<Void> confirmarRecebimento(@PathVariable Long id) {
//        notificacaoService.confirmarRecebimento(id);
//        return ResponseEntity.ok().build();
//    }

}
