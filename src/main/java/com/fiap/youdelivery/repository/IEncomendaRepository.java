package com.fiap.youdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.youdelivery.entities.Encomenda;

@Repository
public interface IEncomendaRepository extends JpaRepository<Encomenda, Long>{

}
