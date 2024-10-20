package com.fiap.youdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.youdelivery.entities.Morador;

@Repository
public interface IMoradorRepository extends JpaRepository<Morador, Long>{
}
