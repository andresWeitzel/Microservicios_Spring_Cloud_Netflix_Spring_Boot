package com.api.resilience.four.j.service.dto;

import java.util.UUID;

import com.api.resilience.four.j.service.enums.EstadoInmuebleEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleEntityServiceDTO {

	private UUID id;

	private UUID idPropInm;

	private String descr;

	private String tipo;

	private EstadoInmuebleEnum estadoInmEnum;

	private double precInmUsd;

	private String direc;

	private String ubic;

	private String sitWeb;

}
