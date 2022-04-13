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

import com.api.resilience.four.j.service.dto.InmuebleEntityServiceDTO;
import com.api.resilience.four.j.service.enums.EstadoInmuebleEnum;
import com.api.resilience.four.j.service.services.InmuebleServiceResilienceService;

@RestController
@RequestMapping("/inmueble-service")
public class InmuebleServiceResilienceController {

	@Autowired
	InmuebleServiceResilienceService inmServResil;

	// ======== MÉTODOS CRUD ============

	// --ADD INMUEBLE--
	@PostMapping(value = "/")
	public String inmuebleServiceAddInmueble(@RequestBody InmuebleEntityServiceDTO inmueble) {
		return inmServResil.inmuebleServiceAddInmueble(inmueble);

	}

	// --UPDATE INMUEBLE--
	@PutMapping(value = "/")
	public String inmuebleServiceUpdateInmueble(@RequestBody InmuebleEntityServiceDTO inmueble) {
		return inmServResil.inmuebleServiceUpdateInmueble(inmueble);

	}

	// --DELETE INMUEBLE--
	@DeleteMapping(value = "/")
	public String inmuebleServiceDeleteInmueble(@RequestBody InmuebleEntityServiceDTO inmueble) {
		return inmServResil.inmuebleServiceDeleteInmueble(inmueble);

	}
	
	//-- GET ALL INMUEBLE--
	@GetMapping(value = "/listado")
	public String inmuebleServiceGetList() {
		return inmServResil.inmuebleServiceGetList();
	}

	// ======== MÉTODOS DE BUSQUEDA ============

	

	@GetMapping(value = "/inmueble-con-propietario-inmueble/id-prop-inm/{idInmueble}")
	public String inmuebleServiceGetInmWithPropInm(@PathVariable("idInmueble") int idInmueble) {
		return inmServResil.inmuebleServiceGetInmWithPropInm(idInmueble);
	}

	@GetMapping(value = "/id/{idInmueble}")
	public String inmuebleServiceGetById(@PathVariable("idInmueble") int idInmueble) {
		return inmServResil.inmuebleServiceGetById(idInmueble);
	}

	@GetMapping(value = "/id-propietario-inmueble/{idInmueble}")
	public String inmuebleServiceGetByPropInm(@PathVariable("idInmueble") int idInmueble) {
		return inmServResil.inmuebleServiceGetByIdPropInm(idInmueble);
	}

	@GetMapping(value = "/descripcion/{descripcion}")
	public String inmuebleServiceGetByDescripcion(@PathVariable("descripcion") String descripcion) {
		return inmServResil.inmuebleServiceGetByDescripcion(descripcion);
	}

	@GetMapping(value = "/tipo/{tipo}")
	public String inmuebleServiceGetByTipo(@PathVariable("tipo") String tipo) {
		return inmServResil.inmuebleServiceGetByTipo(tipo);
	}

	@GetMapping(value = "/estado-inmueble/{estado-inmueble}")
	public String inmuebleServiceGetByEstadoInmuebleEnum(
			@PathVariable("estado-inmueble") EstadoInmuebleEnum estadoInmueble) {
		return inmServResil.inmuebleServiceGetByEstadoInmuebleEnum(estadoInmueble);
	}

}
