package com.inmueble.service.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmueble.service.entity.PropietarioInmuebleEntity;
import com.inmueble.service.service.PropietarioInmuebleService;

@RestController
@RequestMapping("/propietarios-inmuebles")
public class PropietarioInmuebleController {

	@Autowired
	private PropietarioInmuebleService propietarioInmuebleService;

	// ======== MÉTODOS HTTP ============
	// --POST--
	@PostMapping("/")
	public boolean addPropietarioInmueble(@RequestBody PropietarioInmuebleEntity propietarioInmueble) {

		return propietarioInmuebleService.addPropietarioInmueble(propietarioInmueble);

	}

	// --PUT--
	@PutMapping("/")
	public boolean updatePropietarioInmueble(@RequestBody PropietarioInmuebleEntity propietarioInmueble) {

		return propietarioInmuebleService.updatePropietarioInmueble(propietarioInmueble);

	}
	
	
	
	
	// --DELETE--
	@DeleteMapping("/{id}")
	public boolean deletePropietarioInmueble(@PathVariable("id") int id) {

		return propietarioInmuebleService.deletePropietarioInmueble(id);
	}



	// --GET--
	@GetMapping("/listado")
	public List<PropietarioInmuebleEntity> getAll(Pageable pageable) {
		return propietarioInmuebleService.getAllPropietarioInmueble(pageable);
	}
	
	
	
	// ======== MÉTODOS DE BUSQUEDA ============
	
	
	// --GET--
	@GetMapping("/id/{id}")
	public PropietarioInmuebleEntity findById(@PathVariable("id") int id) {

		return propietarioInmuebleService.findById(id);

	}
	

	// --GET--
	@GetMapping("/nombre/{nombre}")
	public List<PropietarioInmuebleEntity> findByNombre(@PathVariable("nombre") String nombre) {

		return propietarioInmuebleService.findByNombre(nombre);

	}

	// --GET--
	@GetMapping("/apellido/{apellido}")
	public List<PropietarioInmuebleEntity> findByApellido(@PathVariable("apellido") String apellido) {

		return propietarioInmuebleService.findByApellido(apellido);

	}

	// --GET--
	@GetMapping("/edad/{edad}")
	public List<PropietarioInmuebleEntity> findByEdad(@PathVariable("edad") int edad) {

		return propietarioInmuebleService.findByEdad(edad);

	}

	// --GET--
	@GetMapping("/fecha-nacimiento/{fecha}")
	public List<PropietarioInmuebleEntity> findByFechaNacimiento(
			@PathVariable("fecha") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fechaNacimiento) {

		return propietarioInmuebleService.findByFechaNacimiento(fechaNacimiento);

	}

	// --GET--
	@GetMapping("/tipo-documento/{tipo_documento}")
	public List<PropietarioInmuebleEntity> findByTipoDocumento(@PathVariable("tipo_documento") String tipoDocumento) {

		return propietarioInmuebleService.findByTipoDocumento(tipoDocumento);

	}

	// --GET--
	@GetMapping("/nro-documento/{nro_documento}")
	public List<PropietarioInmuebleEntity> findByNroDocumento(@PathVariable("nro_documento") String nroDocumento) {

		return propietarioInmuebleService.findByNroDocumento(nroDocumento);

	}

	// --GET--
	@GetMapping("/direccion/{direccion}")
	public List<PropietarioInmuebleEntity> findByDireccion(@PathVariable("direccion") String direcccion) {

		return propietarioInmuebleService.findByDireccion(direcccion);

	}

	// --GET--
	@GetMapping("/nro-telefono-principal/{nro-tel-princ}")
	public List<PropietarioInmuebleEntity> findByNroTelefonoPrincipal(@PathVariable("nro-tel-princ") String nroTelefonoPrincipal) {

		return propietarioInmuebleService.findByNroTelefonoPrincipal(nroTelefonoPrincipal);

	}

	// --GET--
	@GetMapping("/nro-telefono-secundario/{nro-tel-sec}")
	public List<PropietarioInmuebleEntity> findByNroTelefonoSecundario(@PathVariable("nro-tel-sec") String nroTelefonoSecundario) {

		return propietarioInmuebleService.findByNroTelefonoSecundario(nroTelefonoSecundario);

	}
	
	// --GET--
	@GetMapping("/email/{email}")
	public List<PropietarioInmuebleEntity> findByEmail(@PathVariable("email") String email) {

		return propietarioInmuebleService.findByEmail(email);

	}

}
