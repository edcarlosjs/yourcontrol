package com.fiap.youdelivery.dto;

import com.fiap.youdelivery.entities.Morador;

public class MoradorDTO {

	
	private Long id;
	private String morador;
	private String cpf;
	private String telefone;
	private String celular;
	private String email;
	private String apartamento;
	
	
	//Contrutor vazio da classe DTO
	public MoradorDTO() {

	}
    //Construtor populado da classe DTO
	public MoradorDTO(Long id, String morador, String cpf, String telefone, String celular, String email,
			String apartamento) {
		this.id = id;
		this.morador = morador;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.apartamento = apartamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMorador() {
		return morador;
	}

	public void setMorador(String morador) {
		this.morador = morador;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}
	
	
	//Método estático para receber o DTO e transformar em um ENTTITY
	public static Morador toEntity(MoradorDTO dto) {
		return new Morador(dto);
	}
    
	//Método inverso de transformação do ENTITY para o DTO
	public static MoradorDTO fromEntity(Morador morador) {
	    return new MoradorDTO(morador.getId(),morador.getMorador(),morador.getCpf(),morador.getTelefone(),morador.getCelular(),morador.getEmail(),morador.getApartamento());
	}
	
	//Método Mapper para receber tanto dto quanto o entity para uttilizar no update por exemolo
	public static Morador mapperDtoToEntity(MoradorDTO dto, Morador entity) {
		entity.setMorador(dto.getMorador());
		entity.setCpf(dto.getCpf());
		entity.setTelefone(dto.getTelefone());
		entity.setCelular(dto.getCelular());
		entity.setEmail(dto.getEmail());
		entity.setApartamento(dto.getApartamento());
		return entity;
	}
	
}
