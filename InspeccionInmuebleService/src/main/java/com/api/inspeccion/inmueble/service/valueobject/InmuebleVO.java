package com.api.inspeccion.inmueble.service.valueobject;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.api.inspeccion.inmueble.service.enums.TipoInspeccionEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleVO {

	private int id;

	private int idPropietarioInmueble;

	private String descripcion;

	private String tipo;

	//Copia del Enumerado del InmuebleService con el Enumerado de nuestro paquete
	private TipoInspeccionEnum estadoInmuebleEnum;

	private double precioInmuebleUsd;

	private String direccion;

	private String ubicacion;

	private String sitioWeb;

}
