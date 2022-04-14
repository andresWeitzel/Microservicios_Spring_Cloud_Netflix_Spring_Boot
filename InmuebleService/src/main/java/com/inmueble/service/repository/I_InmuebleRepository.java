package com.inmueble.service.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.InmuebleEntity;
import com.inmueble.service.enums.EstadoInmuebleEnum;

@Repository
public interface I_InmuebleRepository extends JpaRepository<InmuebleEntity, Serializable>, PagingAndSortingRepository<InmuebleEntity, Serializable> {

	
	//============================ MÉTODOS DE BÚSQUEDA ============================== 
	
	public abstract InmuebleEntity findById(int id);
	
	public abstract List<InmuebleEntity> findByIdPropietarioInmueble(int id);

	@Query("select c from InmuebleEntity c where c.descripcion like %:descripcion%")
	public abstract List<InmuebleEntity> findByDescripcion(String descripcion);
	
	@Query("select c from InmuebleEntity c where c.tipo like %:tipo%")
	public abstract List<InmuebleEntity> findByTipo(String tipo);
	
	@Query("select c from InmuebleEntity c where c.estadoInmueble like %:estadoInmueble%")
	public abstract List<InmuebleEntity> findByEstadoInmuebleEnum(EstadoInmuebleEnum  estadoInmuebleEnum);
	
	@Query("select c from InmuebleEntity c where c.precioInmueble like %:precioInmueble%")
	public abstract List<InmuebleEntity> findByPrecioInmuebleUsd(double precioInmueble);
	
	@Query("select c from InmuebleEntity c where c.direccion like %:direccion%")
	public abstract List<InmuebleEntity> findByDireccion(String direccion);
	
	@Query("select c from InmuebleEntity c where c.ubicacion like %:ubicacion%")
	public abstract List<InmuebleEntity> findByUbicacion(String ubicacion);
	
	@Query("select c from InmuebleEntity c where c.sitioWeb like %:sitioWeb%")
	public abstract List<InmuebleEntity> findBySitioWeb(String sitioWeb);

	public abstract Page<InmuebleEntity> findAll(Pageable pageable);

	//Para el template
	//public abstract Inmueble findByIdPropietarioInmuebleVO(int idPropietarioInmueble);
	
	
	
	

}
