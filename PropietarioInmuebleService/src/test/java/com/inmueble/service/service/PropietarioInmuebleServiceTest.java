package com.inmueble.service.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inmueble.service.entity.PropietarioInmuebleEntity;


//Traemos toda la api de jUnit5
@ExtendWith(SpringExtension.class)
public class PropietarioInmuebleServiceTest {

	//Objeto entidad que recibe todos los Mocks de prueba
	@InjectMocks
	private PropietarioInmuebleService propInmService;
	
	
	/*
	//======================= BOOLEAN TEST ==========================
	
	@DisplayName("Debería devolver true cuando el objeto es Agregado a la DB, sino false en caso de ser nulo o vacio")
	@Test
	public boolean shouldReturnTrueAddPropietarioInmueble() {
		
		//Creamos un objeto de tipo PropietarioInmueble
		PropietarioInmuebleEntity propInmEnt = new PropietarioInmuebleEntity();
		
		//Seteamos sus campos
		propInmEnt.setNombre("Ramino");
		propInmEnt.setApellido("Martinez");
		propInmEnt.setEdad(29);
		propInmEnt.setFechaNacimiento(LocalDate.of(1889, 04, 17));
		propInmEnt.setTipoDocumento("DNI");
		propInmEnt.setNroDocumento("2894675555");
		propInmEnt.setDireccion("Camino de Los Llanos 112");
		propInmEnt.setNroTelefonoPrincipal("1172683111");
		propInmEnt.setNroTelefonoSecundario("");
		propInmEnt.setEmail("aliouli@gmail.com");

		
		//Agregamos el objeto a la db
		boolean estadoPropInmEnt = propInmService.addPropietarioInmueble(propInmEnt);
		
		if(estadoPropInmEnt) {
			return true;
		}else {
			return false;
		}
		
		Assertions.assertFalse(estadoPropInmEnt, () -> "ERROR addPropietarioInmueble : EL PROPIETARIO DEL INMUEBLE " + propietarioInmueble
				+ " ES NULO O VACIO!!");

	}
	
	
	@DisplayName("Debería devolver false cuando el objeto sea nulo o vacio, sino true")
	@Test
	public boolean shouldReturnFalseAddPropietarioInmuebleNullOrEmpty() {
		
		//Creamos un objeto de tipo PropietarioInmueble
		PropietarioInmuebleEntity propInmEnt = new PropietarioInmuebleEntity();

		
		//Agregamos el objeto a la db
		boolean estadoPropInmEnt = propInmService.addPropietarioInmueble(propInmEnt);
		
		if(estadoPropInmEnt) {
			return true;
		}else {
			return false;
		}

	}
	
	*/
}
