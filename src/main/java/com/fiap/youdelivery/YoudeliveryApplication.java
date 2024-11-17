package com.fiap.youdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fiap.youdelivery.repository")

public class YoudeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoudeliveryApplication.class, args);
	}

}
