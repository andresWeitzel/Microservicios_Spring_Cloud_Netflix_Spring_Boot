package com.api.inspeccion.inmueble.service.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmuebleEntity;
import com.api.inspeccion.inmueble.service.enums.EstadoInspeccionEnum;
import com.api.inspeccion.inmueble.service.enums.TipoInspeccionEnum;
import com.api.inspeccion.inmueble.service.repository.I_InspeccionInmuebleRepository;
import com.api.inspeccion.inmueble.service.valueobject.InmuebleVO;
import com.api.inspeccion.inmueble.service.valueobject.InspecInmWithInmuebleResponseTemplate;

@Service
public class InspeccionInmuebleService {

	// ============ Inyec Dep. ============

	@Autowired
	private I_InspeccionInmuebleRepository iInspeccionInmuebleRepository;

	@Autowired
	private RestTemplate restTemplate;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(InspeccionInmuebleService.class);

	// ============ MÉTODOS CRUD ==================

	// ----INSERT----
	public boolean addInspeccionInmueble(InspeccionInmuebleEntity inspeccionInmueble) {
		try {
			if (inspeccionInmueble == null) {
				logger.error("ERROR addInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
						+ " ES NULO!!");
				return false;
			} else {
				iInspeccionInmuebleRepository.save(inspeccionInmueble);
				return true;
			}

		} catch (Exception e) {
			logger.error("ERROR addInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
					+ " NO SE HA INSERTADO EN LA DB!!");
			return false;
		}
	}

	// ----UPDATE----
	public boolean updateInspeccionInmueble(InspeccionInmuebleEntity inspeccionInmueble) {
		try {
			if (inspeccionInmueble == null) {
				logger.error("ERROR updateInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
						+ " ES NULO!!");
				return false;
			} else {
				iInspeccionInmuebleRepository.save(inspeccionInmueble);
				return true;
			}

		} catch (Exception e) {
			logger.error("ERROR updateInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
					+ " NO SE HA ACTUALIZADO EN LA DB!!");
			return false;
		}
	}

	// ----DELETE----
	public boolean deleteInspeccionInmueble(int id) {
		try {
			if (id == 0) {
				logger.error("ERROR deleteInspeccionInmueble : EL ID DE LA INSPECCION DEL INMUEBLE ES CERO!!");
				return false;
			} else {
				iInspeccionInmuebleRepository.delete(iInspeccionInmuebleRepository.findById(id));
				return true;
			}

		} catch (Exception e) {
			logger.error("ERROR deleteInspeccionInmueble : LA INSPECCION DEL INMUEBLE CON EL ID " + id
					+ " NO SE HA ELIMINADO DE LA DB!!");
			return false;
		}
	}

	// ----SELECT----
	public List<InspeccionInmuebleEntity> getAllInspeccionInmueble(Pageable pageable) {

		return iInspeccionInmuebleRepository.findAll(pageable).getContent();
	}
	

	// ------TEMPLATE INMUEBLE WITH PROPIETARIO_INMUEBLE FIND BY ID---
	public InspecInmWithInmuebleResponseTemplate findByInspecInmWithInmueble(int idInmueble) {
		
		//Template microservices
		InspecInmWithInmuebleResponseTemplate inspecInmWithInmuebleTemplate = new InspecInmWithInmuebleResponseTemplate();
		
		//Buscamos el objeto inspeccion inmueble
		InspeccionInmuebleEntity inspeccionInmueble = iInspeccionInmuebleRepository.findByIdInmueble(idInmueble);
		
		//Buscamos el objeto inmueble
		InmuebleVO inmuebleVO = 
				restTemplate.getForObject("http://INMUEBLE-SERVICE/inmuebles/id/" 
						+ inspeccionInmueble.getIdInmueble() , InmuebleVO.class); 
		
		
		//Guardamos ambos objetos en el Template
		inspecInmWithInmuebleTemplate.setInspeccionInmuebleEntity(inspeccionInmueble);
		inspecInmWithInmuebleTemplate.setInmuebleVO(inmuebleVO);
		
		return inspecInmWithInmuebleTemplate;
		
		
	}
	

	// ============ MÉTODOS DE BÚSQUEDA ==================

	// ----ID-----
	public InspeccionInmuebleEntity findById(int id) {
		return iInspeccionInmuebleRepository.findById(id);
	}

	// ----ID INMUEBLE-----
	public InspeccionInmuebleEntity findByIdInmueble(int idInmueble) {
		return iInspeccionInmuebleRepository.findById(idInmueble);
	}

	// ---- ESTADO INSPECCION-----
	public List<InspeccionInmuebleEntity> findByEstadoInspeccion(EstadoInspeccionEnum estadoInspeccion) {
		return iInspeccionInmuebleRepository.findByEstadoInspeccion(estadoInspeccion);
	}

	// ---- TIPO INSPECCION-----
	public List<InspeccionInmuebleEntity> findByTipoInspeccion(TipoInspeccionEnum tipoInspeccion) {
		return iInspeccionInmuebleRepository.findByTipoInspeccion(tipoInspeccion);
	}

	// ---- DESCRIPCION INSPECCION-----
	public List<InspeccionInmuebleEntity> findByDescripcionInspeccion(String descripcionInspeccion) {
		return iInspeccionInmuebleRepository.findByDescripcionInspeccion(descripcionInspeccion);
	}

	// ---- EMPRESA-----
	public List<InspeccionInmuebleEntity> findByEmpresa(String empresa) {
		return iInspeccionInmuebleRepository.findByEmpresa(empresa);
	}

	// ---- DIRECCION -----
	public List<InspeccionInmuebleEntity> findByDireccion(String direccion) {
		return iInspeccionInmuebleRepository.findByDireccion(direccion);
	}

	// ---- NRO TELEFONO -----
	public List<InspeccionInmuebleEntity> findByNroTelefono(String nroTelefono) {
		return iInspeccionInmuebleRepository.findByNroTelefono(nroTelefono);
	}

	// ---- COSTO -----
	public List<InspeccionInmuebleEntity> findByCosto(double costo) {
		return iInspeccionInmuebleRepository.findByCosto(costo);
	}

	// ---- FECHA -----
	public List<InspeccionInmuebleEntity> findByFecha(LocalDate fecha) {
		return iInspeccionInmuebleRepository.findByFecha(fecha);
	}

	// ---- HORA -----
	public List<InspeccionInmuebleEntity> findByHora(LocalTime hora) {
		return iInspeccionInmuebleRepository.findByHora(hora);
	}

}
