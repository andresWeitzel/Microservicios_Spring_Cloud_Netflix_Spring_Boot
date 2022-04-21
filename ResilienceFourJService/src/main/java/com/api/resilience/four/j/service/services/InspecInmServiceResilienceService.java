package com.api.resilience.four.j.service.services;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.resilience.four.j.service.dto.InspecInmEntityServiceDTO;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class InspecInmServiceResilienceService {
	
	@Autowired
	private RestTemplate restTemplate;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(InspecInmServiceResilienceService.class);


	// ======== VARS/CONST ============

		// Devolveremos la url con el puerto del api gateway y el microservicio
		private static final String INSPECCION_INMUEBLE_SERVICE_URL = "http://localhost:8095/inspecciones-inmuebles/";

		// nombre del servicio que usamos para el patron circuit breaker
		private static final String INSPECCION_INMUEBLE_SERVICE = "INSPECCION-INMUEBLE-SERVICE";

		
		// ========= MÉTODOS CRUD ============

		// --ADD INSPECCION INMUEBLE--

		@CircuitBreaker(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackCircuitBreaker")
		@RateLimiter(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRateLimit")
		@Retry(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRetry")
		@Bulkhead(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackBulkHead")
		public String inspecInmServiceAddInspecInmueble(InspecInmEntityServiceDTO inspecInm) {

			// Devolvemos el template con el objeto inspeccion inmueble
			return restTemplate.postForObject(INSPECCION_INMUEBLE_SERVICE_URL, inspecInm, String.class);
		}
		
		
		// --UPDATE INSPECCION INMUEBLE--

		@CircuitBreaker(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackCircuitBreaker")
		@RateLimiter(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRateLimit")
		@Retry(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRetry")
		@Bulkhead(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackBulkHead")
		public String inspecInmServiceUpdateInspecInmueble(InspecInmEntityServiceDTO inspecInm) {

			// Devolvemos el template con el objeto inspeccion inmueble
			return restTemplate.postForObject(INSPECCION_INMUEBLE_SERVICE_URL, inspecInm, String.class);
		}
		
		// --DELETE INMUEBLE--

		@CircuitBreaker(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackCircuitBreaker")
		@RateLimiter(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRateLimit")
		@Retry(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRetry")
		@Bulkhead(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackBulkHead")
		public String inspecInmServiceDeleteInspecInmueble(int id) {

			// Para este caso se solventa el delete de esta forma ya que esta operacion no
			// nos permite
			// devolver un resultado por que el metodo es void a comparacion del
			// postForObject, getForObject

			String inspecInmuebleServiceURLWithId = INSPECCION_INMUEBLE_SERVICE_URL + id;

			try {
				// Devolvemos el template con el objeto inmueble
				restTemplate.delete(inspecInmuebleServiceURLWithId);

				return "true";

			} catch (Exception e) {

				return "false";
			}

		}
		
		// ======== MÉTODOS DE BUSQUEDA ============

		// -- LISTADO COMPLETO Y PAGINADO --

		@CircuitBreaker(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackCircuitBreaker")
		@RateLimiter(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRateLimit")
		@Retry(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackRetry")
		@Bulkhead(name = INSPECCION_INMUEBLE_SERVICE, fallbackMethod = "inspecInmuebleServiceFallBackBulkHead")
		public String inspecInmServiceGetAll() {

			String inspecInmuebleServiceListURL = INSPECCION_INMUEBLE_SERVICE_URL + "listado";

			// Devolvemos el template con el objeto inmueble
			return restTemplate.getForObject(inspecInmuebleServiceListURL, String.class);
		}
		
		
		
		

		
		// ======== MÉTODOS FALL BACK ============

		// --CIRCUIT BREAKER--
		public String inspecInmuebleServiceFallBackCircuitBreaker(Exception e) {

			// Logging
			logger.error("Se ha producido un error al llamar al Servicio " + INSPECCION_INMUEBLE_SERVICE
					+ " . Causado por " + e);

			// Template
			return "SE HA PRODUCIDO UN ERROR AL LLAMAR AL MICROSERVICIO " + INSPECCION_INMUEBLE_SERVICE;
		}

		// --RATE LIMIT--
		public String inspecInmuebleServiceFallBackRateLimit(Exception e) {

			// Logging
			logger.error("Se ha alcanzado el limite de velocidad al llamar al Servicio " + INSPECCION_INMUEBLE_SERVICE
					+ " . Causado por " + e);

			// Template
			return "SE HA ALCANZADO EL LIMITE MÁXIMO DE VELOCIDAD PARA EL MICROSERVICIO " + INSPECCION_INMUEBLE_SERVICE;
		}

		// --RETRY--
		public String inspecInmuebleServiceFallBackRetry(Exception e) {

			// Logging
			logger.error("Se ha alcanzado el limite máximo al reintentar automáticamente una operación del Microservicio "
					+ INSPECCION_INMUEBLE_SERVICE + " . Causado por " + e);

			// Template
			return "SE HA ALCANZADO EL LIMITE MÁXIMO AL REINTENTAR AUTOMÁTICAMENTE UNA OPERACIÓN PARA EL MICROSERVICIO "
					+ INSPECCION_INMUEBLE_SERVICE;
		}

		// --BULK HEAD--
		public String inspecInmuebleServiceFallBackBulkHead(Exception e) {

			// Logging
			logger.error("Se ha alcanzado el limite máximo de operaciones simultáneas del Microservicio "
					+ INSPECCION_INMUEBLE_SERVICE + " . Causado por " + e);

			// Template
			return "SE HA ALCANZADO EL LIMITE MÁXIMO DE OPERACIONES SIMULTÁNEAS DEL MICROSERVICIO "
					+ INSPECCION_INMUEBLE_SERVICE;
		}
		
		
}
