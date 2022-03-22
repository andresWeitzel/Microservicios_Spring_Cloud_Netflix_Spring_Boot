package com.inmueble.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PropietarioInmuebleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropietarioInmuebleServiceApplication.class, args);
	}

}
