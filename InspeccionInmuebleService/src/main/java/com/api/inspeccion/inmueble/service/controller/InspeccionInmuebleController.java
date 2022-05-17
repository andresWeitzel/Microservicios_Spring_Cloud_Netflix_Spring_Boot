package com.api.inspeccion.inmueble.service.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.api.inspeccion.inmueble.service.entity.InspeccionInmuebleEntity;
import com.api.inspeccion.inmueble.service.enums.EstadoInspeccionEnum;
import com.api.inspeccion.inmueble.service.enums.TipoInspeccionEnum;
import com.api.inspeccion.inmueble.service.service.InspeccionInmuebleService;
import com.api.inspeccion.inmueble.service.valueobject.InspecInmWithInmuebleResponseTemplate;

@RestController
@RequestMapping("/v1/inspecciones-inmuebles")
public class InspeccionInmuebleController {

	@Autowired
	InspeccionInmuebleService inspeccionInmuebleService;

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	@PostMapping("/")
	public ResponseEntity<?> addInspeccionInmueble(@RequestBody InspeccionInmuebleEntity inspeccionInmueble) {

		try {
			inspeccionInmuebleService.addInspeccionInmueble(inspeccionInmueble);
			return new ResponseEntity<InspeccionInmuebleEntity>(inspeccionInmueble, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ================
	// ===== PUT =====
	// =================
	@PutMapping("/")
	public ResponseEntity<?> updatePropietarioInmueble(@RequestBody InspeccionInmuebleEntity inspeccionInmueble) {

		try {
			inspeccionInmuebleService.updateInspeccionInmueble(inspeccionInmueble);
			return new ResponseEntity<InspeccionInmuebleEntity>(inspeccionInmueble, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ================
	// ===== DELETE =====
	// =================
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePropietarioInmueble(@PathVariable("id") UUID id) {

		try {
			inspeccionInmuebleService.deleteInspeccionInmueble(id);

			return new ResponseEntity<InspeccionInmuebleEntity>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ================
	// ===== GET ALL ==
	// =================
	// -- LISTADO DE INSPECCION DE INMUEBLES PAGINADO--
	@GetMapping("/listado")
	public Page<InspeccionInmuebleEntity> getAll(Pageable pageable) {
		return inspeccionInmuebleService.getAllInspeccionInmueble(pageable);
	}

	// =====================
	// ===== GET TEMPLATE ==
	// =====================
	// -- TEMPLATE DE INSPECCIONES INMUEBLES CON INMUEBLES--
	@GetMapping("/inspeccion-inmueble-con-inmueble/id-inmueble/{idInmueble}")
	public InspecInmWithInmuebleResponseTemplate getInspInmWithInm(@PathVariable("idInmueble") UUID idInmueble) {

		return (InspecInmWithInmuebleResponseTemplate) inspeccionInmuebleService
				.findByInspecInmWithInmueble(idInmueble);
	}

	// ==================================================
	// ============= MÉTODOS HTTP BÚSQUEDA =============
	// ==================================================

	// ===================
	// ===== GET BY ID ===
	// ===================
	// ---INMUEBLE POR ID---
	@GetMapping("/id/{id}")
	public InspeccionInmuebleEntity findById(@PathVariable("id") UUID id) {

		return inspeccionInmuebleService.findById(id);

	}

	// ===========================
	// ===== GET BY ID INMUEBLE===
	// ===========================
	@GetMapping("/id-inmueble/{idInmueble}")
	public InspeccionInmuebleEntity findByIdInmueble(@PathVariable("idInmueble") UUID idInmueble) {

		return inspeccionInmuebleService.findByIdInmueble(idInmueble);

	}

	// ====================================
	// ===== GET BY ESTADO DE INSPECCION===
	// ====================================
	@GetMapping("/estado-inspeccion/{estadoInspeccion}")
	public Page<InspeccionInmuebleEntity> findByEstadoInspeccion(
			@PathVariable("estadoInspeccion") EstadoInspeccionEnum estadoInspeccion, Pageable pageable) {

		return inspeccionInmuebleService.findByEstadoInspeccion(estadoInspeccion, pageable);

	}

	// ====================================
		// ===== GET BY TIPO DE INSPECCION===
		// ====================================
	@GetMapping("/tipo-inspeccion/{tipoInspeccion}")
	public Page<InspeccionInmuebleEntity> findByTipoInspeccion(
			@PathVariable("tipoInspeccion") TipoInspeccionEnum tipoInspeccion, Pageable pageable) {

		return inspeccionInmuebleService.findByTipoInspeccion(tipoInspeccion, pageable);

	}

	// ====================================
		// ===== GET BY DESCRIPCION DE INSPECCION===
		// ====================================
	@GetMapping("/descripcion-inspeccion/{descripcionInspeccion}")
	public Page<InspeccionInmuebleEntity> findByDescripcionInspeccion(
			@PathVariable("descripcionInspeccion") String descripcionInspeccion, Pageable pageable) {

		return inspeccionInmuebleService.findByDescripcionInspeccion(descripcionInspeccion, pageable);

	}

	// --GET--
	@GetMapping("/empresa/{empresa}")
	public Page<InspeccionInmuebleEntity> findByEmpresa(@PathVariable("empresa") String empresa, Pageable pageable) {

		return inspeccionInmuebleService.findByEmpresa(empresa, pageable);

	}

	// --GET--
	@GetMapping("/direccion/{direccion}")
	public Page<InspeccionInmuebleEntity> findByDireccion(@PathVariable("direccion") String direccion, Pageable pageable) {

		return inspeccionInmuebleService.findByDireccion(direccion, pageable);

	}

	// --GET--
	@GetMapping("/nro-telefono/{nroTelefono}")
	public Page<InspeccionInmuebleEntity> findByNroTelefono(@PathVariable("nroTelefono") String nroTelefono, Pageable pageable) {
		return inspeccionInmuebleService.findByNroTelefono(nroTelefono, pageable);
	}

	// // --GET--
	@GetMapping("/costo/{costo}")
	public Page<InspeccionInmuebleEntity> findByCosto(@PathVariable("costo") double costo, Pageable pageable) {
		return inspeccionInmuebleService.findByCosto(costo, pageable);
	}

	// // --GET--
	@GetMapping("/fecha/{fecha}")
	public Page<InspeccionInmuebleEntity> findByFecha(@PathVariable("fecha") Date fecha, Pageable pageable) {
		return inspeccionInmuebleService.findByFecha(fecha, pageable);
	}

	// // --GET--
	@GetMapping("/hora/{hora}")
	public Page<InspeccionInmuebleEntity> findByHora(@PathVariable("hora") Time hora, Pageable pageable) {
		return inspeccionInmuebleService.findByHora(hora, pageable);
	}

}
