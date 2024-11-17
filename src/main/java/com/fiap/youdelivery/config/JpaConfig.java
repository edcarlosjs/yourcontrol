package com.fiap.youdelivery.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.fiap.youdelivery.repository")
@EntityScan(basePackages = "com.fiap.youdelivery.model")
public class JpaConfig {
}



