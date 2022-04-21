package com.api.resilience.four.j.service.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import com.api.resilience.four.j.service.enums.EstadoInspeccionEnum;
import com.api.resilience.four.j.service.enums.TipoInspeccionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspecInmEntityServiceDTO {

	private int id;

	private int idInmueble;

	private EstadoInspeccionEnum estadoInspeccion;

	private TipoInspeccionEnum tipoInspeccion;

	private String descripcionInspeccion;

	private String empresa;

	private String direccion;

	private String nroTelefono;

	private double costo;

	private LocalDate fecha;

	private LocalTime hora;

}
