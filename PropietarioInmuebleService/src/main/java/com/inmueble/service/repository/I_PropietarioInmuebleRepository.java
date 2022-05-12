package com.inmueble.service.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.PropietarioInmueble;

@Repository
public interface I_PropietarioInmuebleRepository extends JpaRepository<PropietarioInmueble, Serializable>, PagingAndSortingRepository<PropietarioInmueble, Serializable> {


	//============================ MÉTODOS DE BÚSQUEDA ============================== 
	
	public abstract PropietarioInmueble findById(UUID id);
	
	public abstract Page<PropietarioInmueble> findByNombre(String nombre, Pageable pageable);
	
	public abstract Page<PropietarioInmueble> findByApellido(String apellido, Pageable pageable);
	
	public abstract Page<PropietarioInmueble>  findByEdad(int edad, Pageable pageable);
	
	public abstract Page<PropietarioInmueble>  findByFechaNac(LocalDate fechaNac, Pageable pageable);
	
	public abstract Page<PropietarioInmueble>  findByTipoDoc(String tipoDoc, Pageable pageable);
	
	public abstract Page<PropietarioInmueble>  findByNroDoc(String nroDoc, Pageable pageable);
	
	public abstract Page<PropietarioInmueble>  findByDirec(String direc, Pageable pageable);
	
	public abstract Page<PropietarioInmueble>  findByNroTelPrinc(String nroTelPrinc, Pageable pageable);
	
	public abstract Page<PropietarioInmueble>  findByNroTelSec(String nroTelSec, Pageable pageable);

	public abstract Page<PropietarioInmueble>  findByEmail(String email, Pageable pageable);

	public abstract Page<PropietarioInmueble> findAll(Pageable pageable);
	
	
	
}
