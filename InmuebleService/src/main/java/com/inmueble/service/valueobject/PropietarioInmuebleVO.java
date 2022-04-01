package com.inmueble.service.valueobject;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioInmuebleVO {

	private int id;

	private String nombre;

	private String apellido;

	private int edad;

	private LocalDate fechaNacimiento;

	private String tipoDocumento;

	private String nroDocumento;

	private String direccion;

	private String nroTelefonoPrincipal;

	private String nroTelefonoSecundario;

	private String email;

}
