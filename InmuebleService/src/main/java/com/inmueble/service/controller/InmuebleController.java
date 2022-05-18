package com.inmueble.service.controller;


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

import com.inmueble.service.entity.InmuebleEntity;
import com.inmueble.service.service.InmuebleService;
import com.inmueble.service.valueobject.InmWithPropInmResponseTemplate;

@RestController
@RequestMapping("/v1/inmuebles")
public class InmuebleController {

	@Autowired
	private InmuebleService inmService;

	// ===============================================
	// ============= MÉTODOS HTTP CRUD ==============
	// ===============================================

	// ================
	// ===== POST =====
	// =================
	@PostMapping("/")
	public ResponseEntity<?> addInm(@RequestBody InmuebleEntity inm) {

		try {
			inmService.addInm(inm);
			return new ResponseEntity<InmuebleEntity>(inm, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ================
	// ===== PUT =====
	// =================
	@PutMapping("/")
	public ResponseEntity<?> updateInm(@RequestBody InmuebleEntity inm) {

		try {
			inmService.updateInm(inm);
			return new ResponseEntity<InmuebleEntity>(inm, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	// ================
	// ===== DELETE =====
	// =================
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteInm(@PathVariable("id") UUID id) {

		try {
			inmService.deleteInm(id);
			return new ResponseEntity<InmuebleEntity>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);

		}
	}

	// ===================
	// ===== GET ALL =====
	// ===================
	// ---LISTADO DE INMUEBLES PAGINADO---
	@GetMapping("/listado")
	public Page<InmuebleEntity> getAllInm(Pageable pageable) {
		return inmService.getAllInm(pageable);
	}

	// ===================
	// ===== GET TEMPLATE =====
	// ===================
	// ---TEMPLATE INMUEBLE CON PROPIETARIO DEL INMUEBLE---
	@GetMapping("/inmueble-con-propietario-inmueble/id-inm/{id}")
	public InmWithPropInmResponseTemplate getInmWithPropInmId(@PathVariable("id") UUID idInmueble) {

		return (InmWithPropInmResponseTemplate) inmService.findByInmWithPropInm(idInmueble);
	}

	// ==================================================
	// ============= MÉTODOS HTTP BÚSQUEDA =============
	// ==================================================

	// ===================
	// ===== GET BY ID ===
	// ===================
	// ---INMUEBLE POR ID---
	@GetMapping("/id/{id}")
	public InmuebleEntity findById(@PathVariable("id") UUID id) {

		return inmService.findById(id);

	}

	// ==============================
	// ===== GET BY ID-PROPIETARIO===
	// ==============================
	// ---INMUEBLES SEGUN ID DE PROPIETARIO ---
	@GetMapping("/id-propietario-inmueble/{id}")
	public Page<InmuebleEntity> findByIdPropInm(@PathVariable("id") UUID id, Pageable pageable) {

		return inmService.findByIdPropInm(id, pageable);

	}

	// ============================
	// ===== GET BY DESCRIPCION ===
	// ============================
	// ---INMUEBLE POR DESCRIPCION---
	@GetMapping("/descripcion/{descripcion}")
	public Page<InmuebleEntity> findByDescr(@PathVariable("descripcion") String descripcion, Pageable pageable) {

		return inmService.findByDescr(descripcion, pageable);

	}

	// =====================
	// ===== GET BY TIPO ===
	// =====================
	// ---INMUEBLE POR TIPO---
	@GetMapping("/tipo/{tipo}")
	public Page<InmuebleEntity> findByTipo(@PathVariable("tipo") String tipo, Pageable pageable) {

		return inmService.findByTipo(tipo, pageable);

	}

	// ================================
	// ===== GET BY ESTADO-INMUEBLE ===
	// ================================
	// ---INMUEBLE POR ESTADO DEL INMUEBLE---
	@GetMapping("/estado-inmueble/{estado}")
	public Page<InmuebleEntity> findByEstadoInm(@PathVariable("estado") String estado, Pageable pageable) {

		return inmService.findByEstadoInm(estado, pageable);

	}

	// =======================
	// ===== GET BY PRECIO ===
	// =======================
	// ---INMUEBLE POR PRECIO---
	@GetMapping("/precio/{precio}")
	public Page<InmuebleEntity> findByPrecInm(@PathVariable("precio") double precio, Pageable pageable) {

		return inmService.findByPrecInm(precio, pageable);

	}

	// ==========================
	// ===== GET BY DIRECCION ===
	// ==========================
	// ---INMUEBLE POR DIRECCION---
	@GetMapping("/direccion/{direccion}")
	public Page<InmuebleEntity> findByDirec(@PathVariable("direccion") String direccion, Pageable pageable) {

		return inmService.findByDirec(direccion, pageable);

	}

	// ==========================
	// ===== GET BY UBICACION ===
	// ==========================
	// ---INMUEBLE POR UBICACION---
	@GetMapping("/ubicacion/{ubicacion}")
	public Page<InmuebleEntity> findByUbic(@PathVariable("ubicacion") String ubicacion, Pageable pageable) {

		return inmService.findByUbic(ubicacion, pageable);

	}

	// ==========================
	// ===== GET BY SITIO-WEB ===
	// ==========================
	// ---INMUEBLE POR SITIO-WEB---
	@GetMapping("/sitio-web/{sitio-web}")
	public Page<InmuebleEntity> findBySitWeb(@PathVariable("sitio-web") String sitioWeb, Pageable pageable) {

		return inmService.findBySitWeb(sitioWeb, pageable);

	}

}
