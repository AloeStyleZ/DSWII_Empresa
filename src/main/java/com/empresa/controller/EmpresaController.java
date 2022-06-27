package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empresa;
import com.empresa.service.EmpresaService;

@RestController
@RequestMapping("/rest/empresa")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaTodasEmpresas(){
		List<Empresa> lista = empresaService.listaTodos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porRuc/{ruc}")
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaTodasEmpresasPorRuc(@PathVariable(name = "ruc") String ruc){
		List<Empresa> lista = empresaService.listaEmpresaPorRuc(ruc+"%");
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porNombre/{nombre}")
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaTodasEmpresasPorNombre(@PathVariable(name = "nombre") String nombre){
		List<Empresa> lista = empresaService.listaEmpresaPorNombre(nombre+"%");
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porNombreRuc/{nombre}/{ruc}")
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaTodasEmpresasPorNombreAndRuc(@PathVariable(name = "nombre") String nombre, @PathVariable(name = "ruc") String ruc){
		List<Empresa> lista = empresaService.listaEmpresaPorRucAndNombre(ruc, nombre+"%");
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/porNombreOrRuconParametros")
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaEmpresaRucOrNombre(
			@RequestParam(name = "nombre", required = false, defaultValue = "") String nombre,
			@RequestParam(name = "nombre", required = false, defaultValue = "") String ruc){
		List<Empresa> lista = empresaService.listaEmpresaPorRucOrNombre(ruc, nombre+"%");
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaEmpresa(@RequestBody Empresa obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Empresa objSalida = empresaService.insertaActualizaEmpresa(obj);
			if(objSalida == null) {
				salida.put("mensaje", "Error al registrar Empresa");
				
			}else salida.put("mensaje", "Registro exitoso");
			
		} catch (Exception e) {
			e.printStackTrace();	
			salida.put("mensaje", "Error en el registro " + e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}
	

}
