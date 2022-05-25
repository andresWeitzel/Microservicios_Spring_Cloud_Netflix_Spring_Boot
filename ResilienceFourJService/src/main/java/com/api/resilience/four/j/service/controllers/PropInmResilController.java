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

import com.api.resilience.four.j.service.dto.PropInmResilEntityDTO;

import com.api.resilience.four.j.service.services.PropInmResilService;

@RestController
@RequestMapping("/v1/propietario-inmueble-service")
public class PropInmResilController {

	@Autowired
	PropInmResilService propInmServResil;

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	@PostMapping(value = "/")
	public String propInmServiceAddInmueble(@RequestBody PropInmResilEntityDTO propInmueble) {
		return propInmServResil.propInmServiceAddInmueble(propInmueble);

	}

	// ================
	// ===== PUT =====
	// =================
	@PutMapping(value = "/")
	public String propInmServiceUpdateInmueble(@RequestBody PropInmResilEntityDTO propInmueble) {
		return propInmServResil.propInmServiceUpdateInmueble(propInmueble);

	}

	// ================
	// ===== DELETE ===
	// =================
	@DeleteMapping(value = "/{id}")
	public String propInmServiceDeleteInmueble(@PathVariable("id") UUID id) {
		return propInmServResil.propInmServiceDeleteInmueble(id);

	}

	// ===================
	// ===== GET ALL =====
	// ===================
	@GetMapping(value = "/listado")
	public String propInmServiceGetAllInmueble() {
		return propInmServResil.propInmServiceGetAll();

	}

	// =====================================================
	// ===== NO SE DESARROLLAN EL RESTO DE LOS METODOS =====
	// =====================================================

}
