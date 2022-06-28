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
	public List<Empresa> listaEmpresaPorRaSocial(String raSocial) {
		return repository.findByNombre(raSocial);
	}

	@Override
	public List<Empresa> listaEmpresaPorRucAndRaSocial(String raSocial, String ruc) {
		return repository.listaRucAndRaSocial(raSocial, ruc);
	}
	
	
	@Override
	public List<Empresa> listaEmpresaPorRaSocialRucUbigeoPais(String raSocial, String ruc, int idUbigeo, int idPais) {
		return repository.listaRaSocialRucUbigeoPais(raSocial, ruc, idUbigeo, idPais);
	}

}
