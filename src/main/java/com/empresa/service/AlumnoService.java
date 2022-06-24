package com.empresa.service;

import java.util.List;

import com.empresa.entity.Alumno;

public interface AlumnoService {

	public abstract List<Alumno> listaTodos();
	public abstract List<Alumno> listaPorDni(String dni);
	
}
