package com.inmueble.service.valueobjects;

import com.inmueble.service.entity.Inmueble;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmWithPropInmResponseTemplate {
	
	private PropietarioInmuebleVO propietarioInmuebleVO;
	
	private Inmueble inmueble;
	

}
