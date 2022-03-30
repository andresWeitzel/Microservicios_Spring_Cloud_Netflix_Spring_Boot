package com.api.gateway.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	
	@GetMapping("/inmuebleServiceFallBack")
	public String inmuebleServiceFallBackMethod() {
		
		return "El Microservicio INMUEBLE-SERVICE está tardando "
				+ "más de lo esperado. Por favor intente más tarde."; 
	}
	
	
	@GetMapping("/propietarioInmuebleServiceFallBack")
	public String propietarioInmuebleServiceFallBackMethod() {
		
		return "El Microservicio PROPIETARIO-INMUEBLE-SERVICE está tardando "
				+ "más de lo esperado. Por favor intente más tarde."; 
	}
	
	
}
