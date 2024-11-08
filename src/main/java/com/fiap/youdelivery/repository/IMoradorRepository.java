package com.fiap.youdelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fiap.youdelivery.entities.Morador;

@Repository
public interface IMoradorRepository extends JpaRepository<Morador, Long>{
	
	Optional<Morador> findByEmail(String email);
  //CRIANDO UMA CONSULTA JPQL PARA RETORNAR O E-MAIL ATRAVÉS DO NOME DO MORADOR
  //SERÁ UTILIZADO NA REGRA DE NEGÓCIO DA SERVICE PARA DISPPARO DE NOTIFICAÇÃO DE CHEGADA DE ENCOMENDA
	@Query("SELECT m.email FROM Morador m WHERE m.morador = :nome")
	String findEmailByNome(@Param("nome") String nome);
}
