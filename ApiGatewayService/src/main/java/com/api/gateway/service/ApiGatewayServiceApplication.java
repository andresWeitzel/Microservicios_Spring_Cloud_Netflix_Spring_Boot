package com.api.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayServiceApplication.class, args);
	}

}
