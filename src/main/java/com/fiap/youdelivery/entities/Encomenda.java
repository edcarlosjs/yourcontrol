package com.fiap.youdelivery.entities;

import java.time.LocalDateTime;

import com.fiap.youdelivery.dto.EncomendaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_encomenda")
public class Encomenda {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_encomenda")
	private Long id;
	
	@Column(name = "nm_morador")
	@NotBlank(message= "Por favor! preencha o nome do morador")
	private String nm_morador;
	
	@Column(name = "nr_apartamento")
	@NotBlank(message= "Por favor! preencha o número do apartamento1")
	private String nr_apartamento;
	
	@Column(name = "ds_encomenda")
	@NotBlank(message= "Por favor! preencha a descrição da encomenda")
	private String encomenda;
	
	@Column(name = "sn_processado")
	private Boolean processado = false;
	
	@Column(name = "sn_retirada")
	private Boolean retirada = false;

	@Column(name = "dt_retirada")
    private LocalDateTime dtRetirada;

	
    @ManyToOne
    private Morador morador;

	public Encomenda() {
		
	}

	public Encomenda(Long id, String nm_morador, String nr_apartamento, String encomenda, Boolean processado, LocalDateTime dtRetirada, Boolean retirada) {
		this.id = id;
		this.nm_morador = nm_morador;
		this.nr_apartamento = nr_apartamento;
		this.encomenda = encomenda;
		this.processado = processado;
		this.dtRetirada = dtRetirada;
		this.retirada = retirada;
	}
	
	//CONSTRUTOR PARA RELACIONAMENTO COM O MÉTODO TOENTITTY DA CLASSE DTO
	public Encomenda(EncomendaDTO dto) {
		this.id = dto.getId();
		this.nm_morador = dto.getNm_morador();
		this.nr_apartamento = dto.getNr_apartamento();
		this.encomenda = dto.getEncomenda();
		this.processado = dto.getProcessado();
		this.dtRetirada = dto.getDtRetirada();
		this.retirada = dto.getRetirada();
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

	public Morador getMorador() {
		return morador;
	}

	public void setMorador(Morador morador) {
		this.morador = morador;
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
		Encomenda other = (Encomenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encomenda [id=" + id + ", nm_morador=" + nm_morador + ", nr_apartamento=" + nr_apartamento
				+ ", encomenda=" + encomenda + ", processado=" + processado + ", retirada=" + retirada + ", dtRetirada="
				+ dtRetirada + ", morador=" + morador + "]";
	}

	

}
