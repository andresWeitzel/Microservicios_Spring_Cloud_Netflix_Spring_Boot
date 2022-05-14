package com.inmueble.service.converter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import com.inmueble.service.enums.EstadoInmuebleEnum;

@Component
public class EstadoInmuebleEnumConverter implements 
Converter<String, EstadoInmuebleEnum>{

	@Override
	public EstadoInmuebleEnum convert(String value) {
		 try {
	            return value.isEmpty() ? null : EstadoInmuebleEnum.valueOf(value.trim());
	        } catch(Exception e) {
	            return null; // 
	        }
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
