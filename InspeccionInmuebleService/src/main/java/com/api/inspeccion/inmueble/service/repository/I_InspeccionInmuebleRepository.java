package com.api.inspeccion.inmueble.service.repository;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmuebleEntity;
import com.api.inspeccion.inmueble.service.enums.EstadoInspeccionEnum;
import com.api.inspeccion.inmueble.service.enums.TipoInspeccionEnum;


@Repository
public interface I_InspeccionInmuebleRepository extends JpaRepository<InspeccionInmuebleEntity, Serializable>, PagingAndSortingRepository<InspeccionInmuebleEntity, Serializable>  {
	
	public abstract InspeccionInmuebleEntity findById(UUID id);
	
	public abstract InspeccionInmuebleEntity findByIdInmueble(UUID idInmueble);
	
	public abstract Page<InspeccionInmuebleEntity> findByEstadoInspeccion(EstadoInspeccionEnum estadoInspeccion, Pageable pageable);
	
	public abstract Page<InspeccionInmuebleEntity> findByTipoInspeccion(TipoInspeccionEnum tipoInspeccion, Pageable pageable);
	
	@Query("select c from InspeccionInmuebleEntity c where c.descripcionInspeccion like %:descripcionInspeccion%")
	public abstract Page<InspeccionInmuebleEntity> findByDescripcionInspeccion(String descripcionInspeccion, Pageable pageable);
	
	@Query("select c from InspeccionInmuebleEntity c where c.empresa like %:empresa%")
	public abstract Page<InspeccionInmuebleEntity> findByEmpresa(String empresa, Pageable pageable);
	
	@Query("select c from InspeccionInmuebleEntity c where c.direccion like %:direccion%")
	public abstract Page<InspeccionInmuebleEntity> findByDireccion(String direccion, Pageable pageable);
	
	@Query("select c from InspeccionInmuebleEntity c where c.nroTelefono like %:nroTelefono%")
	public abstract Page<InspeccionInmuebleEntity> findByNroTelefono(String nroTelefono, Pageable pageable);
	
	public abstract Page<InspeccionInmuebleEntity> findByCosto(double costo, Pageable pageable);
	
	public abstract Page<InspeccionInmuebleEntity> findByFecha(Date fecha, Pageable pageable);
	
	public abstract Page<InspeccionInmuebleEntity> findByHora(Time hora, Pageable pageable);
	
	public abstract Page<InspeccionInmuebleEntity> findAll(Pageable pageable);

}
