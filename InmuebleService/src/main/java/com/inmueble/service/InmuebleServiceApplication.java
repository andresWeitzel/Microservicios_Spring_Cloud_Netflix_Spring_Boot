package com.inmueble.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class InmuebleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InmuebleServiceApplication.class, args);

	}
	

	@Bean(name="remoteRestTemplate")
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}


}
