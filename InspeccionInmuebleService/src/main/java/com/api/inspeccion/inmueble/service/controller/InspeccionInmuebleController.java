package com.api.inspeccion.inmueble.service.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmuebleEntity;
import com.api.inspeccion.inmueble.service.enums.EstadoInspeccionEnum;
import com.api.inspeccion.inmueble.service.enums.TipoInspeccionEnum;
import com.api.inspeccion.inmueble.service.service.InspeccionInmuebleService;
import com.api.inspeccion.inmueble.service.valueobject.InspecInmWithInmuebleResponseTemplate;

@RestController
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
	
	// --GET--
	// Template de Inspecciones Inmuebles con Inmueble
	@GetMapping("/inspeccion-inmueble-con-inmueble/id-inmueble/{idInmueble}")
	public InspecInmWithInmuebleResponseTemplate getInspInmWithInm(@PathVariable("idInmueble") int idInmueble) {

		return (InspecInmWithInmuebleResponseTemplate) inspeccionInmuebleService.findByInspecInmWithInmueble(idInmueble);
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
	public List<InspeccionInmuebleEntity> findByEstadoInspeccion(@PathVariable("estadoInspeccion") EstadoInspeccionEnum estadoInspeccion) {

		return inspeccionInmuebleService.findByEstadoInspeccion(estadoInspeccion);

	}
	
	// --GET--
	@GetMapping("/tipo-inspeccion/{tipoInspeccion}")
	public List<InspeccionInmuebleEntity> findByTipoInspeccion(@PathVariable("tipoInspeccion") TipoInspeccionEnum tipoInspeccion) {

		return inspeccionInmuebleService.findByTipoInspeccion(tipoInspeccion);

	}
	
	// --GET--
	@GetMapping("/descripcion-inspeccion/{descripcionInspeccion}")
	public List<InspeccionInmuebleEntity> findByDescripcionInspeccion(@PathVariable("descripcionInspeccion") String descripcionInspeccion) {

		return inspeccionInmuebleService.findByDescripcionInspeccion(descripcionInspeccion);

	}
	
	// --GET--
	@GetMapping("/empresa/{empresa}")
	public List<InspeccionInmuebleEntity> findByEmpresa(@PathVariable("empresa") String empresa) {

		return inspeccionInmuebleService.findByEmpresa(empresa);

	}
	
	// --GET--
	@GetMapping("/direccion/{direccion}")
	public List<InspeccionInmuebleEntity> findByDireccion(@PathVariable("direccion") String direccion) {

		return inspeccionInmuebleService.findByDireccion(direccion);

	}
	
	// --GET--
	@GetMapping("/nro-telefono/{nroTelefono}")
	public List<InspeccionInmuebleEntity> findByNroTelefono(@PathVariable("nroTelefono") String nroTelefono) {
		return inspeccionInmuebleService.findByNroTelefono(nroTelefono);
	}

	// // --GET--
	@GetMapping("/costo/{costo}")
	public List<InspeccionInmuebleEntity> findByCosto(@PathVariable("costo") double costo) {
		return inspeccionInmuebleService.findByCosto(costo);
	}

	// // --GET--
	@GetMapping("/fecha/{fecha}")
	public List<InspeccionInmuebleEntity> findByFecha(@PathVariable("nroTelefono") LocalDate fecha) {
		return inspeccionInmuebleService.findByFecha(fecha);
	}

	// // --GET--
	@GetMapping("/hora/{hora}")
	public List<InspeccionInmuebleEntity> findByHora(@PathVariable("nroTelefono") LocalTime hora) {
		return inspeccionInmuebleService.findByHora(hora);
	}
	
	
	
	
	
	
}
