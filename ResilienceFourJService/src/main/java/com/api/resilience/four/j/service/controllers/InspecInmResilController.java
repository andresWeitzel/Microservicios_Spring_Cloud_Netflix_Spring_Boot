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

import com.api.resilience.four.j.service.dto.InspecInmResilEntityDTO;

import com.api.resilience.four.j.service.services.InspecInmResilService;

@RestController
@RequestMapping("/v1/inspeccion-inmueble-service")
public class InspecInmResilController {

	@Autowired
	InspecInmResilService inspecInmServResil;

	/// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	@PostMapping(value = "/")
	public String inspecInmServiceAddInspecInmueble(@RequestBody InspecInmResilEntityDTO inspecInmueble) {
		return inspecInmServResil.inspecInmServiceAddInspecInmueble(inspecInmueble);

	}

	// ================
	// ===== PUT =====
	// =================
	@PutMapping(value = "/")
	public String inspecInmServiceUpdateInspecInmueble(@RequestBody InspecInmResilEntityDTO inspecInmueble) {
		return inspecInmServResil.inspecInmServiceUpdateInspecInmueble(inspecInmueble);

	}

	// ================
	// ===== DELETE ===
	// =================
	@DeleteMapping(value = "/{id}")
	public String inspecInmServiceDeleteInspecInmueble(@PathVariable("id") UUID id) {
		return inspecInmServResil.inspecInmServiceDeleteInspecInmueble(id);

	}

	// ===================
	// ===== GET ALL =====
	// ===================
	@GetMapping(value = "/listado")
	public String inspecInmServiceGetAllInspecInmueble() {
		return inspecInmServResil.inspecInmServiceGetAll();

	}

	// =====================================================
	// ===== NO SE DESARROLLAN EL RESTO DE LOS METODOS =====
	// =====================================================

}
