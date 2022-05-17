package com.api.resilience.four.j.service.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import com.api.resilience.four.j.service.enums.EstadoInspeccionEnum;
import com.api.resilience.four.j.service.enums.TipoInspeccionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspecInmEntityServiceDTO {

	private UUID id;

	private UUID idInmueble;

	private EstadoInspeccionEnum estadoInspeccion;

	private TipoInspeccionEnum tipoInspeccion;

	private String descripcionInspeccion;

	private String empresa;

	private String direccion;

	private String nroTelefono;

	private double costo;

	private Date fecha;

	private Time hora;

}
