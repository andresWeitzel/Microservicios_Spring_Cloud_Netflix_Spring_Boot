package com.inmueble.service.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.Inmueble;
import com.inmueble.service.enums.EstadoInmuebleEnum;

@Repository
public interface I_InmuebleRepository extends JpaRepository<Inmueble, Serializable>, PagingAndSortingRepository<Inmueble, Serializable> {

	
	//============================ MÉTODOS DE BÚSQUEDA ============================== 
	
	public abstract Inmueble findById(int id);
	
	public abstract List<Inmueble> findByIdPropietarioInmueble(int id);
	
	public abstract List<Inmueble> findByDescripcion(String descripcion);
	
	public abstract List<Inmueble> findByTipo(String tipo);
	
	public abstract List<Inmueble> findByEstadoInmuebleEnum(EstadoInmuebleEnum  estadoInmuebleEnum);
	
	public abstract List<Inmueble> findByPrecioInmuebleUsd(double precioInmueble);
	
	public abstract List<Inmueble> findByDireccion(String direccion);
	
	public abstract List<Inmueble> findByUbicacion(String ubicacion);
	
	public abstract List<Inmueble> findBySitioWeb(String sitioWeb);

	public abstract Page<Inmueble> findAll(Pageable pageable);
	
	
	
	

}
