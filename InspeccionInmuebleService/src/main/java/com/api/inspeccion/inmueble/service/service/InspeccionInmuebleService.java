package com.api.inspeccion.inmueble.service.service;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmueble;
import com.api.inspeccion.inmueble.service.repository.I_InspeccionInmuebleRepository;
import com.api.inspeccion.inmueble.service.valueobject.InmuebleVO;
import com.api.inspeccion.inmueble.service.valueobject.InspInmWithInmResponseTemplate;

@Service
public class InspeccionInmuebleService {

	// ============ INYECT. DEP. ============

	@Autowired
	private I_InspeccionInmuebleRepository iInspInmRepository;

	@Autowired
	private RestTemplate restTemplate;

	// ============= LOGS ========================
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(InspeccionInmuebleService.class);

	// ============ MÉTODOS CRUD ==================

	// ----INSERT----
	public boolean addInspInm(InspeccionInmueble inspecInm) {
		try {
			if (inspecInm == null) {
				logger.error("ERROR addInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspecInm
						+ " ES NULO!!");
				return false;
			} else {
				iInspInmRepository.save(inspecInm);
				return true;
			
			}

		} catch (Exception e) {
			logger.error("ERROR addInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspecInm
					+ " NO SE HA INSERTADO EN LA DB!!");
			return false;
		
		}
	}

	// ----UPDATE----
	public boolean updateInspInm(InspeccionInmueble inspInm) {
		try {
			if (inspInm == null) {
				logger.error("ERROR updateInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspInm
						+ " ES NULO!!");
				return false;
				
			} else {
				iInspInmRepository.save(inspInm);
				return true;
				
			}

		} catch (Exception e) {
			logger.error("ERROR updateInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspInm
					+ " NO SE HA ACTUALIZADO EN LA DB!!");
			return false;
			
		}
	}

	// ----DELETE----
	public boolean deleteInspInm(UUID id) {
		try {
			if (id == null) {
				logger.error("ERROR deleteInspeccionInmueble : EL ID DE LA INSPECCION DEL INMUEBLE ES CERO!!");
				return false;
				
			} else {
				iInspInmRepository.delete(iInspInmRepository.findById(id));
				return true;
				
			}

		} catch (Exception e) {
			logger.error("ERROR deleteInspeccionInmueble : LA INSPECCION DEL INMUEBLE CON EL ID " + id
					+ " NO SE HA ELIMINADO DE LA DB!!");
			return false;
			
		}
	}

	// ----SELECT----
	public Page<InspeccionInmueble> getAllInspInm(Pageable pageable) {

		return iInspInmRepository.findAll(pageable);
	}
	

	// ------TEMPLATE INMUEBLE WITH PROPIETARIO_INMUEBLE FIND BY ID---
	public InspInmWithInmResponseTemplate findByInspInmWithInm(UUID idInmueble) {
		
		//Template microservices
		InspInmWithInmResponseTemplate inspInmWithInmTemplate = new InspInmWithInmResponseTemplate();
		
		//Buscamos el objeto inspeccion inmueble
		InspeccionInmueble inspInm = iInspInmRepository.findById(idInmueble);
		
		//Buscamos el objeto inmueble
		InmuebleVO inmVO = 
				restTemplate.getForObject("http://INMUEBLE-SERVICE/v1/inmuebles/id/" 
						+ inspInm.getIdInm() , InmuebleVO.class); 
		
		
		//Guardamos ambos objetos en el Template
		inspInmWithInmTemplate.setInspeccionInmuebleEntity(inspInm);
		inspInmWithInmTemplate.setInmuebleVO(inmVO);
		
		return inspInmWithInmTemplate;
		
		
	}
	

	// ============ MÉTODOS DE BÚSQUEDA ==================

	// ----ID-----
	public InspeccionInmueble findById(UUID id) {
		return iInspInmRepository.findById(id);
	}

	// ----ID INMUEBLE-----
	public Page<InspeccionInmueble> findByIdInm (UUID idInm, Pageable pageable) {
		return iInspInmRepository.findByIdInm(idInm, pageable);
	}

	// ---- ESTADO INSPECCION-----
	public Page<InspeccionInmueble> findByEstadoInsp(String estadoInsp, Pageable pageable) {
		return iInspInmRepository.findByEstadoInsp(estadoInsp, pageable);
	}

	// ---- TIPO INSPECCION-----
	public Page<InspeccionInmueble> findByTipoInsp(String tipoInsp, Pageable pageable) {
		return iInspInmRepository.findByTipoInsp(tipoInsp, pageable);
	}

	// ---- DESCRIPCION INSPECCION-----
	public Page<InspeccionInmueble> findByDescrInsp(String descrInsp, Pageable pageable) {
		return iInspInmRepository.findByDescrInsp(descrInsp, pageable);
	}

	// ---- EMPRESA-----
	public Page<InspeccionInmueble> findByEmpresa(String empresa, Pageable pageable) {
		return iInspInmRepository.findByEmpresa(empresa, pageable);
	}

	// ---- DIRECCION -----
	public Page<InspeccionInmueble> findByDirec(String direc, Pageable pageable) {
		return iInspInmRepository.findByDirec(direc, pageable);
	}

	// ---- NRO TELEFONO -----
	public Page<InspeccionInmueble> findByNroTel(String nroTel, Pageable pageable) {
		return iInspInmRepository.findByNroTel(nroTel, pageable);
	}

	// ---- COSTO -----
	public Page<InspeccionInmueble> findByCosto(double costo, Pageable pageable) {
		return iInspInmRepository.findByCosto(costo, pageable);
	}

	// ---- FECHA -----
	public Page<InspeccionInmueble> findByFecha(Date fecha, Pageable pageable) {
		return iInspInmRepository.findByFecha(fecha, pageable);
	}

	// ---- HORA -----
	public Page<InspeccionInmueble> findByHora(Time hora, Pageable pageable) {
		return iInspInmRepository.findByHora(hora, pageable);
	}

}
