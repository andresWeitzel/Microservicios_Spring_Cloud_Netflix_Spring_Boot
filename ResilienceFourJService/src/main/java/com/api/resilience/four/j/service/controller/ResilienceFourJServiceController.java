package com.api.resilience.four.j.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/resilience")
public class ResilienceFourJServiceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	//Devolveremos la url con el puerto del api gateway y el microservicio
	private static final String BASE_URL
	= "http://localhost:9191/";
	
	
	//nombre del servicio que usamos para el patron circuit breaker
	private static final String INMUEBLE_SERVICE = "INMUEBLE-SERVICE"; 
	
	
	@GetMapping
	@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBack")
	public String inmuebleService() {
		
		String inmuebleServiceURL = BASE_URL + "inmuebles/listado";
		
		//Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);
	}
	
	public String inmuebleServiceFallBack(Exception e) {
		
		return "EL MICROSERVICIO "+INMUEBLE_SERVICE+" ESTÁ TARDANDO MÁS DE LO ESPERADO";
	}


}

