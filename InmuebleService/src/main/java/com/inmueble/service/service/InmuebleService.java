package com.inmueble.service.service;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inmueble.service.entity.InmuebleEntity;
import com.inmueble.service.enums.EstadoInmuebleEnum;
import com.inmueble.service.repository.I_InmuebleRepository;
import com.inmueble.service.valueobject.InmWithPropInmResponseTemplate;
import com.inmueble.service.valueobject.PropietarioInmuebleVO;

@Service
public class InmuebleService {
	
	
	//============ Inyec Dep. ============
	@Autowired
	private I_InmuebleRepository iInmuebleRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	// ============= LOGS ========================	
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(InmuebleService.class);

	
	// ============ MÉTODOS CRUD ==================
	
	// ----INSERT----
	public boolean addInmueble(InmuebleEntity inmueble) {
		try {
			if(inmueble == null) {
				logger.error("ERROR addInmueble : EL INMUEBLE " + inmueble+" ES NULO!!");
				return false;
			}else {
				iInmuebleRepository.save(inmueble);
				return true;
			}
			
			
		} catch (Exception e) {
			logger.error("ERROR addInmueble : EL INMUEBLE " + inmueble+ " NO SE HA INSERTADO EN LA DB!!");
			return false;
		}
	}
	
	
	// ----UPDATE----
	public boolean updateInmueble(InmuebleEntity inmueble) {
		try {
			if(inmueble == null) {
				logger.error("ERROR updateInmueble : EL INMUEBLE " + inmueble + " ES NULO!!");
				return false;
			}else {
				iInmuebleRepository.save(inmueble);
				return true;
			}
			
		} catch (Exception e) {
			logger.error("ERROR updateInmueble : EL INMUEBLE " + inmueble + " NO SE HA ACTUALIZADO EN LA DB!!");
			return false;
		}
	}
	
	// ----DELETE----
	public boolean deleteInmueble(int id) {
		try {
			if(id == 0) {
				logger.error("ERROR deleteInmueble : EL INMUEBLE ES CERO!!");
				return false;
			}else {
				iInmuebleRepository.delete(iInmuebleRepository.findById(id));
				return true;
			}
			
		} catch (Exception e) {
			logger.error("ERROR deleteInmueble : EL ID DEL INMUEBLE " + id + " NO SE HA ELIMINADO DE LA DB!!");
			return false;
		}
	}
	
	// ----SELECT----
	public List<InmuebleEntity> getAllInmueble(Pageable pageable){
		
		return iInmuebleRepository.findAll(pageable).getContent();
	}
	

	
	// ------TEMPLATE INMUEBLE WITH PROPIETARIO_INMUEBLE FIND BY ID---
	public InmWithPropInmResponseTemplate findByInmWithPropInm(int idInmueble) {
		
		//Template microservices
		InmWithPropInmResponseTemplate inmWithPropInmTemplate = new InmWithPropInmResponseTemplate();
		
		//buscamos el objeto inmueble
		InmuebleEntity inmueble = iInmuebleRepository.findById(idInmueble);
		
		//buscamos el objeto Prop Inm
		PropietarioInmuebleVO propietarioInmuebleVO = 
				restTemplate.getForObject("http://PROPIETARIO-INMUEBLE-SERVICE/propietarios-inmuebles/id/" 
						+ inmueble.getIdPropietarioInmueble() , PropietarioInmuebleVO.class); 
		
		
		//Guardamos ambos objetos en el Template
		inmWithPropInmTemplate.setInmueble(inmueble);
		inmWithPropInmTemplate.setPropietarioInmuebleVO(propietarioInmuebleVO);;
		
		return inmWithPropInmTemplate;
		
		
	}
	

	
	// ============ MÉTODOS DE BÚSQUEDA ==================
	
	//----ID-----
	public InmuebleEntity findById(int id) {
		return iInmuebleRepository.findById(id);
	}
	

	//---- ID PROPIETARIO INMUEBLE-----
	public List<InmuebleEntity> findByIdPropietarioInmueble(int id) {
		return iInmuebleRepository.findByIdPropietarioInmueble(id);
	}
	
	
	//---- DESCRIPCION INMUEBLE-----
	public List<InmuebleEntity> findByDescripcion(String descripcion) {
		return iInmuebleRepository.findByDescripcion(descripcion);
	}
	
	//----- TIPO DE INMUEBLE --------
	public List<InmuebleEntity> findByTipo(String tipo) {
		return iInmuebleRepository.findByTipo(tipo);
	}
	
	
	//---- ESTADO INMUEBLE-----
	public List<InmuebleEntity> findByEstadoInmuebleEnum(EstadoInmuebleEnum estadoInmueble) {
		return iInmuebleRepository.findByEstadoInmuebleEnum(estadoInmueble);
	}
	
	
	
	//---- PRECIO INMUEBLE-----
	public List<InmuebleEntity> findByPrecioInmueble(double precio) {
		return iInmuebleRepository.findByPrecioInmuebleUsd(precio);
	}
	
	//---- DIRECCION INMUEBLE-----
	public List<InmuebleEntity> findByDireccion(String direccion) {
		return iInmuebleRepository.findByDireccion(direccion);
	}
	
	//---- UBICACION INMUEBLE-----
	public List<InmuebleEntity> findByUbicacion(String ubicacion) {
		return iInmuebleRepository.findByUbicacion(ubicacion);
	}
	
	//---- SITIO WEB INMUEBLE-----
	public List<InmuebleEntity> findBySitioWeb(String sitioWeb) {
		return iInmuebleRepository.findBySitioWeb(sitioWeb);
	}
		
		
	
	
	
}
