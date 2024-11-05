package com.fiap.youdelivery.entities;

import com.fiap.youdelivery.dto.FuncionarioDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="tb_funcionario")
public class Funcionario {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
    private Long id;
	@Column(name = "nm_funcionario")
	@NotBlank(message="Por favor! preencha o nome")
    private String nome;
	@Column(name = "ds_funcao")
	@NotBlank(message="Por favor! preencha a função")
    private String funcao;
	@Column(name = "ds_turno")
	@NotBlank(message="Por favor! preencha o turno")
    private String turno;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_user")
//    private Usuarios usuarios;
	
     
     public Funcionario() {
		
	}


	public Funcionario(Long id, String nome, String funcao, String turno) {
		this.id = id;
		this.nome = nome;
		this.funcao = funcao;
		this.turno = turno;
	}

	//CONSTRUTOR PARA RELACIONAMENTO COM O MÉTODO TOENTITTY DA CLASSE DTO
	public Funcionario(FuncionarioDTO dto) {
		
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.funcao = dto.getFuncao();
		this.turno = dto.getTurno();
	
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

	

//	public Usuarios getUsuarios() {
//		return usuarios;
//	}
//
//
//	public void setUsuarios(Usuarios usuarios) {
//		this.usuarios = usuarios;
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", funcao=" + funcao + ", turno=" + turno
				+ "]";
	}
     
    
}
