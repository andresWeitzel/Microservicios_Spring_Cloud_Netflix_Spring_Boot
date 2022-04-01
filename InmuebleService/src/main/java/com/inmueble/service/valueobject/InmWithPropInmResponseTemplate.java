package com.inmueble.service.valueobject;

import com.inmueble.service.entity.InmuebleEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InmWithPropInmResponseTemplate {
	
	private PropietarioInmuebleVO propietarioInmuebleVO;
	
	private InmuebleEntity inmueble;
	

}
