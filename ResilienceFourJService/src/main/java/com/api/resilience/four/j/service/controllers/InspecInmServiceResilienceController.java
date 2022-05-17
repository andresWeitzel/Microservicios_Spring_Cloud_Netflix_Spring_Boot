package com.api.resilience.four.j.service.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.resilience.four.j.service.dto.InspecInmEntityServiceDTO;

import com.api.resilience.four.j.service.services.InspecInmServiceResilienceService;

@RestController
@RequestMapping("/v1/inspeccion-inmueble-service")
public class InspecInmServiceResilienceController {
	
	@Autowired
	InspecInmServiceResilienceService inspecInmServResil;
	
	// ======== MÉTODOS CRUD ============

		// --ADD INSPECCION INMUEBLE--
		@PostMapping(value = "/")
		public String inspecInmServiceAddInspecInmueble(@RequestBody InspecInmEntityServiceDTO inspecInmueble) {
			return inspecInmServResil.inspecInmServiceAddInspecInmueble(inspecInmueble);

		}

		
		// --UPDATE INSPECCION INMUEBLE--
		@PutMapping(value = "/")
		public String inspecInmServiceUpdateInspecInmueble(@RequestBody InspecInmEntityServiceDTO inspecInmueble) {
			return inspecInmServResil.inspecInmServiceUpdateInspecInmueble(inspecInmueble);

		}

		// --DELETE INSPECCION INMUEBLE--
		@DeleteMapping(value = "/{id}")
		public String inspecInmServiceDeleteInspecInmueble(@PathVariable("id") UUID id) {
			return inspecInmServResil.inspecInmServiceDeleteInspecInmueble(id);

		}
		
		// --SELECT INSPECCION INMUEBLE--
		@GetMapping(value = "/listado")
		public String inspecInmServiceGetAllInspecInmueble() {
			return inspecInmServResil.inspecInmServiceGetAll();

		}


}
