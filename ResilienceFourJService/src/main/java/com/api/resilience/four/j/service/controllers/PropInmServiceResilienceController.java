package com.api.resilience.four.j.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.api.resilience.four.j.service.dto.PropInmEntityServiceDTO;

import com.api.resilience.four.j.service.services.PropInmServiceResilienceService;

@RestController
@RequestMapping("/propietario-inmueble-service")
public class PropInmServiceResilienceController {

	@Autowired
	PropInmServiceResilienceService propInmServResil;

	// ======== MÉTODOS CRUD ============

	// --ADD PROPIETARIO INMUEBLE--
	@PostMapping(value = "/")
	public String propInmServiceAddInmueble(@RequestBody PropInmEntityServiceDTO propInmueble) {
		return propInmServResil.propInmServiceAddInmueble(propInmueble);

	}

	// --UPDATE PROPIETARIO INMUEBLE--
	@PutMapping(value = "/")
	public String propInmServiceUpdateInmueble(@RequestBody PropInmEntityServiceDTO propInmueble) {
		return propInmServResil.propInmServiceUpdateInmueble(propInmueble);

	}

	// --DELETE PROPIETARIO INMUEBLE--
	@DeleteMapping(value = "/{id}")
	public String propInmServiceDeleteInmueble(@PathVariable("id") int id) {
		return propInmServResil.propInmServiceDeleteInmueble(id);

	}

	// --GET ALL PROPIETARIO INMUEBLE--
	@GetMapping(value = "/listado")
	public String propInmServiceGetAllInmueble() {
		return propInmServResil.propInmServiceGetAll();

	}

}
