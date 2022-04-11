package com.api.resilience.four.j.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class InmuebleServiceResilienceService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	// ======== VARS/CONST ============

	//Devolveremos la url con el puerto del api gateway y el microservicio
	private static final String INMUEBLE_SERVICE_URL
	= "http://localhost:9191/";
	
	
	//nombre del servicio que usamos para el patron circuit breaker
	private static final String INMUEBLE_SERVICE = "INMUEBLE-SERVICE"; 
	
	
	// ======== MÉTODOS DE BUSQUEDA ============
	
	
	//-- LISTADO COMPLETO Y PAGINADO --
	@GetMapping
	@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBack")
	public String inmuebleServiceGetList() {
		
		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/listado";
		
		//Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);
	}
	
	
	
	//-- TEMPLATE VO (INMUEBLE CON PROPIETARIO INMUEBLE)--	
	@GetMapping
	@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBack")
	public String inmuebleServiceGetInmWithPropInm(int idInmueble) {
		
		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/inmueble-con-propietario-inmueble/id-prop-inm/"+idInmueble;
		
		//Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);
	}
	
	
	
	
	//-- INMUEBLE POR ID --
	@GetMapping
	@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBack")
	public String inmuebleServiceGetById(int idInmueble) {
		
		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/id/"+idInmueble;
		
			//Devolvemos el template con el objeto inmueble
			return restTemplate.getForObject(inmuebleServiceURL, String.class);
			
			
		}
	
	
	
	
	
	
	
	// ======== MÉTODOS FALL BACK ============

	
	public String inmuebleServiceFallBack(Exception e) {
		
		return "EL MICROSERVICIO "+INMUEBLE_SERVICE+" ESTÁ TARDANDO MÁS DE LO ESPERADO";
	}


}

