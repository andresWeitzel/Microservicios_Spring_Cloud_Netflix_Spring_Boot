package com.inmueble.service.entity;

import java.time.LocalDate;

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
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(name="nro_documento")
	private String nroDocumento;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="nro_telefono_principal")
	private String nroTelefonoPrincipal;
	
	@Column(name="nro_telefono_secundario")
	private String nroTelefonoSecundario;
	
	@Column(name="email")
	private String email;
	
	
	
}
