package com.api.inspeccion.inmueble.service.valueobject;


import java.util.UUID;

import com.api.inspeccion.inmueble.service.enums.EstadoInmuebleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleVO {

	private UUID id;

	private UUID idPropietarioInmueble;

	private String descripcion;

	private String tipo;

	//Copia del Enumerado del InmuebleService con el Enumerado de nuestro paquete
	private EstadoInmuebleEnum estadoInmuebleEnum;

	private double precioInmuebleUsd;

	private String direccion;

	private String ubicacion;

	private String sitioWeb;

}
