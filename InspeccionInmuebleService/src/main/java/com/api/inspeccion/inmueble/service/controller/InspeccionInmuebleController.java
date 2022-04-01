package com.api.inspeccion.inmueble.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmuebleEntity;
import com.api.inspeccion.inmueble.service.enums.EstadoInspeccionEnum;
import com.api.inspeccion.inmueble.service.service.InspeccionInmuebleService;

@Controller
@RequestMapping("/inspecciones-inmuebles")
public class InspeccionInmuebleController {
	
	@Autowired
	InspeccionInmuebleService inspeccionInmuebleService;


	// ======== MÉTODOS HTTP ============
	// --POST--
	@PostMapping("/")
	public boolean addInspeccionInmueble(@RequestBody InspeccionInmuebleEntity inspeccionInmueble) {

		return inspeccionInmuebleService.addInspeccionInmueble(inspeccionInmueble);

	}

	// --PUT--
	@PutMapping("/")
	public boolean updatePropietarioInmueble(@RequestBody InspeccionInmuebleEntity inspeccionInmueble) {

		return inspeccionInmuebleService.updateInspeccionInmueble(inspeccionInmueble);

	}
	
	
	
	
	// --DELETE--
	@DeleteMapping("/{id}")
	public boolean deletePropietarioInmueble(@PathVariable("id") int id) {

		return inspeccionInmuebleService.deleteInspeccionInmueble(id);
	}



	// --GET--
	@GetMapping("/listado")
	public List<InspeccionInmuebleEntity> getAll(Pageable pageable) {
		return inspeccionInmuebleService.getAllInspeccionInmueble(pageable);
	}
	

	
	// ======== MÉTODOS DE BUSQUEDA ============
	
	
	// --GET--
	@GetMapping("/id/{id}")
	public InspeccionInmuebleEntity findById(@PathVariable("id") int id) {

		return inspeccionInmuebleService.findById(id);

	}
	
	
	// --GET--
	@GetMapping("/id-inmueble/{idInmueble}")
	public InspeccionInmuebleEntity findByIdInmueble(@PathVariable("idInmueble") int idInmueble) {

		return inspeccionInmuebleService.findByIdInmueble(idInmueble);

	}
	
	
	
	// --GET--
	@GetMapping("/estado-inspeccion/{estadoInspeccion}")
	public List<InspeccionInmuebleEntity> findByNombre(@PathVariable("estadoInspeccion") EstadoInspeccionEnum estadoInspeccion) {

		return inspeccionInmuebleService.findByEstadoInspeccion(estadoInspeccion);

	}
	
	
}
