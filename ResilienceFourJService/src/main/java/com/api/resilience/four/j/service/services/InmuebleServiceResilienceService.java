package com.api.resilience.four.j.service.services;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class InmuebleServiceResilienceService {
	
	@Autowired
	private RestTemplate restTemplate;
	

	// ============= LOGS ========================	
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(InmuebleServiceResilienceService.class);

	// ======== VARS/CONST ============

	//Devolveremos la url con el puerto del api gateway y el microservicio
	private static final String INMUEBLE_SERVICE_URL
	= "http://localhost:9191/";
	
	
	//nombre del servicio que usamos para el patron circuit breaker
	private static final String INMUEBLE_SERVICE = "INMUEBLE-SERVICE"; 
	
	
	// ======== MÉTODOS DE BUSQUEDA ============
	
	
	//-- LISTADO COMPLETO Y PAGINADO --
	@GetMapping
	@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetList() {
		
		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/listado";
		
		//Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);
	}
	
	
	
	//-- TEMPLATE VO (INMUEBLE CON PROPIETARIO INMUEBLE)--	
	@GetMapping
	@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetInmWithPropInm(int idInmueble) {
		
		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/inmueble-con-propietario-inmueble/id-prop-inm/"+idInmueble;
		
		//Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);
	}
	
	
	
	
	//-- INMUEBLE POR ID --
	@GetMapping
	@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetById(int idInmueble) {
		
		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/id/"+idInmueble;
		
			//Devolvemos el template con el objeto inmueble
			return restTemplate.getForObject(inmuebleServiceURL, String.class);
			
			
		}
	
	
	//-- PROPIETARIO-INMUEBLE POR ID --
		@GetMapping
		@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackCircuitBreaker")
		@RateLimiter(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRateLimit")
		@Retry(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRetry")
		@Bulkhead(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackBulkHead")
		public String inmuebleServiceGetByIdPropInm(int idInmueble) {
			
			String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/id-propietario-inmueble/"+idInmueble;
			
				//Devolvemos el template con el objeto inmueble
				return restTemplate.getForObject(inmuebleServiceURL, String.class);
				
				
			}
		
		//-- INMUEBLES POR DESCRIPCION --
		@GetMapping
		@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackCircuitBreaker")
		@RateLimiter(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRateLimit")
		@Retry(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRetry")
		@Bulkhead(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackBulkHead")
		public String inmuebleServiceGetByDescripcion(String descripcion) {
			
			String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/descripcion/"+descripcion;
			
				//Devolvemos el template con el objeto inmueble
				return restTemplate.getForObject(inmuebleServiceURL, String.class);
				
				
			}
		
		
		//-- INMUEBLES POR TIPO --
		@GetMapping
		@CircuitBreaker(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackCircuitBreaker")
		@RateLimiter(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRateLimit")
		@Retry(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackRetry")
		@Bulkhead(name = INMUEBLE_SERVICE , fallbackMethod="inmuebleServiceFallBackBulkHead")
		public String inmuebleServiceGetByTipo(String tipo) {
			
			String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmuebles/tipo/"+tipo;
			
				//Devolvemos el template con el objeto inmueble
				return restTemplate.getForObject(inmuebleServiceURL, String.class);
				
				
			}
	
	
	
	
	
	
	
	// ======== MÉTODOS FALL BACK ============

	//--CIRCUIT BREAKER--
	public String inmuebleServiceFallBackCircuitBreaker(Exception e) {
		
		//Logging
		logger.error("Se ha producido un error al llamar al Servicio "
		+INMUEBLE_SERVICE +" . Causado por "+ e);
		
		//Template
		return "SE HA PRODUCIDO UN ERROR AL LLAMAR AL MICROSERVICIO "+INMUEBLE_SERVICE;
	}
	
	
	//--RATE LIMIT--
	public String inmuebleServiceFallBackRateLimit(Exception e) {
		
		//Logging
		logger.error("Se ha alcanzado el limite de velocidad al llamar al Servicio "
		+INMUEBLE_SERVICE +" . Causado por "+ e);
		
		//Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO DE VELOCIDAD PARA EL MICROSERVICIO "
		+INMUEBLE_SERVICE;
	}
	//--RETRY--
	public String inmuebleServiceFallBackRetry(Exception e) {
		
		//Logging
		logger.error("Se ha alcanzado el limite máximo al reintentar automáticamente una operación del Microservicio "
		+INMUEBLE_SERVICE +" . Causado por "+ e);
		
		//Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO AL REINTENTAR AUTOMÁTICAMENTE UNA OPERACIÓN PARA EL MICROSERVICIO "
		+INMUEBLE_SERVICE;
	}
	
	//--BULK HEAD--
	public String inmuebleServiceFallBackBulkHead(Exception e) {
		
		//Logging
		logger.error("Se ha alcanzado el limite máximo de operaciones simultáneas del Microservicio "
		+INMUEBLE_SERVICE +" . Causado por "+ e);
		
		//Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO DE OPERACIONES SIMULTÁNEAS DEL MICROSERVICIO "
		+INMUEBLE_SERVICE;
	}


}

