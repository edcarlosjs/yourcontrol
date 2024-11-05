package com.fiap.youdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.youdelivery.entities.Funcionario;

@Repository
public interface IFuncionarioRepository extends JpaRepository<Funcionario, Long>{
}
