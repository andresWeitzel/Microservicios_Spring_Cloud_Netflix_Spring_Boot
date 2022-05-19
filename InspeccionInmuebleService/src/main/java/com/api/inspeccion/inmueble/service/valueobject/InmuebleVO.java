package com.api.inspeccion.inmueble.service.valueobject;


import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleVO {

	private UUID id;

	private UUID idPropInm;

	private String descr;

	private String tipo;

	private String estadoInm;

	private double precioInmUsd;

	private String direc;

	private String ubic;

	private String sitWeb;

}
