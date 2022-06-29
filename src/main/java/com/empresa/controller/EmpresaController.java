package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Empresa;
import com.empresa.service.EmpresaService;
import com.empresa.util.AppSettings;

@RestController
@RequestMapping("/rest/empresa")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaTodasEmpresas(){
		List<Empresa> lista = empresaService.listaTodos();
		return ResponseEntity.ok(lista);
	}
	
	
	
	/*@GetMapping("/porNombreLike/{razonSocial}")
	@ResponseBody
	public ResponseEntity<List<Empresa>> listaTodasEmpresasPorRaSocialAndRuc(@PathVariable(name = "razonSocial") String razonSocial){
		List<Empresa> lista = empresaService.listaEmpresaPorNombreLike(razonSocial+"%");
		return ResponseEntity.ok(lista);
	}*/

	
	@GetMapping("/porRucRaSocialUbigeoPaisConParametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPorRucRaSocialUbigeoConParametros(
			@RequestParam(name = "razonSocial", required = false, defaultValue = "") String razonSocial,
			@RequestParam(name = "ruc", required = false, defaultValue = "") String ruc,
			@RequestParam(name = "idUbigeo", required = false, defaultValue = "-1") int idUbigeo,
			@RequestParam(name = "idPais", required = false, defaultValue = "-1") int idPais)
	{		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Empresa> lista = empresaService.listaEmpresaPorRaSocialRucUbigeoPais("%"+razonSocial+"%",ruc,idUbigeo,idPais);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje","No existe elementos para la consulta");
				
			} else {
				salida.put("lista",lista);
				salida.put("mensaje","Se tiene "+ lista.size() + " elementos");
			}
		} catch (Exception e) {
			salida.put("mensaje","Error : " + e.getMessage());
		}
		
		
		return ResponseEntity.ok(salida);
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
