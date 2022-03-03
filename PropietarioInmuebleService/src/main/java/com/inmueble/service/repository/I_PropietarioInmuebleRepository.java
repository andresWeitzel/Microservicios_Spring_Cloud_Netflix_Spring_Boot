package com.inmueble.service.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.PropietarioInmueble;

@Repository
public interface I_PropietarioInmuebleRepository extends JpaRepository<PropietarioInmueble, Serializable>, PagingAndSortingRepository<PropietarioInmueble, Serializable> {


	//============================ MÉTODOS DE BÚSQUEDA ============================== 
	
	public abstract PropietarioInmueble findById(int id);
	
	public abstract List<PropietarioInmueble> findByNombre(String nombre);
	
	public abstract List<PropietarioInmueble> findByApellido(String apellido);
	
	public abstract List<PropietarioInmueble>  findByEdad(int edad);
	
	public abstract List<PropietarioInmueble>  findByFechaNacimiento(LocalDate fechaNacimiento);
	
	public abstract List<PropietarioInmueble>  findByTipoDocumento(String tipoDocumento);
	
	public abstract List<PropietarioInmueble>  findByNroDocumento(String nroDocumento);
	
	public abstract List<PropietarioInmueble>  findByDireccion(String direccion);
	
	public abstract List<PropietarioInmueble>  findByNroTelefonoPrincipal(String nroTelefonoPrincipal);
	
	public abstract List<PropietarioInmueble>  findByNroTelefonoSecundario(String nroTelefonoSecundario);

	public abstract List<PropietarioInmueble>  findByEmail(String email);

	public abstract Page<PropietarioInmueble> findAll(Pageable pageable);
	
	
	
}
