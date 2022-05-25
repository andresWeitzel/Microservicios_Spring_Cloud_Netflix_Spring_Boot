package com.api.resilience.four.j.service.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspecInmResilEntityDTO {

	private UUID id;

	private UUID idInm;

	private String estadoInsp;

	private String tipoInsp;

	private String descrInsp;

	private String empresa;

	private String direc;

	private String nroTel;

	private double costo;

	private Date fecha;

	private Time hora;

}
