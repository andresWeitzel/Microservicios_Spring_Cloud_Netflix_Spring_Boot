package com.inmueble.service.entity;

import java.util.UUID;

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
	private UUID id;
	
	@Column(name="id_propietario_inmueble", nullable=false)
	private UUID idPropInm;
	
	@Column(name="descripcion", nullable=false, length=200)
	private String descr;
	
	@Column(name="tipo", nullable=false, length=20)
	private String tipo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_inmueble", nullable=false)
	private EstadoInmuebleEnum  estadoInmEnum;
	
	@Column(name="precio_inmueble_usd", nullable=false) 
	private double precInmUsd;
	
	@Column(name="direccion", nullable=false, length=100)
	private String direc;
	
	@Column(name="ubicacion", nullable=false, length=100)
	private String ubic;
	
	@Column(name="sitio_web", nullable=true, length=100)
	private String sitWeb;
	
	
	

}
