package com.api.inspeccion.inmueble.service.valueobject;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmueble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspInmWithInmResponseTemplate {

	private InmuebleVO inmuebleVO;
	
	private InspeccionInmueble inspeccionInmuebleEntity;
	
}
