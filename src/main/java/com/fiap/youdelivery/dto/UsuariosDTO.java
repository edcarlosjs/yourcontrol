package com.fiap.youdelivery.dto;

import com.fiap.youdelivery.entities.PapelUsuario;
import com.fiap.youdelivery.entities.Usuarios;

public class UsuariosDTO {

	
	private String username;
	private String senha; 
	private PapelUsuario papel;
	
	public UsuariosDTO() {

	}

	public UsuariosDTO(String username, String senha, PapelUsuario papel) {
		this.username = username;
		this.senha = senha;
		this.papel = papel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return senha;
	}

	public void setPassword(String senha) {
		this.senha = senha;
	}

	public PapelUsuario getPapel() {
		return papel;
	}

	public void setPapel(PapelUsuario papel) {
		this.papel = papel;
	}
	
	//Método estático para receber o DTO e transformar em um ENTTITY
		public static Usuarios toEntity(UsuariosDTO dto) {
			return new Usuarios (dto);
		}
	    
		//Método inverso de transformação do ENTITY para o DTO
		public static UsuariosDTO fromEntity(Usuarios usuario) {
		    return new UsuariosDTO(usuario.getUsername(),usuario.getPassword(),usuario.getPapel());
		}
		
		//Método Mapper para receber tanto dto quanto o entity para uttilizar no update por exemolo
		public static Usuarios mapperDtoToEntity(UsuariosDTO dto, Usuarios entity) {
			entity.setUsername(dto.getUsername());
		    entity.setPassword(dto.getPassword());
		    entity.setPapel(dto.getPapel());
			return entity;
		}
	
}
