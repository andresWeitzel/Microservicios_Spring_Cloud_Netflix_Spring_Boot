package com.inmueble.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inmueble.service.entity.Inmueble;

@Repository
public interface I_InmuebleRepository extends JpaRepository<Inmueble, Long>{

	public abstract Inmueble findById(int id);
	
	public abstract Inmueble findByIdPropietarioInmueble(int id);
}
