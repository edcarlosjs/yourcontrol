package com.fiap.youdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.fiap.youdelivery.entities.Usuarios;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios, Long>{
	  UserDetails findByUsername(String username);
 }
