package com.inmueble.service.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.InmuebleEntity;
import com.inmueble.service.enums.EstadoInmuebleEnum;

@Repository
public interface I_InmuebleRepository extends JpaRepository<InmuebleEntity, Serializable>, PagingAndSortingRepository<InmuebleEntity, Serializable> {

	
	//============================ MÉTODOS DE BÚSQUEDA ============================== 
	
	public abstract InmuebleEntity findById(int id);
	
	public abstract List<InmuebleEntity> findByIdPropietarioInmueble(int id);

	
	public abstract List<InmuebleEntity> findByDescripcion(String descripcion);
	
	public abstract List<InmuebleEntity> findByTipo(String tipo);
	
	public abstract List<InmuebleEntity> findByEstadoInmuebleEnum(EstadoInmuebleEnum  estadoInmuebleEnum);
	
	public abstract List<InmuebleEntity> findByPrecioInmuebleUsd(double precioInmueble);
	
	public abstract List<InmuebleEntity> findByDireccion(String direccion);
	
	public abstract List<InmuebleEntity> findByUbicacion(String ubicacion);
	
	public abstract List<InmuebleEntity> findBySitioWeb(String sitioWeb);

	public abstract Page<InmuebleEntity> findAll(Pageable pageable);

	//Para el template
	//public abstract Inmueble findByIdPropietarioInmuebleVO(int idPropietarioInmueble);
	
	
	
	

}
