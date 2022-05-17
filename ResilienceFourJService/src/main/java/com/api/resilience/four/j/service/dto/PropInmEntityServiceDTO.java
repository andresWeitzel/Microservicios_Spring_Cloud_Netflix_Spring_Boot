package com.api.resilience.four.j.service.dto;

import java.sql.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropInmEntityServiceDTO {

	private UUID id;

	private String nombre;

	private String apellido;

	private int edad;

	private Date fechaNac;

	private String tipoDoc;

	private String nroDoc;

	private String direc;

	private String nroTelPrinc;

	private String nroTelSec;

	private String email;

}
