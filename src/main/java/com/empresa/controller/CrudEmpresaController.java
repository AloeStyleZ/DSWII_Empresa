package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empresa;
import com.empresa.service.EmpresaService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/rest/crudEmpresa")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CrudEmpresaController {

	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/listaEmpresaPorNombreLike/{filtro}")
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaEmpresaPorNombreLike(@PathVariable("filtro") String filtro) {
		List<Empresa> lista  = null;
		try {
			if (filtro.equals("todos")) {
				lista = empresaService.listaEmpresaPorNombreLike("%");
			}else {
				//con comodin
				lista = empresaService.listaEmpresaPorNombreLike("%" + filtro + "%");	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registraEmpresa")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaEmpresa(@RequestBody Empresa obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setIdEmpresa(0);
			Empresa objSalida =  empresaService.insertaActualizaEmpresa(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			} else {
				salida.put("mensaje", "Se registró correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizaEmpresa")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEmpresa(@RequestBody Empresa obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Empresa objSalida =  empresaService.insertaActualizaEmpresa(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			} else {
				salida.put("mensaje", "Se actualizó correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	@DeleteMapping("/eliminaProveedor/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProveedor(@PathVariable("id")int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Optional<Empresa> opt = empresaService.buscaEmpresa(id);
			if (opt.isPresent()) {
				empresaService.eliminaEmpresa(id);
				Optional<Empresa> optProveedor = empresaService.buscaEmpresa(id);
				if (optProveedor.isEmpty()) {
					salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
				} else {
					salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
				}
			}else {
				salida.put("mensaje", AppSettings.MENSAJE_ELI_NO_EXISTE_ID);
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	
}
