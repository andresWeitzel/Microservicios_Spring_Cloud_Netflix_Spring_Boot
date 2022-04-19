package com.api.resilience.four.j.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@DeleteMapping(value = "/{id}")
	public String inmuebleServiceDeleteInmueble(@PathVariable("id") int id ) {
		return inmServResil.inmuebleServiceDeleteInmueble(id);
	}
	
	//-- GET ALL INMUEBLE--
	@GetMapping(value = "/listado")
	public String inmuebleServiceGetAll() {
		return inmServResil.inmuebleServiceGetAll();
	}

	// ======== MÉTODOS DE BUSQUEDA ============

	

	@GetMapping(value = "/inmueble-con-propietario-inmueble/{id}")
	public String inmuebleServiceGetInmWithPropInm(@PathVariable("id") int id) {
		return inmServResil.inmuebleServiceGetInmWithPropInm(id);
	}

	@GetMapping(value = "/id/{id}")
	public String inmuebleServiceGetById(@PathVariable("id") int id) {
		return inmServResil.inmuebleServiceGetById(id);
	}

	@GetMapping(value = "/id-propietario-inmueble/{id}")
	public String inmuebleServiceGetByPropInm(@PathVariable("id") int id) {
		return inmServResil.inmuebleServiceGetByIdPropInm(id);
	}

	@GetMapping(value = "/descripcion/{descripcion}")
	public String inmuebleServiceGetByDescripcion(@PathVariable("descripcion") String descripcion) {
		return inmServResil.inmuebleServiceGetByDescripcion(descripcion);
	}

	@GetMapping(value = "/tipo/{tipo}")
	public String inmuebleServiceGetByTipo(@PathVariable("tipo") String tipo) {
		return inmServResil.inmuebleServiceGetByTipo(tipo);
	}

	@GetMapping(value = "/estado-inmueble/{estado}")
	public String inmuebleServiceGetByEstadoInmuebleEnum(
			@PathVariable("estado") EstadoInmuebleEnum estado) {
		return inmServResil.inmuebleServiceGetByEstadoInmuebleEnum(estado);
	}
	
	@GetMapping(value = "/precio/{precio}")
	public String inmuebleServiceGetByPrecio(
			@PathVariable("precio") double precio) {
		return inmServResil.inmuebleServiceGetByPrecio(precio);
	}
	
	@GetMapping(value = "/direccion/{direccion}")
	public String inmuebleServiceGetByDireccion(
			@PathVariable("direccion") String direccion) {
		return inmServResil.inmuebleServiceGetByDireccion(direccion);
	}

	
	@GetMapping(value = "/ubicacion/{ubicacion}")
	public String inmuebleServiceGetByUbicacion(
			@PathVariable("ubicacion") String ubicacion) {
		return inmServResil.inmuebleServiceGetByUbicacion(ubicacion);
	}
	
	@GetMapping(value = "/sitio-web/{sitio-web}")
	public String inmuebleServiceGetBySitioWeb(
			@PathVariable("sitio-web") String sitioWeb) {
		return inmServResil.inmuebleServiceGetBySitioWeb(sitioWeb);
	}

}
