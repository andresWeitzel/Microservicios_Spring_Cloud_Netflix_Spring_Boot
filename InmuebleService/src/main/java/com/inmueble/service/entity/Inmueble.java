package com.inmueble.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.inmueble.service.enums.EstadoInmuebleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inmueble {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int idPropietarioInmueble;
	
	private String descripcion;
	
	@Enumerated(EnumType.STRING)
	private EstadoInmuebleEnum  estadoInmuebleEnum;
	
	private double precioInmuebleUsd;
	
	private String direccion;
	
	private String ubicacion;
	
	private String sitioWeb;
	
	
	

}
