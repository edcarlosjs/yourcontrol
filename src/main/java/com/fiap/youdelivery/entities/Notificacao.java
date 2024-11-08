package com.fiap.youdelivery.entities;

import java.time.LocalDateTime;

import com.fiap.youdelivery.dto.NotificacaoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_notificacao")
public class Notificacao {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    
    @Column(name = "mensagem")
    private String mensagem;
    @Column(name = "sn_confirmado")
    private Boolean confirmado = false;
    @Column(name = "dt_envio")
    private LocalDateTime dataEnvio;
    @Column(name = "dt_confirmacao")
    private LocalDateTime dataConfirmacao;
    
    @ManyToOne
    private Morador morador;
	
    public Notificacao() {
		
	}

	public Notificacao(Long id, Morador morador, String mensagem, Boolean confirmado, LocalDateTime dataEnvio,
			LocalDateTime dataConfirmacao) {
		this.id = id;
		this.morador = morador;
		this.mensagem = mensagem;
		this.confirmado = confirmado;
		this.dataEnvio = dataEnvio;
		this.dataConfirmacao = dataConfirmacao;
	}
	
	public Notificacao(NotificacaoDTO dto) {
		this.id = dto.getId();
		this.mensagem = dto.getMensagem();
		this.confirmado = dto.getConfirmado();
		this.dataEnvio = dto.getDataEnvio();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
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

	public LocalDateTime getDataConfirmacao() {
		return dataConfirmacao;
	}

	public void setDataConfirmacao(LocalDateTime dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
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
		Notificacao other = (Notificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Noticacao [id=" + id + ", morador=" + morador + ", mensagem=" + mensagem + ", confirmado=" + confirmado
				+ ", dataEnvio=" + dataEnvio + ", dataConfirmacao=" + dataConfirmacao + "]";
	}
	
}
