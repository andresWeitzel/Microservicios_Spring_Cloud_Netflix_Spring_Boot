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

import com.api.inspeccion.inmueble.service.entity.InspeccionInmueble;
import com.api.inspeccion.inmueble.service.service.InspeccionInmuebleService;
import com.api.inspeccion.inmueble.service.valueobject.InspInmWithInmResponseTemplate;

@RestController
@RequestMapping("/v1/inspecciones-inmuebles")
public class InspeccionInmuebleController {

	@Autowired
	InspeccionInmuebleService inspInmService;

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	@PostMapping("/")
	public ResponseEntity<?> addInspInm(@RequestBody InspeccionInmueble inspInm) {

		try {

			boolean inspInmCheck = (inspInmService.addInspInm(inspInm)) ? true : false;

			if (inspInmCheck) {
				return new ResponseEntity<InspeccionInmueble>(inspInm, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(
						"No se ha Insertado la Inspección del Inmueble " + "en la Base de datos ",
						HttpStatus.UNPROCESSABLE_ENTITY);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ================
	// ===== PUT =====
	// =================
	@PutMapping("/")
	public ResponseEntity<?> updatePropInm(@RequestBody InspeccionInmueble inspInm) {

		try {

			boolean inspInmCheck = (inspInmService.addInspInm(inspInm)) ? true : false;

			if (inspInmCheck) {
				return new ResponseEntity<InspeccionInmueble>(inspInm, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(
						"No se ha Actualizado la Inspección del Inmueble " + "en la Base de datos ",
						HttpStatus.UNPROCESSABLE_ENTITY);
			}

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

			boolean inspInmCheck = (inspInmService.deleteInspInm(id)) ? true : false;

			if (inspInmCheck) {
				return new ResponseEntity<String>(
						"Se ha Eliminado la Inspección del Inmueble " + "de la Base de datos ",
						HttpStatus.UNPROCESSABLE_ENTITY);
			} else {
				return new ResponseEntity<String>(
						"No se ha Eliminado la Inspección del Inmueble " + "de la Base de datos ",
						HttpStatus.UNPROCESSABLE_ENTITY);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ================
	// ===== GET ALL ==
	// =================
	// -- LISTADO DE INSPECCION DE INMUEBLES PAGINADO--
	@GetMapping("/listado")
	public Page<InspeccionInmueble> getAll(Pageable pageable) {
		return inspInmService.getAllInspInm(pageable);
	}

	// =====================
	// ===== GET TEMPLATE ==
	// =====================
	// -- TEMPLATE DE INSPECCIONES INMUEBLES CON INMUEBLES--
	@GetMapping("/inspeccion-inmueble-con-inmueble/id-inmueble/{idInmueble}")
	public InspInmWithInmResponseTemplate getInspInmWithInm(@PathVariable("idInmueble") UUID idInmueble) {

		return (InspInmWithInmResponseTemplate) inspInmService.findByInspInmWithInm(idInmueble);
	}

	// ==================================================
	// ============= MÉTODOS HTTP BÚSQUEDA =============
	// ==================================================

	// ===================
	// ===== GET BY ID ===
	// ===================
	// ---INMUEBLE POR ID---
	@GetMapping("/id/{id}")
	public InspeccionInmueble findById(@PathVariable("id") UUID id) {

		return inspInmService.findById(id);

	}

	// ===========================
	// ===== GET BY ID INMUEBLE===
	// ===========================
	@GetMapping("/id-inmueble/{idInmueble}")
	public InspeccionInmueble findByIdInm(@PathVariable("idInmueble") UUID idInmueble) {

		return inspInmService.findByIdInm(idInmueble);

	}

	// ====================================
	// ===== GET BY ESTADO DE INSPECCION===
	// ====================================
	@GetMapping("/estado-inspeccion/{estadoInspeccion}")
	public Page<InspeccionInmueble> findByEstadoInsp(
			@PathVariable("estadoInspeccion") String estadoInsp, Pageable pageable) {

		return inspInmService.findByEstadoInsp(estadoInsp, pageable);

	}

	// ====================================
	// ===== GET BY TIPO DE INSPECCION===
	// ====================================
	@GetMapping("/tipo-inspeccion/{tipoInspeccion}")
	public Page<InspeccionInmueble> findByTipoInsp(
			@PathVariable("tipoInspeccion") String tipoInsp, Pageable pageable) {

		return inspInmService.findByTipoInsp(tipoInsp, pageable);

	}

	// ====================================
	// ===== GET BY DESCRIPCION DE INSPECCION===
	// ====================================
	@GetMapping("/descripcion-inspeccion/{descripcionInspeccion}")
	public Page<InspeccionInmueble> findByDescrInsp(
			@PathVariable("descripcionInspeccion") String descrInsp, Pageable pageable) {

		return inspInmService.findByDescrInsp(descrInsp, pageable);

	}

	// --GET--
	@GetMapping("/empresa/{empresa}")
	public Page<InspeccionInmueble> findByEmpresa(@PathVariable("empresa") String empresa, Pageable pageable) {

		return inspInmService.findByEmpresa(empresa, pageable);

	}

	// --GET--
	@GetMapping("/direccion/{direccion}")
	public Page<InspeccionInmueble> findByDirec(@PathVariable("direccion") String direccion, Pageable pageable) {

		return inspInmService.findByDirec(direccion, pageable);

	}

	// --GET--
	@GetMapping("/nro-telefono/{nroTelefono}")
	public Page<InspeccionInmueble> findByNroTel(@PathVariable("nroTelefono") String nroTelefono,
			Pageable pageable) {
		return inspInmService.findByNroTel(nroTelefono, pageable);
	}

	// // --GET--
	@GetMapping("/costo/{costo}")
	public Page<InspeccionInmueble> findByCosto(@PathVariable("costo") double costo, Pageable pageable) {
		return inspInmService.findByCosto(costo, pageable);
	}

	// // --GET--
	@GetMapping("/fecha/{fecha}")
	public Page<InspeccionInmueble> findByFecha(@PathVariable("fecha") Date fecha, Pageable pageable) {
		return inspInmService.findByFecha(fecha, pageable);
	}

	// // --GET--
	@GetMapping("/hora/{hora}")
	public Page<InspeccionInmueble> findByHora(@PathVariable("hora") Time hora, Pageable pageable) {
		return inspInmService.findByHora(hora, pageable);
	}

}
