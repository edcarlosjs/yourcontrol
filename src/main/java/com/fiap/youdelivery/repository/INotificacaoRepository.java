package com.fiap.youdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.youdelivery.entities.Notificacao;

@Repository
public interface INotificacaoRepository extends JpaRepository<Notificacao, Long>{
}
