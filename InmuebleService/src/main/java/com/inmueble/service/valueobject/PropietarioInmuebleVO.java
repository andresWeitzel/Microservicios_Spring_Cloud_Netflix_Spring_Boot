package com.inmueble.service.valueobject;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioInmuebleVO {

	private UUID id;

	private String nombre;

	private String apellido;

	private int edad;

	private LocalDate fechaNac;

	private String tipoDoc;

	private String nroDoc;

	private String direc;

	private String nroTelPrinc;

	private String nroTelSec;

	private String email;

}
