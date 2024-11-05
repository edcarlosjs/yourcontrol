package com.fiap.youdelivery.dto;

import com.fiap.youdelivery.entities.Funcionario;

public class FuncionarioDTO {
	     
	
	    private Long id;
	    private String nome;
	    private String funcao;
	    private String turno;
	    
	    
		public FuncionarioDTO() {

		}

		public FuncionarioDTO(Long id, String nome, String funcao, String turno) {
			this.id = id;
			this.nome = nome;
			this.funcao = funcao;
			this.turno = turno;
		}
		
	

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getFuncao() {
			return funcao;
		}

		public void setFuncao(String funcao) {
			this.funcao = funcao;
		}

		public String getTurno() {
			return turno;
		}

		public void setTurno(String turno) {
			this.turno = turno;
		}
	    
		//Método estático para receber o DTO e transformar em um ENTTITY
		public static Funcionario toEntity(FuncionarioDTO dto) {
			return new Funcionario(dto);
		}
	    
		//Método inverso de transformação do ENTITY para o DTO
		public static FuncionarioDTO fromEntity(Funcionario funcionario) {
		    return new FuncionarioDTO(funcionario.getId(),funcionario.getNome(),funcionario.getFuncao(),funcionario.getTurno());
		}
		
		//Método Mapper para receber tanto dto quanto o entity para uttilizar no update por exemolo
		public static Funcionario mapperDtoToEntity(FuncionarioDTO dto, Funcionario entity) {
			entity.setNome(dto.getNome());
			entity.setFuncao(dto.getFuncao());
			entity.setTurno(dto.getTurno());
			return entity;
		}
	    
}
