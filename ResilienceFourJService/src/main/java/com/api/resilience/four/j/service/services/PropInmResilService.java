package com.api.resilience.four.j.service.services;

import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.resilience.four.j.service.dto.PropInmResilEntityDTO;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class PropInmResilService {

	@Autowired
	private RestTemplate restTemplate;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(PropInmResilService.class);

	// ======== VARS/CONST ============

	// Devolveremos la url con el puerto del api gateway y el microservicio
	private static final String PROPIETARIO_INMUEBLE_SERVICE_URL = "http://localhost:8093/v1/propietarios-inmuebles/";

	// nombre del servicio que usamos para el patron circuit breaker
	private static final String PROPIETARIO_INMUEBLE_SERVICE = "PROPIETARIO_INMUEBLE-SERVICE";

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ========================
	// ===== ADD INMUEBLE =====
	// ========================
	@CircuitBreaker(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRateLimit")
	@Retry(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRetry")
	@Bulkhead(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackBulkHead")
	public String propInmServiceAddInmueble(PropInmResilEntityDTO propInm) {

		try {
			// Devolvemos el template con el objeto de propietario inmueble
			return restTemplate.postForObject(PROPIETARIO_INMUEBLE_SERVICE_URL, propInm, String.class);

		} catch (Exception e) {
			return "No se Ha Agregado el Propietario del Inmueble en la Base de Datos. Producido por " + e.getMessage();
		}

	}

	// ===========================
	// ===== UPDATE INMUEBLE =====
	// ===========================
	@CircuitBreaker(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRateLimit")
	@Retry(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRetry")
	@Bulkhead(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackBulkHead")
	public String propInmServiceUpdateInmueble(PropInmResilEntityDTO propInm) {
		
		try {
			// Devolvemos el template con el objeto de propietario inmueble
			return restTemplate.postForObject(PROPIETARIO_INMUEBLE_SERVICE_URL, propInm, String.class);
			
		} catch (Exception e) {
			return "No se Ha Actualizado el Propietario del Inmueble en la Base de Datos. Producido por " + e.getMessage();
		}
		
	}

	// ===========================
	// ===== DELETE INMUEBLE =====
	// ===========================
	@CircuitBreaker(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRateLimit")
	@Retry(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRetry")
	@Bulkhead(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackBulkHead")
	public String propInmServiceDeleteInmueble(UUID id) {

		// Para este caso se solventa el delete de esta forma ya que esta operacion no
		// nos permite
		// devolver un resultado por que el metodo es void a comparacion del
		// postForObject, getForObject

		try {
			
			String propInmuebleServiceURLWithId = PROPIETARIO_INMUEBLE_SERVICE_URL + id;


			// Devolvemos el template con el objeto propinmueble
			restTemplate.delete(propInmuebleServiceURLWithId);

			return "Se Ha Eliminado Correctamente el Propietario del Inmueble de la Base de Datos";

		} catch (Exception e) {

			return "No se Ha Eliminado el Propietario del Inmueble de la Base de Datos. Producido por " + e.getMessage();

		}

	}
	
	
	// ======== MÉTODOS DE BUSQUEDA ============
	
	
	// ===================
	// ===== GET ALL ====
	// ===================
	@CircuitBreaker(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRateLimit")
	@Retry(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackRetry")
	@Bulkhead(name = PROPIETARIO_INMUEBLE_SERVICE, fallbackMethod = "propInmuebleServiceFallBackBulkHead")
	public String propInmServiceGetAll() {

		String propInmuebleServiceListURL = PROPIETARIO_INMUEBLE_SERVICE_URL + "listado";

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(propInmuebleServiceListURL, String.class);
	}

	// =====================================================
	// ===== EL RESTO DE LOS METODOS NO SE DESARROLLAN =====
	// =====================================================

	// ======== MÉTODOS FALL BACK ============

	// ==========================
	// ===== CIRCUIT BREAKER ===
	// ==========================
	public String propInmuebleServiceFallBackCircuitBreaker(Exception e) {

		// Logging
		logger.error("Se ha producido un error al llamar al Servicio " + PROPIETARIO_INMUEBLE_SERVICE
				+ " . Causado por " + e);

		// Template
		return "SE HA PRODUCIDO UN ERROR AL LLAMAR AL MICROSERVICIO " + PROPIETARIO_INMUEBLE_SERVICE;
	}

	// ====================
	// ===== RATE LIMIT ===
	// ====================
	public String propInmuebleServiceFallBackRateLimit(Exception e) {

		// Logging
		logger.error("Se ha alcanzado el limite de velocidad al llamar al Servicio " + PROPIETARIO_INMUEBLE_SERVICE
				+ " . Causado por " + e);

		// Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO DE VELOCIDAD PARA EL MICROSERVICIO " + PROPIETARIO_INMUEBLE_SERVICE;
	}

	// ==============
	// ===== RETRY===
	// ==============
	public String propInmuebleServiceFallBackRetry(Exception e) {

		// Logging
		logger.error("Se ha alcanzado el limite máximo al reintentar automáticamente una operación del Microservicio "
				+ PROPIETARIO_INMUEBLE_SERVICE + " . Causado por " + e);

		// Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO AL REINTENTAR AUTOMÁTICAMENTE UNA OPERACIÓN PARA EL MICROSERVICIO "
				+ PROPIETARIO_INMUEBLE_SERVICE;
	}

	// ===================
	// ===== BULK HEAD ===
	// ===================
	public String propInmuebleServiceFallBackBulkHead(Exception e) {

		// Logging
		logger.error("Se ha alcanzado el limite máximo de operaciones simultáneas del Microservicio "
				+ PROPIETARIO_INMUEBLE_SERVICE + " . Causado por " + e);

		// Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO DE OPERACIONES SIMULTÁNEAS DEL MICROSERVICIO "
				+ PROPIETARIO_INMUEBLE_SERVICE;
	}

}
