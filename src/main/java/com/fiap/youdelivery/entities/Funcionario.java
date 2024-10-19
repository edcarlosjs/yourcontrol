package com.fiap.youdelivery.entities;

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
    private String funcionario;
	@Column(name = "ds_funcao")
	@NotBlank(message="Por favor! preencha a função")
    private String funcao;
	@Column(name = "ds_turno")
	@NotBlank(message="Por favor! preencha o turno")
    private String turno;
	
     
     public Funcionario() {
		
	}


	public Funcionario(Long id, String funcionario, String funcao, String turno) {
		this.id = id;
		this.funcionario = funcionario;
		this.funcao = funcao;
		this.turno = turno;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
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
		return "Funcionario [id=" + id + ", funcionario=" + funcionario + ", funcao=" + funcao + ", turno=" + turno
				+ "]";
	}
     
    
}
