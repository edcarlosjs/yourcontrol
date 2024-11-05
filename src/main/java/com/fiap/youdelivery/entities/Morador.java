package com.fiap.youdelivery.entities;

import com.fiap.youdelivery.dto.MoradorDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
/**
 * @author Ed Carlos
 * @implNote: Entidade morador 
 */

@Entity
@Table(name="tb_morador")
public class Morador {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_morador")
	private Long id;
	@Column(name = "nm_morador")
	private String morador;
	@Column(name = "cpf")
	@Size(max = 11, message = "Tamanho máximo do campo é de 11 caracteres")
	private String cpf;
	@Column(name = "nr_telefone")
	private String telefone;
	@Column(name = "nr_celular")
	@NotBlank(message= "Por favor! preencha as numero de celular")
	private String celular;
	@Column(name = "email")
	@NotBlank(message= "Por favor! preencha o email")
	private String email;
	@Column(name = "nr_apartamento")
	@NotBlank(message= "Por favor! preencha o número do apartamento")
	private String apartamento;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_user")
//    private Usuarios usuarios;
	
	//CONSTRUTOR VAZIO DA CLASSE MORADOR
	public Morador () {
		
	}
    //CONSTTRUTOR POPULADO DA CLASSE MORADOR
	public Morador(Long id, String morador, String cpf, String telefone, String celular, String email,
			String apartamento) {
		this.id = id;
		this.morador = morador;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.apartamento = apartamento;
	}
	
	
	//CONSTRUTOR PARA RELACIONAMENTO COM O MÉTODO TOENTITTY DA CLASSE DTO
	public Morador(MoradorDTO dto) {
		this.id = dto.getId();
		this.morador = dto.getMorador();
		this.cpf = dto.getCpf();
		this.telefone = dto.getTelefone();
		this.celular = dto.getCelular();
		this.email = dto.getEmail();
		this.apartamento = dto.getApartamento();
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
	
	
//	public Usuarios getUsuarios() {
//		return usuarios;
//	}
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
		Morador other = (Morador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Morador [id=" + id + ", morador=" + morador + ", cpf=" + cpf + ", telefone=" + telefone + ", celular="
				+ celular + ", email=" + email + ", apartamento=" + apartamento + "]";
	}
	
	
	
}
