package com.api.inspeccion.inmueble.service.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmuebleEntity;
import com.api.inspeccion.inmueble.service.enums.EstadoInspeccionEnum;
import com.api.inspeccion.inmueble.service.enums.TipoInspeccionEnum;


@Repository
public interface I_InspeccionInmuebleRepository extends JpaRepository<InspeccionInmuebleEntity, Serializable>, PagingAndSortingRepository<InspeccionInmuebleEntity, Serializable>  {
	
	public abstract InspeccionInmuebleEntity findById(int id);
	
	public abstract InspeccionInmuebleEntity findByIdInmueble(int idInmueble);
	
	public abstract List<InspeccionInmuebleEntity> findByEstadoInspeccion(EstadoInspeccionEnum estadoInspeccion);
	
	public abstract List<InspeccionInmuebleEntity> findByTipoInspeccion(TipoInspeccionEnum tipoInspeccion);
	
	public abstract List<InspeccionInmuebleEntity> findByDescripcionInspeccion(String descripcionInspeccion);
	
	public abstract List<InspeccionInmuebleEntity> findByEmpresa(String empresa);
	
	public abstract List<InspeccionInmuebleEntity> findByDireccion(String direccion);
	
	public abstract List<InspeccionInmuebleEntity> findByNroTelefono(String nroTelefono);
	
	public abstract List<InspeccionInmuebleEntity> findByCosto(double costo);
	
	public abstract List<InspeccionInmuebleEntity> findByFecha(LocalDate fecha);
	
	public abstract List<InspeccionInmuebleEntity> findByHora(LocalTime hora);
	
	public abstract Page<InspeccionInmuebleEntity> findAll(Pageable pageable);

}
