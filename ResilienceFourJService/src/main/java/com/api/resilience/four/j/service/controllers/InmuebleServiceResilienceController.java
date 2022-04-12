package com.api.resilience.four.j.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.resilience.four.j.service.services.InmuebleServiceResilienceService;

@RestController
@RequestMapping("/inmueble-service")
public class InmuebleServiceResilienceController {
	
	@Autowired
	InmuebleServiceResilienceService inmServResil;
	
	@GetMapping(value="/listado")
	public String inmuebleServiceGetList() {
		return inmServResil.inmuebleServiceGetList();
	}
	
	@GetMapping(value="/inmueble-con-propietario-inmueble/id-prop-inm/{idInmueble}")
	public String inmuebleServiceGetInmWithPropInm(@PathVariable("idInmueble") int idInmueble) {
		return inmServResil.inmuebleServiceGetInmWithPropInm(idInmueble);
	}
	
	@GetMapping(value="/id/{idInmueble}")
	public String inmuebleServiceGetById(@PathVariable("idInmueble") int idInmueble) {
		return inmServResil.inmuebleServiceGetById(idInmueble);
	}
	
	@GetMapping(value="/id-propietario-inmueble/{idInmueble}")
	public String inmuebleServiceGetByPropInm(@PathVariable("idInmueble") int idInmueble) {
		return inmServResil.inmuebleServiceGetByIdPropInm(idInmueble);
	}
	
	@GetMapping(value="/descripcion/{descripcion}")
	public String inmuebleServiceGetByDescripcion(@PathVariable("descripcion") String descripcion) {
		return inmServResil.inmuebleServiceGetByDescripcion(descripcion);
	}
	
	@GetMapping(value="/tipo/{tipo}")
	public String inmuebleServiceGetByTipo(@PathVariable("tipo") String tipo) {
		return inmServResil.inmuebleServiceGetByTipo(tipo);
	}
	
	
	
	
}
