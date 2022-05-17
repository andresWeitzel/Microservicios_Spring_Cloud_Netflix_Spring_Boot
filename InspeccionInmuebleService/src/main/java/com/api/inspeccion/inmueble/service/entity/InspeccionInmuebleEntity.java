package com.api.inspeccion.inmueble.service.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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
	
	@Id
    @Column(name = "id", updatable=false, nullable=false, columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID id;
	
	@Column(name="id_inmueble", updatable=false, nullable=false, columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID idInmueble;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado_inspeccion", nullable=false)
	private EstadoInspeccionEnum  estadoInspeccion;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_inspeccion", nullable=false)
	private TipoInspeccionEnum  tipoInspeccion;
	
	@Column(name="descripcion_inspeccion", nullable=false, length=200)
	private String descripcionInspeccion;
	
	@Column(name="empresa", nullable=false, length=100)
	private String empresa;
	
	@Column(name="direccion", nullable=false, length=100)
	private String direccion;
	
	@Column(name="nro_telefono", nullable=false, length=200)
	private String nroTelefono;
	
	@Column(name="costo", nullable=false)
	private double costo;
	
	@Column(name="fecha", nullable=false)
	private Date fecha;
	
	@Column(name="hora", nullable=false)
	private Time hora;
	
	

}
