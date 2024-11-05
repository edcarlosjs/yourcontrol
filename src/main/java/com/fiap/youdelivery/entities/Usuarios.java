package com.fiap.youdelivery.entities;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fiap.youdelivery.dto.UsuariosDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="tb_usuario")
public class Usuarios implements UserDetails  {

	private static final long serialVersionUID = 1192067998596535552L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "papel", nullable = false)
	@Enumerated(EnumType.STRING)
	private PapelUsuario papel;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = true, updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = true)
    private Date updatedAt;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_funcionario")
//    private Funcionario funcionario;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_morador")
//    private Morador morador;

	//CONSTRUTOR VAZIO DA CLASSE USUARIO
	public Usuarios() {
	
	}
	
	//CONSTRUTOR POPULADO DA CLASSE USUARIO
	public Usuarios(String username, String senha, PapelUsuario papel) {
		this.username = username;
		this.senha = senha;
		this.papel = papel;
	}
	
	
	//CONSTRUTOR PARA RELACIONAMENTO COM O MÉTODO TO ENTITY DA CLASSE USUARIO
	public Usuarios(UsuariosDTO dto) {
		this.username = dto.getUsername();
		this.senha = dto.getPassword();
		this.papel = dto.getPapel();
	}
	
	
	
	
	
	public Long getId_user() {
		return id_user;
	}



	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}


    @Override
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



	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String getUsername() {
		return username;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
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
		Usuarios other = (Usuarios) obj;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Usuarios [id_user=" + id_user + ", username=" + username + ", senha=" + senha + ", papel=" + papel
				+ "]";
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.papel  == PapelUsuario.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}


}
