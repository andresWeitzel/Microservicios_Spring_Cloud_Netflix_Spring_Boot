package com.api.inspeccion.inmueble.service.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.api.inspeccion.inmueble.service.enums.EstadoInspeccionEnum;
import com.api.inspeccion.inmueble.service.enums.TipoInspeccionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="inspecciones_inmuebles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspeccionInmuebleEntity {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="id_inmueble")
	private int idInmueble;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_inspeccion")
	private EstadoInspeccionEnum  estadoInspeccion;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_inspeccion")
	private TipoInspeccionEnum  tipoInspeccion;
	
	@Column(name="descripcion_inspeccion")
	private String descripcionInspeccion;
	
	@Column(name="empresa")
	private String empresa;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="nro_telefono")
	private String nroTelefono;
	
	@Column(name="costo")
	private double costo;
	
	@Column(name="fecha")
	private LocalDate fecha;
	
	@Column(name="hora")
	private LocalTime hora;
	
	

}
