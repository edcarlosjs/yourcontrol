package com.fiap.youdelivery.dto;

import java.time.LocalDateTime;

import com.fiap.youdelivery.entities.Notificacao;

public class NotificacaoDTO {
	
	private Long id;
    private String mensagem;
    private Boolean confirmado;
    private LocalDateTime dataEnvio;
    private Long id_morador;

    
    public NotificacaoDTO() {
	
	}


	public NotificacaoDTO(Long id, String mensagem, Boolean confirmado, LocalDateTime dataEnvio, Long id_morador) {
		this.id = id;
		this.mensagem = mensagem;
		this.confirmado = confirmado;
		this.dataEnvio = dataEnvio;
		this.id_morador = id_morador;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public Boolean getConfirmado() {
		return confirmado;
	}


	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}


	public LocalDateTime getDataEnvio() {
		return dataEnvio;
	}


	public void setDataEnvio(LocalDateTime dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
    
	
	
	public Long getId_morador() {
		return id_morador;
	}


	public void setId_morador(Long id_morador) {
		this.id_morador = id_morador;
	}


	//Método estático para receber o DTO e transformar em um ENTTITY
	public static Notificacao toEntity(NotificacaoDTO dto) {
		return new Notificacao(dto);
	}
    
	//Método inverso de transformação do ENTITY para o DTO
	public static NotificacaoDTO fromEntity(Notificacao notificacao) {
		Long idmorador = notificacao.getMorador() != null ? notificacao.getMorador().getId() : null;
	    return new NotificacaoDTO(notificacao.getId(),notificacao.getMensagem(),notificacao.getConfirmado(),notificacao.getDataEnvio(), idmorador);
	}
	
	//Método Mapper para receber tanto dto quanto o entity para uttilizar no update por exemolo
	public static Notificacao mapperDtoToEntity(NotificacaoDTO dto, Notificacao entity) {
	    entity.setMensagem(dto.getMensagem());
	    entity.setConfirmado(dto.getConfirmado());
	    entity.setDataEnvio(dto.getDataEnvio());
		return entity;
	}
	
    

    

}
