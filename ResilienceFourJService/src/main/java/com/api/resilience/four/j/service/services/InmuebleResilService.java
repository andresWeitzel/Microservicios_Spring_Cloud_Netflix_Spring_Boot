package com.api.resilience.four.j.service.services;

import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.api.resilience.four.j.service.dto.InmResilEntityDTO;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class InmuebleResilService {

	@Autowired
	private RestTemplate restTemplate;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(InmuebleResilService.class);

	// ======== VARS/CONST ============

	// Devolveremos la url con el puerto del api gateway y el microservicio
	private static final String INMUEBLE_SERVICE_URL = "http://localhost:9191/v1/inmuebles/";

	// nombre del servicio que usamos para el patron circuit breaker
	private static final String INMUEBLE_SERVICE = "INMUEBLE-SERVICE";

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ========================
	// ===== ADD INMUEBLE =====
	// ========================
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceAddInmueble(InmResilEntityDTO inmueble) {

		try {

			// Devolvemos el template con el objeto inmueble
			return restTemplate.postForObject(INMUEBLE_SERVICE_URL, inmueble, String.class);

		} catch (Exception e) {
			return "No se Ha Agregado el Inmueble en la Base de Datos. Producido por " + e.getMessage();
		}

	}

	// ===========================
	// ===== UPDATE INMUEBLE =====
	// ===========================
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceUpdateInmueble(InmResilEntityDTO inmueble) {

		try {
			// Devolvemos el template con el objeto inmueble
			return restTemplate.postForObject(INMUEBLE_SERVICE_URL, inmueble, String.class);

		} catch (Exception e) {
			return "No se Ha Actualizado el Inmueble en la Base de Datos. Producido por " + e.getMessage();
		}

	}

	// ===========================
	// ===== DELETE INMUEBLE =====
	// ===========================
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceDeleteInmueble(UUID id) {

		// Para este caso se solventa el delete de esta forma ya que esta operacion no
		// nos permite
		// devolver un resultado por que el metodo es void a comparacion del
		// postForObject, getForObject

		String inmuebleServiceURLWithId = INMUEBLE_SERVICE_URL + id;

		try {
			// Devolvemos el template con el objeto inmueble
			restTemplate.delete(inmuebleServiceURLWithId);

			return "Se Ha Eliminado Correctamente el Inmueble de la Base de Datos";

		} catch (Exception e) {

			return "No se Ha Eliminado el Inmueble de la Base de Datos. Producido por " + e.getMessage();

		}

	}

	// ======== MÉTODOS DE BUSQUEDA ============
	// ===================
	// ===== GET ALL ====
	// ===================
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetAll() {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "listado";

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// =======================
	// ===== GET TEMPLATE =====
	// ========================
	// -- TEMPLATE VO (INMUEBLE CON PROPIETARIO INMUEBLE)--
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetInmWithPropInm(UUID id) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "inmueble-con-propietario-inmueble/id-inm/" + id;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);
	}

	// ===================
	// ===== GET BY ID ===
	// ===================
	// -- INMUEBLE POR ID --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetById(UUID idInmueble) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "id/" + idInmueble;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// ==============================
	// ===== GET BY ID-PROPIETARIO===
	// ==============================
	// -- PROPIETARIO-INMUEBLE POR ID --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetByIdPropInm(UUID id) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "id-propietario-inmueble/" + id;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// ============================
	// ===== GET BY DESCRIPCION ===
	// ============================
	// -- INMUEBLES POR DESCRIPCION --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetByDescripcion(String descripcion) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "descripcion/" + descripcion;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// =====================
	// ===== GET BY TIPO ===
	// =====================
	// -- INMUEBLES POR TIPO --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetByTipo(String tipo) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "tipo/" + tipo;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// ================================
	// ===== GET BY ESTADO-INMUEBLE ===
	// ================================
	// -- INMUEBLES POR ESTADO INMUEBLE --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetByEstadoInm(String estado) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "estado-inmueble/" + estado;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// =======================
	// ===== GET BY PRECIO ===
	// =======================
	// -- INMUEBLES POR PRECIO --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetByPrecio(double precio) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "precio/" + precio;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// ==========================
	// ===== GET BY DIRECCION ===
	// ==========================
	// -- INMUEBLES POR DIRECCION --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetByDireccion(String direccion) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "direccion/" + direccion;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// ==========================
	// ===== GET BY UBICACION ===
	// ==========================
	// -- INMUEBLES POR UBICACION --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetByUbicacion(String ubicacion) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "ubicacion/" + ubicacion;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// ==========================
	// ===== GET BY SITIO-WEB ===
	// ==========================
	// -- INMUEBLES POR SITIO WEB --
	@CircuitBreaker(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackCircuitBreaker")
	@RateLimiter(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRateLimit")
	@Retry(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackRetry")
	@Bulkhead(name = INMUEBLE_SERVICE, fallbackMethod = "inmuebleServiceFallBackBulkHead")
	public String inmuebleServiceGetBySitioWeb(String sitioWeb) {

		String inmuebleServiceURL = INMUEBLE_SERVICE_URL + "sitio-web/" + sitioWeb;

		// Devolvemos el template con el objeto inmueble
		return restTemplate.getForObject(inmuebleServiceURL, String.class);

	}

	// ======== MÉTODOS FALL BACK ============

	// ==========================
	// ===== CIRCUIT BREAKER ===
	// ==========================
	public String inmuebleServiceFallBackCircuitBreaker(Exception e) {

		// Logging
		logger.error("Se ha producido un error al llamar al Servicio " + INMUEBLE_SERVICE + " . Causado por " + e);

		// Template
		return "SE HA PRODUCIDO UN ERROR AL LLAMAR AL MICROSERVICIO " + INMUEBLE_SERVICE;
	}

	// ====================
	// ===== RATE LIMIT ===
	// ====================
	public String inmuebleServiceFallBackRateLimit(Exception e) {

		// Logging
		logger.error("Se ha alcanzado el limite de velocidad al llamar al Servicio " + INMUEBLE_SERVICE
				+ " . Causado por " + e);

		// Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO DE VELOCIDAD PARA EL MICROSERVICIO " + INMUEBLE_SERVICE;
	}

	// ==============
	// ===== RETRY===
	// ==============
	public String inmuebleServiceFallBackRetry(Exception e) {

		// Logging
		logger.error("Se ha alcanzado el limite máximo al reintentar automáticamente una operación del Microservicio "
				+ INMUEBLE_SERVICE + " . Causado por " + e);

		// Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO AL REINTENTAR AUTOMÁTICAMENTE UNA OPERACIÓN PARA EL MICROSERVICIO "
				+ INMUEBLE_SERVICE;
	}

	// ===================
	// ===== BULK HEAD ===
	// ===================
	public String inmuebleServiceFallBackBulkHead(Exception e) {

		// Logging
		logger.error("Se ha alcanzado el limite máximo de operaciones simultáneas del Microservicio " + INMUEBLE_SERVICE
				+ " . Causado por " + e);

		// Template
		return "SE HA ALCANZADO EL LIMITE MÁXIMO DE OPERACIONES SIMULTÁNEAS DEL MICROSERVICIO " + INMUEBLE_SERVICE;
	}

}
