package com.inmueble.service.service;

import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inmueble.service.entity.InmuebleEntity;
import com.inmueble.service.repository.I_InmuebleRepository;
import com.inmueble.service.valueobject.InmWithPropInmResponseTemplate;
import com.inmueble.service.valueobject.PropietarioInmuebleVO;

@Service
public class InmuebleService {

	// ============ Inyec Dep. ============
	@Autowired
	private I_InmuebleRepository iInmRepository;

	@Autowired
	private RestTemplate restTemplate;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(InmuebleService.class);

	// ============ MÉTODOS CRUD ==================

	// ----INSERT----
	public boolean addInm(InmuebleEntity inm) {
		try {
			if (inm == null) {
				logger.error("ERROR addInmueble : EL INMUEBLE " + inm + " ES NULO!!");
				return false;
			} else {
				iInmRepository.save(inm);
				return true;

			}

		} catch (Exception e) {
			logger.error("ERROR addInmueble : EL INMUEBLE " + inm + " NO SE HA INSERTADO EN LA DB!!");
			return false;

		}
	}

	// ----UPDATE----
	public boolean updateInm(InmuebleEntity inm) {
		try {
			if (inm == null) {
				logger.error("ERROR updateInmueble : EL INMUEBLE " + inm + " ES NULO!!");
				return false;
			} else {
				iInmRepository.save(inm);
				return true;
				
			}

		} catch (Exception e) {
			logger.error("ERROR updateInmueble : EL INMUEBLE " + inm + " NO SE HA ACTUALIZADO EN LA DB!!");
			return false;
		}
	}

	// ----DELETE----
	public boolean deleteInm(UUID id) {
		try {
			if (id == null) {
				logger.error("ERROR deleteInmueble : EL INMUEBLE ES NO EXISTE!!");
				return false;
			} else {
				iInmRepository.deleteById(id);
				return true;
				
			}

		} catch (Exception e) {
			logger.error("ERROR deleteInmueble : EL ID DEL INMUEBLE " + id + " NO SE HA ELIMINADO DE LA DB!!");
			return false;
			
		}
	}

	// ----SELECT----
	public Page<InmuebleEntity> getAllInm(Pageable pageable) {

		return iInmRepository.findAll(pageable);
	}

	
	// ------TEMPLATE INMUEBLE WITH PROPIETARIO_INMUEBLE FIND BY ID---
	public InmWithPropInmResponseTemplate findByInmWithPropInm(UUID idInm) {

		// Template microservices
		InmWithPropInmResponseTemplate inmWithPropInmTemplate = new InmWithPropInmResponseTemplate();

		// buscamos el objeto inmueble
		InmuebleEntity inmueble = iInmRepository.findById(idInm);

		// buscamos el objeto Prop Inm
		PropietarioInmuebleVO propietarioInmuebleVO = restTemplate.getForObject(
				"http://PROPIETARIO-INMUEBLE-SERVICE/v1/propietarios-inmuebles/id/" + inmueble.getIdPropInm(),
				PropietarioInmuebleVO.class);

		// Guardamos ambos objetos en el Template
		inmWithPropInmTemplate.setInmueble(inmueble);
		inmWithPropInmTemplate.setPropietarioInmuebleVO(propietarioInmuebleVO);
		

		return inmWithPropInmTemplate;

	}

	
	// ============ MÉTODOS DE BÚSQUEDA ==================

	// ----ID-----
	public InmuebleEntity findById(UUID id) {
		return iInmRepository.findById(id);
	}

	// ---- ID PROPIETARIO INMUEBLE-----
	public Page<InmuebleEntity> findByIdPropInm(UUID id, Pageable pageable) {
		return iInmRepository.findByIdPropInm(id,pageable);
	}

	// ---- DESCRIPCION INMUEBLE-----
	public Page<InmuebleEntity> findByDescr(String descripcion, Pageable pageable) {
		return iInmRepository.findByDescr(descripcion, pageable);
	}

	// ----- TIPO DE INMUEBLE --------
	public Page<InmuebleEntity> findByTipo(String tipo, Pageable pageable) {
		return iInmRepository.findByTipo(tipo, pageable);
	}

	// ---- ESTADO INMUEBLE-----
	public Page<InmuebleEntity> findByEstadoInm(String estadoInmueble, Pageable pageable) {
		return iInmRepository.findByEstadoInm(estadoInmueble, pageable);
	}

	// ---- PRECIO INMUEBLE-----
	public Page<InmuebleEntity> findByPrecInm(double precio, Pageable pageable) {
		return iInmRepository.findByPrecInmUsd(precio, pageable);
	}

	// ---- DIRECCION INMUEBLE-----
	public Page<InmuebleEntity> findByDirec(String direccion, Pageable pageable) {
		return iInmRepository.findByDirec(direccion, pageable);
	}

	// ---- UBICACION INMUEBLE-----
	public Page<InmuebleEntity> findByUbic(String ubicacion, Pageable pageable) {
		return iInmRepository.findByUbic(ubicacion, pageable);
	}

	// ---- SITIO WEB INMUEBLE-----
	public Page<InmuebleEntity> findBySitWeb(String sitioWeb, Pageable pageable) {
		return iInmRepository.findBySitWeb(sitioWeb, pageable);
	}

}
