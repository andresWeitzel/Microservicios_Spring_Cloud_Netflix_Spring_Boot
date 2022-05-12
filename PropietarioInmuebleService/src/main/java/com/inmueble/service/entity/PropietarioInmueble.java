package com.inmueble.service.entity;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="propietarios_inmuebles")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioInmueble {
	

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="id")
	private UUID id;
	
	@Column(name="nombre", nullable=false, length=100)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=100)
	private String apellido;
	
	@Column(name="edad", nullable=false)
	private int edad;
	
	@Column(name="fecha_nacimiento", nullable=false)
	private LocalDate fechaNac;
	
	@Column(name="tipo_documento", nullable=false, length=30)
	private String tipoDoc;
	
	@Column(name="nro_documento", nullable=false, length=50 , unique=true)
	private String nroDoc;
	
	@Column(name="direccion", nullable=false, length=100 )
	private String direc;
	
	@Column(name="nro_telefono_principal", nullable=false, length=40 , unique=true)
	private String nroTelPrinc;
	
	@Column(name="nro_telefono_secundario", length=50 )
	private String nroTelSec;
	
	@Column(name="email", length=50 , unique=true)
	private String email;
	
	
	
}
