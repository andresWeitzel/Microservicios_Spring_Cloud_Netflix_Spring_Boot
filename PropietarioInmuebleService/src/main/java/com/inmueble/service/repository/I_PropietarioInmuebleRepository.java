package com.inmueble.service.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.PropietarioInmuebleEntity;

@Repository
public interface I_PropietarioInmuebleRepository extends JpaRepository<PropietarioInmuebleEntity, Serializable>, PagingAndSortingRepository<PropietarioInmuebleEntity, Serializable> {


	//============================ MÉTODOS DE BÚSQUEDA ============================== 
	
	public abstract PropietarioInmuebleEntity findById(int id);
	
	public abstract List<PropietarioInmuebleEntity> findByNombre(String nombre);
	
	public abstract List<PropietarioInmuebleEntity> findByApellido(String apellido);
	
	public abstract List<PropietarioInmuebleEntity>  findByEdad(int edad);
	
	public abstract List<PropietarioInmuebleEntity>  findByFechaNacimiento(LocalDate fechaNacimiento);
	
	public abstract List<PropietarioInmuebleEntity>  findByTipoDocumento(String tipoDocumento);
	
	public abstract List<PropietarioInmuebleEntity>  findByNroDocumento(String nroDocumento);
	
	public abstract List<PropietarioInmuebleEntity>  findByDireccion(String direccion);
	
	public abstract List<PropietarioInmuebleEntity>  findByNroTelefonoPrincipal(String nroTelefonoPrincipal);
	
	public abstract List<PropietarioInmuebleEntity>  findByNroTelefonoSecundario(String nroTelefonoSecundario);

	public abstract List<PropietarioInmuebleEntity>  findByEmail(String email);

	public abstract Page<PropietarioInmuebleEntity> findAll(Pageable pageable);
	
	
	
}
