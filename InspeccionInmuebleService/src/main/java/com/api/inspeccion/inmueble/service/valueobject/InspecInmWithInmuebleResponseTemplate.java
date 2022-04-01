package com.api.inspeccion.inmueble.service.valueobject;

import com.api.inspeccion.inmueble.service.entity.InspeccionInmuebleEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspecInmWithInmuebleResponseTemplate {

	private InmuebleVO inmuebleVO;
	
	private InspeccionInmuebleEntity inspeccionInmuebleEntity;
	
}
