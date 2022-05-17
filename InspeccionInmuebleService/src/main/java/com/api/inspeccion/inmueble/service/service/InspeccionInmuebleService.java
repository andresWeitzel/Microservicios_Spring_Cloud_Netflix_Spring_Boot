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
	public void addInspeccionInmueble(InspeccionInmuebleEntity inspeccionInmueble) {
		try {
			if (inspeccionInmueble == null) {
				logger.error("ERROR addInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
						+ " ES NULO!!");
			
			} else {
				iInspeccionInmuebleRepository.save(inspeccionInmueble);
			
			}

		} catch (Exception e) {
			logger.error("ERROR addInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
					+ " NO SE HA INSERTADO EN LA DB!!");
		
		}
	}

	// ----UPDATE----
	public void updateInspeccionInmueble(InspeccionInmuebleEntity inspeccionInmueble) {
		try {
			if (inspeccionInmueble == null) {
				logger.error("ERROR updateInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
						+ " ES NULO!!");
				
			} else {
				iInspeccionInmuebleRepository.save(inspeccionInmueble);
				
			}

		} catch (Exception e) {
			logger.error("ERROR updateInspeccionInmueble : LA INSPECCION DEL INMUEBLE " + inspeccionInmueble
					+ " NO SE HA ACTUALIZADO EN LA DB!!");
			
		}
	}

	// ----DELETE----
	public void deleteInspeccionInmueble(UUID id) {
		try {
			if (id == null) {
				logger.error("ERROR deleteInspeccionInmueble : EL ID DE LA INSPECCION DEL INMUEBLE ES CERO!!");
				
			} else {
				iInspeccionInmuebleRepository.delete(iInspeccionInmuebleRepository.findById(id));
				
			}

		} catch (Exception e) {
			logger.error("ERROR deleteInspeccionInmueble : LA INSPECCION DEL INMUEBLE CON EL ID " + id
					+ " NO SE HA ELIMINADO DE LA DB!!");
			
		}
	}

	// ----SELECT----
	public Page<InspeccionInmuebleEntity> getAllInspeccionInmueble(Pageable pageable) {

		return iInspeccionInmuebleRepository.findAll(pageable);
	}
	

	// ------TEMPLATE INMUEBLE WITH PROPIETARIO_INMUEBLE FIND BY ID---
	public InspecInmWithInmuebleResponseTemplate findByInspecInmWithInmueble(UUID idInmueble) {
		
		//Template microservices
		InspecInmWithInmuebleResponseTemplate inspecInmWithInmuebleTemplate = new InspecInmWithInmuebleResponseTemplate();
		
		//Buscamos el objeto inspeccion inmueble
		InspeccionInmuebleEntity inspeccionInmueble = iInspeccionInmuebleRepository.findById(idInmueble);
		
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
	public InspeccionInmuebleEntity findById(UUID id) {
		return iInspeccionInmuebleRepository.findById(id);
	}

	// ----ID INMUEBLE-----
	public InspeccionInmuebleEntity findByIdInmueble(UUID idInmueble) {
		return iInspeccionInmuebleRepository.findByIdInmueble(idInmueble);
	}

	// ---- ESTADO INSPECCION-----
	public Page<InspeccionInmuebleEntity> findByEstadoInspeccion(EstadoInspeccionEnum estadoInspeccion, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByEstadoInspeccion(estadoInspeccion, pageable);
	}

	// ---- TIPO INSPECCION-----
	public Page<InspeccionInmuebleEntity> findByTipoInspeccion(TipoInspeccionEnum tipoInspeccion, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByTipoInspeccion(tipoInspeccion, pageable);
	}

	// ---- DESCRIPCION INSPECCION-----
	public Page<InspeccionInmuebleEntity> findByDescripcionInspeccion(String descripcionInspeccion, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByDescripcionInspeccion(descripcionInspeccion, pageable);
	}

	// ---- EMPRESA-----
	public Page<InspeccionInmuebleEntity> findByEmpresa(String empresa, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByEmpresa(empresa, pageable);
	}

	// ---- DIRECCION -----
	public Page<InspeccionInmuebleEntity> findByDireccion(String direccion, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByDireccion(direccion, pageable);
	}

	// ---- NRO TELEFONO -----
	public Page<InspeccionInmuebleEntity> findByNroTelefono(String nroTelefono, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByNroTelefono(nroTelefono, pageable);
	}

	// ---- COSTO -----
	public Page<InspeccionInmuebleEntity> findByCosto(double costo, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByCosto(costo, pageable);
	}

	// ---- FECHA -----
	public Page<InspeccionInmuebleEntity> findByFecha(Date fecha, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByFecha(fecha, pageable);
	}

	// ---- HORA -----
	public Page<InspeccionInmuebleEntity> findByHora(Time hora, Pageable pageable) {
		return iInspeccionInmuebleRepository.findByHora(hora, pageable);
	}

}
