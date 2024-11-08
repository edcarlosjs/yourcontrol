package com.fiap.youdelivery.dto;

import java.time.LocalDateTime;

import com.fiap.youdelivery.entities.Encomenda;


public class EncomendaDTO {
	
	private Long id;
	private String nm_morador;
	private String nr_apartamento;
	private String encomenda;
	private Boolean processado = false;
	private Boolean retirada = false;
    private LocalDateTime dtRetirada;

	
	public EncomendaDTO() {
		
	}

	public EncomendaDTO(Long id, String nm_morador, String nr_apartamento, String encomenda, Boolean processado, LocalDateTime dtRetirada, Boolean retirada) {
		this.id = id;
		this.nm_morador = nm_morador;
		this.nr_apartamento = nr_apartamento;
		this.encomenda = encomenda;
		this.processado = processado;
		this.dtRetirada = dtRetirada;
		this.retirada = retirada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNm_morador() {
		return nm_morador;
	}

	public void setNm_morador(String nm_morador) {
		this.nm_morador = nm_morador;
	}

	public String getNr_apartamento() {
		return nr_apartamento;
	}

	public void setNr_apartamento(String nr_apartamento) {
		this.nr_apartamento = nr_apartamento;
	}

	public String getEncomenda() {
		return encomenda;
	}

	public void setEncomenda(String encomenda) {
		this.encomenda = encomenda;
	}

	public Boolean getProcessado() {
		return processado;
	}

	public void setProcessado(Boolean processado) {
		this.processado = processado;
	}
	
	
	public Boolean getRetirada() {
		return retirada;
	}

	public void setRetirada(Boolean retirada) {
		this.retirada = retirada;
	}

	public LocalDateTime getDtRetirada() {
		return dtRetirada;
	}

	public void setDtRetirada(LocalDateTime dtRetirada) {
		this.dtRetirada = dtRetirada;
	}

	//Método estático para receber o DTO e transformar em um ENTTITY
	public static Encomenda toEntity(EncomendaDTO dto) {
		return new Encomenda(dto);
	}
    
	//Método inverso de transformação do ENTITY para o DTO
	public static EncomendaDTO fromEntity(Encomenda encomenda) {
	    return new EncomendaDTO(encomenda.getId(),encomenda.getNm_morador(),encomenda.getNr_apartamento(),encomenda.getEncomenda(),encomenda.getProcessado(), encomenda.getDtRetirada(), encomenda.getRetirada());
	}
	
	//Método Mapper para receber tanto dto quanto o entity para uttilizar no update por exemolo
	public static Encomenda mapperDtoToEntity(EncomendaDTO dto, Encomenda entity) {
		entity.setNm_morador(dto.getNm_morador());
		entity.setNr_apartamento(dto.getNr_apartamento());
		entity.setEncomenda(dto.getEncomenda());
		entity.setProcessado(dto.getProcessado());
		return entity;
	}
	
}
