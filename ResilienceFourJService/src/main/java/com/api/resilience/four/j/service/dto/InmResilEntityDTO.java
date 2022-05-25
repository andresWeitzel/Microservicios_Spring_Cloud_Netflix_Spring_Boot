package com.api.resilience.four.j.service.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmResilEntityDTO {

	private UUID idPropInm;

	private String descr;

	private String tipo;

	private String estadoInm;

	private double precInmUsd;

	private String direc;

	private String ubic;

	private String sitWeb;

}
