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

import com.api.resilience.four.j.service.dto.InmResilEntityDTO;

import com.api.resilience.four.j.service.services.InmuebleResilService;

@RestController
@RequestMapping("/v1/inmueble-service")
public class InmuebleResilController {

	@Autowired
	InmuebleResilService inmServResil;

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	@PostMapping(value = "/")
	public String inmuebleServiceAddInmueble(@RequestBody InmResilEntityDTO inmueble) {
		return inmServResil.inmuebleServiceAddInmueble(inmueble);

	}

	// ================
	// ===== PUT =====
	// =================
	@PutMapping(value = "/")
	public String inmuebleServiceUpdateInmueble(@RequestBody InmResilEntityDTO inmueble) {
		return inmServResil.inmuebleServiceUpdateInmueble(inmueble);

	}

	// ================
	// ===== DELETE =====
	// =================
	@DeleteMapping(value = "/{id}")
	public String inmuebleServiceDeleteInmueble(@PathVariable("id") UUID id) {
		return inmServResil.inmuebleServiceDeleteInmueble(id);
	}

	// ===================
	// ===== GET ALL =====
	// ===================
	@GetMapping(value = "/listado")
	public String inmuebleServiceGetAll() {
		return inmServResil.inmuebleServiceGetAll();
	}

	// ======== MÉTODOS DE BUSQUEDA ============
	// ===================
	// ===== GET BY ID ===
	// ===================
	@GetMapping(value = "/id/{id}")
	public String inmuebleServiceGetById(@PathVariable("id") UUID id) {
		return inmServResil.inmuebleServiceGetById(id);
	}

	// ==============================
	// ===== GET BY ID-PROPIETARIO===
	// ==============================
	@GetMapping(value = "/id-propietario-inmueble/{id}")
	public String inmuebleServiceGetByPropInm(@PathVariable("id") UUID id) {
		return inmServResil.inmuebleServiceGetByIdPropInm(id);
	}

	// ===================
	// ===== GET TEMPLATE =====
	// ===================
	@GetMapping(value = "/inmueble-con-propietario-inmueble/id-inm/{id}")
	public String inmuebleServiceGetInmWithPropInm(@PathVariable("id") UUID id) {
		return inmServResil.inmuebleServiceGetInmWithPropInm(id);
	}

	// ============================
	// ===== GET BY DESCRIPCION ===
	// ============================
	@GetMapping(value = "/descripcion/{descripcion}")
	public String inmuebleServiceGetByDescripcion(@PathVariable("descripcion") String descripcion) {
		return inmServResil.inmuebleServiceGetByDescripcion(descripcion);
	}

	// =====================
	// ===== GET BY TIPO ===
	// =====================
	@GetMapping(value = "/tipo/{tipo}")
	public String inmuebleServiceGetByTipo(@PathVariable("tipo") String tipo) {
		return inmServResil.inmuebleServiceGetByTipo(tipo);
	}

	// ================================
	// ===== GET BY ESTADO-INMUEBLE ===
	// ================================
	@GetMapping(value = "/estado-inmueble/{estado}")
	public String inmuebleServiceGetByEstadoInm(@PathVariable("estado") String estado) {
		return inmServResil.inmuebleServiceGetByEstadoInm(estado);
	}

	// =======================
	// ===== GET BY PRECIO ===
	// =======================
	@GetMapping(value = "/precio/{precio}")
	public String inmuebleServiceGetByPrecio(@PathVariable("precio") double precio) {
		return inmServResil.inmuebleServiceGetByPrecio(precio);
	}

	// ==========================
	// ===== GET BY DIRECCION ===
	// ==========================
	@GetMapping(value = "/direccion/{direccion}")
	public String inmuebleServiceGetByDireccion(@PathVariable("direccion") String direccion) {
		return inmServResil.inmuebleServiceGetByDireccion(direccion);
	}

	// ==========================
	// ===== GET BY UBICACION ===
	// ==========================
	@GetMapping(value = "/ubicacion/{ubicacion}")
	public String inmuebleServiceGetByUbicacion(@PathVariable("ubicacion") String ubicacion) {
		return inmServResil.inmuebleServiceGetByUbicacion(ubicacion);
	}

	// ==========================
	// ===== GET BY SITIO-WEB ===
	// ==========================
	@GetMapping(value = "/sitio-web/{sitio-web}")
	public String inmuebleServiceGetBySitioWeb(@PathVariable("sitio-web") String sitioWeb) {
		return inmServResil.inmuebleServiceGetBySitioWeb(sitioWeb);
	}

}
