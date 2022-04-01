package com.inmueble.service.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.inmueble.service.entity.PropietarioInmuebleEntity;
import com.inmueble.service.repository.I_PropietarioInmuebleRepository;

@Service
public class PropietarioInmuebleService {

	//============ Inyec Dep. ============
	
	@Autowired
	private I_PropietarioInmuebleRepository iPropietarioInmuebleRepository;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(PropietarioInmuebleService.class);

	// ============ MÉTODOS CRUD ==================

	// ----INSERT----
	public boolean addPropietarioInmueble(PropietarioInmuebleEntity propietarioInmueble) {
		try {
			if (propietarioInmueble == null) {
				logger.error("ERROR addPropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propietarioInmueble
						+ " ES NULO!!");
				return false;
			} else {
				iPropietarioInmuebleRepository.save(propietarioInmueble);
				return true;
			}

		} catch (Exception e) {
			logger.error("ERROR addInmueble : EL PROPIETARIO DEL INMUEBLE " + propietarioInmueble
					+ " NO SE HA INSERTADO EN LA DB!!");
			return false;
		}
	}

	// ----UPDATE----
	public boolean updatePropietarioInmueble(PropietarioInmuebleEntity propietarioInmueble) {
		try {
			if (propietarioInmueble == null) {
				logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propietarioInmueble
						+ " ES NULO!!");
				return false;
			} else {
				iPropietarioInmuebleRepository.save(propietarioInmueble);
				return true;
			}

		} catch (Exception e) {
			logger.error("ERROR updatePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propietarioInmueble
					+ " NO SE HA ACTUALIZADO EN LA DB!!");
			return false;
		}
	}

	// ----DELETE----
	public boolean deletePropietarioInmueble(int id) {
		try {
			if (id == 0) {
				logger.error("ERROR deletePropietarioInmueble : EL ID DEL PROPIETARIO DEL INMUEBLE ES CERO!!");
				return false;
			} else {
				iPropietarioInmuebleRepository.delete(iPropietarioInmuebleRepository.findById(id));
				return true;
			}

		} catch (Exception e) {
			logger.error("ERROR deletePropietarioInmueble : EL PROPIETARIO DEL INMUEBLE CON EL ID " + id
					+ " NO SE HA ELIMINADO DE LA DB!!");
			return false;
		}
	}

	// ----SELECT----
	public List<PropietarioInmuebleEntity> getAllPropietarioInmueble(Pageable pageable) {

		return iPropietarioInmuebleRepository.findAll(pageable).getContent();
	}

	// ============ MÉTODOS DE BÚSQUEDA ==================

	// ----ID-----
	public PropietarioInmuebleEntity findById(int id) {
		return iPropietarioInmuebleRepository.findById(id);
	}

	// ---- NOMBRE-----
	public List<PropietarioInmuebleEntity> findByNombre(String nombre) {
		return iPropietarioInmuebleRepository.findByNombre(nombre);
	}

	// ---- APELLIDO-----
	public List<PropietarioInmuebleEntity> findByApellido(String apellido) {
		return iPropietarioInmuebleRepository.findByApellido(apellido);
	}

	// ---- EDAD -----
	public List<PropietarioInmuebleEntity> findByEdad(int edad) {
		return iPropietarioInmuebleRepository.findByEdad(edad);
	}

	// ---- FECHA_NACIMIENTO -----
	public List<PropietarioInmuebleEntity> findByFechaNacimiento(LocalDate fechaNacimiento) {
		return iPropietarioInmuebleRepository.findByFechaNacimiento(fechaNacimiento);
	}

	// ---- TIPO_DOCUMENTO -----
	public List<PropietarioInmuebleEntity> findByTipoDocumento(String tipoDocumento) {
		return iPropietarioInmuebleRepository.findByTipoDocumento(tipoDocumento);
	}

	// ---- NRO_DOCUMENTO -----
	public List<PropietarioInmuebleEntity> findByNroDocumento(String nroDocumento) {
		return iPropietarioInmuebleRepository.findByNroDocumento(nroDocumento);
	}

	// ---- DIRECCION -----
	public List<PropietarioInmuebleEntity> findByDireccion(String direccion) {
		return iPropietarioInmuebleRepository.findByDireccion(direccion);
	}

	// ---- NRO_TELEFONO_PRINCIPAL -----
	public List<PropietarioInmuebleEntity> findByNroTelefonoPrincipal(String nroTelefonoPrincipal) {
		return iPropietarioInmuebleRepository.findByNroTelefonoPrincipal(nroTelefonoPrincipal);
	}

	// ---- NRO_TELEFONO_SECUNDARIO -----
	public List<PropietarioInmuebleEntity> findByNroTelefonoSecundario(String nroTelefonoSecundario) {
		return iPropietarioInmuebleRepository.findByNroTelefonoSecundario(nroTelefonoSecundario);
	}

	// ---- EMAIL -----
	public List<PropietarioInmuebleEntity> findByEmail(String email) {
		return iPropietarioInmuebleRepository.findByEmail(email);
	}
}

