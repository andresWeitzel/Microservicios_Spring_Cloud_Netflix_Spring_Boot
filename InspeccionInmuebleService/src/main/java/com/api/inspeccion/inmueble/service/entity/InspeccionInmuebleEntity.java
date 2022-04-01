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
	int id;
	
	@Column(name="id_inmueble")
	int id_inmueble;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_inspeccion")
	private EstadoInspeccionEnum  estadoInspeccionEnum;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_inspeccion")
	private TipoInspeccionEnum  tipoInspeccionEnum;
	
	@Column(name="descripcion_inspeccion")
	String descripcion_inspeccion;
	
	@Column(name="empresa")
	String empresa;
	
	@Column(name="direccion")
	String direccion;
	
	@Column(name="costo")
	double costo;
	
	@Column(name="fecha")
	LocalDate fecha;
	
	@Column(name="hora")
	LocalTime hora;
	
	

}
