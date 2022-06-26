package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Empresa;
import com.empresa.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	@Override
	public List<Empresa> listaTodos() {
		return repository.findAll();
	}

	@Override
	public Empresa insertaActualizaEmpresa(Empresa obj) {
		return repository.save(obj);
	}

	@Override
	public List<Empresa> listaEmpresaPorRuc(String ruc) {
		return repository.findByRuc(ruc);
	}

	@Override
	public List<Empresa> listaEmpresaPorNombre(String nombre) {
		return repository.findByNombre(nombre);
	}

	@Override
	public List<Empresa> listaEmpresaPorRucAndNombre(String nombre, String ruc) {
		return repository.listaRucAndNombre(nombre, ruc);
	}

}
