package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Alumno;
import com.empresa.service.AlumnoService;

@RestController
@RequestMapping("/rest/alumnno")
public class AlumnoController {
	
	@Autowired
	private AlumnoService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaTodosAlumnos(){
		return ResponseEntity.ok(service.listaTodos());
	}
	
	@GetMapping("/{dni}")
	@ResponseBody
	public ResponseEntity<List<Alumno>> listaPorDni(@PathVariable String dni){
		return ResponseEntity.ok(service.listaPorDni(dni));
	}
	
	
}
