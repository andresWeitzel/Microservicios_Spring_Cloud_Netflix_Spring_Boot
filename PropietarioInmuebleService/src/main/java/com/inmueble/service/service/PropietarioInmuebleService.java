package com.inmueble.service.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.inmueble.service.entity.PropietarioInmueble;
import com.inmueble.service.repository.I_PropietarioInmuebleRepository;

@Service
public class PropietarioInmuebleService {

	//============ Inyec Dep. ============
	
	@Autowired
	private I_PropietarioInmuebleRepository iPropInmRepository;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(PropietarioInmuebleService.class);

	// ============ MÉTODOS CRUD ==================

	// ----INSERT----
	public void addPropInm(PropietarioInmueble propInm) {
		try {
			//Si es Nulo o Vacio
			if (propInm == null || propInm.toString().isEmpty()) {
				logger.error("ERROR addPropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm
						+ " ES NULO O VACIO!!");
			
			} else {
				iPropInmRepository.save(propInm);
				
			}

		} catch (Exception e) {
			logger.error("ERROR addInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm
					+ " NO SE HA INSERTADO EN LA DB!!");
			
		}
	}

	// ----UPDATE----
	public void updatePropInm(PropietarioInmueble propInm) {
		try {
			
			if (propInm == null) {
				logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm
						+ " ES NULO!!");
				
			} else {
				iPropInmRepository.save(propInm);
				
			}

		} catch (Exception e) {
			logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propInm
					+ " NO SE HA ACTUALIZADO EN LA DB!!");
			
		}
	}

	// ----DELETE----
	public void deletePropInm(UUID id) {
		try {
			if (id == null) {
				logger.error("ERROR deletePropietarioInmueble : EL ID DEL PROPIETARIO DEL INMUEBLE NO EXISTE!!");
				
			} else {
				iPropInmRepository.deleteById(id);
				
			}

		} catch (Exception e) {
			logger.error("ERROR deletePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE CON EL ID " + id
					+ " NO SE HA ELIMINADO DE LA DB!!");
			
		}
	}

	// ----SELECT----
	public Page<PropietarioInmueble> getAllPropInm(Pageable pageable) {

		return iPropInmRepository.findAll(pageable);
	}

	// ============ MÉTODOS DE BÚSQUEDA ==================

	// ----ID-----
	public PropietarioInmueble findById(UUID id) {
		return iPropInmRepository.findById(id);
	}

	// ---- NOMBRE-----
	public Page<PropietarioInmueble> findByNombre(String nombre, Pageable pageable) {
		return iPropInmRepository.findByNombre(nombre, pageable);
	}

	// ---- APELLIDO-----
	public Page<PropietarioInmueble> findByApellido(String apellido, Pageable pageable) {
		return iPropInmRepository.findByApellido(apellido, pageable);
	}

	// ---- EDAD -----
	public Page<PropietarioInmueble> findByEdad(int edad, Pageable pageable) {
		return iPropInmRepository.findByEdad(edad, pageable);
	}

	// ---- FECHA_NACIMIENTO -----
	public Page<PropietarioInmueble> findByFechaNac(Date fechaNac, Pageable pageable) {
		return iPropInmRepository.findByFechaNac(fechaNac, pageable);
	}

	// ---- TIPO_DOCUMENTO -----
	public Page<PropietarioInmueble> findByTipoDoc(String tipoDoc, Pageable pageable) {
		return iPropInmRepository.findByTipoDoc(tipoDoc, pageable);
	}

	// ---- NRO_DOCUMENTO -----
	public Page<PropietarioInmueble> findByNroDoc(String nroDoc, Pageable pageable) {
		return iPropInmRepository.findByNroDoc(nroDoc, pageable);
	}

	// ---- DIRECCION -----
	public Page<PropietarioInmueble> findByDirec(String direccion, Pageable pageable) {
		return iPropInmRepository.findByDirec(direccion, pageable);
	}

	// ---- NRO_TELEFONO_PRINCIPAL -----
	public Page<PropietarioInmueble> findByNroTelPrinc(String nroTelPrinc, Pageable pageable) {
		return iPropInmRepository.findByNroTelPrinc(nroTelPrinc, pageable);
	}

	// ---- NRO_TELEFONO_SECUNDARIO -----
	public Page<PropietarioInmueble> findByNroTelSec(String nroTelSec, Pageable pageable) {
		return iPropInmRepository.findByNroTelSec(nroTelSec, pageable);
	}

	// ---- EMAIL -----
	public Page<PropietarioInmueble> findByEmail(String email, Pageable pageable) {
		return iPropInmRepository.findByEmail(email, pageable);
	}
}

