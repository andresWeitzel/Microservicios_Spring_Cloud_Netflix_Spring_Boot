package com.inmueble.service.repository;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.PropietarioInmueble;

@Repository
public interface I_PropietarioInmuebleRepository extends JpaRepository<PropietarioInmueble, Serializable>,
		PagingAndSortingRepository<PropietarioInmueble, Serializable> {

	// ============================ MÉTODOS DE BÚSQUEDA
	// ==============================

	public abstract PropietarioInmueble findById(UUID id);

	@Query("select c from PropietarioInmueble c where c.nombre like %:nombre%")
	public abstract Page<PropietarioInmueble> findByNombre(String nombre, Pageable pageable);

	@Query("select c from PropietarioInmueble c where c.apellido like %:apellido%")
	public abstract Page<PropietarioInmueble> findByApellido(String apellido, Pageable pageable);

	public abstract Page<PropietarioInmueble> findByEdad(int edad, Pageable pageable);

	public abstract Page<PropietarioInmueble> findByFechaNac(Date fechaNac, Pageable pageable);

	@Query("select c from PropietarioInmueble c where c.tipoDoc like %:tipoDoc%")
	public abstract Page<PropietarioInmueble> findByTipoDoc(String tipoDoc, Pageable pageable);

	@Query("select c from PropietarioInmueble c where c.nroDoc like %:nroDoc%")
	public abstract Page<PropietarioInmueble> findByNroDoc(String nroDoc, Pageable pageable);

	@Query("select c from PropietarioInmueble c where c.direc like %:direc%")
	public abstract Page<PropietarioInmueble> findByDirec(String direc, Pageable pageable);

	@Query("select c from PropietarioInmueble c where c.nroTelPrinc like %:nroTelPrinc%")
	public abstract Page<PropietarioInmueble> findByNroTelPrinc(String nroTelPrinc, Pageable pageable);

	@Query("select c from PropietarioInmueble c where c.nroTelSec like %:nroTelSec%")
	public abstract Page<PropietarioInmueble> findByNroTelSec(String nroTelSec, Pageable pageable);

	@Query("select c from PropietarioInmueble c where c.email like %:email%")
	public abstract Page<PropietarioInmueble> findByEmail(String email, Pageable pageable);

	public abstract Page<PropietarioInmueble> findAll(Pageable pageable);

}
