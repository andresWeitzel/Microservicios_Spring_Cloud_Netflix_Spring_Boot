package com.inmueble.service.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.InmuebleEntity;

@Repository
public interface I_InmuebleRepository
		extends JpaRepository<InmuebleEntity, Serializable>, PagingAndSortingRepository<InmuebleEntity, Serializable> {

	// ============================ MÉTODOS DE BÚSQUEDA
	// ==============================

	public abstract InmuebleEntity findById(UUID id);

	public abstract Page<InmuebleEntity> findByIdPropInm(UUID id, Pageable pageable);

	@Query("select c from InmuebleEntity c where c.descr like %:descr%")
	public abstract Page<InmuebleEntity> findByDescr(String descr, Pageable pageable);

	@Query("select c from InmuebleEntity c where c.tipo like %:tipo%")
	public abstract Page<InmuebleEntity> findByTipo(String tipo, Pageable pageable);
	
	@Query("select c from InmuebleEntity c where c.estadoInm like %:estadoInm%")
	public abstract Page<InmuebleEntity> findByEstadoInm(String estadoInm, Pageable pageable);

	public abstract Page<InmuebleEntity> findByPrecInmUsd(double precioInm, Pageable pageable);

	@Query("select c from InmuebleEntity c where c.direc like %:direc%")
	public abstract Page<InmuebleEntity> findByDirec(String direc, Pageable pageable);

	@Query("select c from InmuebleEntity c where c.ubic like %:ubic%")
	public abstract Page<InmuebleEntity> findByUbic(String ubic, Pageable pageable);

	@Query("select c from InmuebleEntity c where c.sitWeb like %:sitWeb%")
	public abstract Page<InmuebleEntity> findBySitWeb(String sitWeb, Pageable pageable);

	public abstract Page<InmuebleEntity> findAll(Pageable pageable);

}
