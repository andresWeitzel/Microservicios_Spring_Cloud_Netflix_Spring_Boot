package com.api.resilience.four.j.service.dto;

import com.api.resilience.four.j.service.enums.EstadoInmuebleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleEntityServiceDTO {

	private int id;
	
	private int idPropietarioInmueble;

	private String descripcion;

	private String tipo;

	private EstadoInmuebleEnum estadoInmuebleEnum;

	private double precioInmuebleUsd;

	private String direccion;

	private String ubicacion;

	private String sitioWeb;

}
