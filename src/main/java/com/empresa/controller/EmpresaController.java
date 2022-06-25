package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empresa;
import com.empresa.service.EmpresaService;

@RestController
@RequestMapping("/rest/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaTodosAlumnos(){
		return ResponseEntity.ok(service.listaTodos());
	}
	

}
