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

import com.api.inspeccion.inmueble.service.entity.InspeccionInmueble;

@Repository
public interface I_InspeccionInmuebleRepository extends JpaRepository<InspeccionInmueble, Serializable>, PagingAndSortingRepository<InspeccionInmueble, Serializable>  {
	
	public abstract InspeccionInmueble findById(UUID id);
	
	public abstract InspeccionInmueble findByIdInm(UUID idInm);
	
	@Query("select c from InspeccionInmueble c where c.estadoInsp like %:estadoInsp%")
	public abstract Page<InspeccionInmueble> findByEstadoInsp(String estadoInsp, Pageable pageable);
	
	@Query("select c from InspeccionInmueble c where c.tipoInsp like %:tipoInsp%")
	public abstract Page<InspeccionInmueble> findByTipoInsp(String tipoInsp, Pageable pageable);
	
	@Query("select c from InspeccionInmueble c where c.descrInsp like %:descrInsp%")
	public abstract Page<InspeccionInmueble> findByDescrInsp(String descrInsp, Pageable pageable);
	
	@Query("select c from InspeccionInmueble c where c.empresa like %:empresa%")
	public abstract Page<InspeccionInmueble> findByEmpresa(String empresa, Pageable pageable);
	
	@Query("select c from InspeccionInmueble c where c.direc like %:direc%")
	public abstract Page<InspeccionInmueble> findByDirec(String direc, Pageable pageable);
	
	@Query("select c from InspeccionInmueble c where c.nroTel like %:nroTel%")
	public abstract Page<InspeccionInmueble> findByNroTel(String nroTel, Pageable pageable);
	
	public abstract Page<InspeccionInmueble> findByCosto(double costo, Pageable pageable);
	
	public abstract Page<InspeccionInmueble> findByFecha(Date fecha, Pageable pageable);
	
	public abstract Page<InspeccionInmueble> findByHora(Time hora, Pageable pageable);
	
	public abstract Page<InspeccionInmueble> findAll(Pageable pageable);

}
