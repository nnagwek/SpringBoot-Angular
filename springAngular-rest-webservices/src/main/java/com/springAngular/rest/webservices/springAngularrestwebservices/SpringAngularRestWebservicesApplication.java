package com.springAngular.rest.webservices.springAngularrestwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.springAngular.rest.webservices.springAngularrestwebservices")
@EnableJpaRepositories(basePackages = { "com.springAngular.rest.webservices.springAngularrestwebservices" })
@SpringBootApplication
public class SpringAngularRestWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularRestWebservicesApplication.class, args);
	}

}

