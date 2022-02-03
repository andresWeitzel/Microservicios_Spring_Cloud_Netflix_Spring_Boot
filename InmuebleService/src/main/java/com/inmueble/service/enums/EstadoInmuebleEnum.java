package com.inmueble.service.enums;

import javax.persistence.Entity;

@Entity
public enum EstadoInmuebleEnum {
	VENDIDO, DISPONIBLE, NO_DISPONIBLE, FALTA_INSPECCION;

}
