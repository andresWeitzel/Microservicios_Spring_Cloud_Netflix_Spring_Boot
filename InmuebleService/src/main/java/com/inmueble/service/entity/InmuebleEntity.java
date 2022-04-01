package com.inmueble.service.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.inmueble.service.enums.EstadoInmuebleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="inmuebles")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleEntity {
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="id_propietario_inmueble")
	private int idPropietarioInmueble;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="tipo")
	private String tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_inmueble")
	private EstadoInmuebleEnum  estadoInmuebleEnum;
	
	@Column(name="precio_inmueble_usd") 
	private double precioInmuebleUsd;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="ubicacion")
	private String ubicacion;
	
	@Column(name="sitio_web")
	private String sitioWeb;
	
	
	

}
