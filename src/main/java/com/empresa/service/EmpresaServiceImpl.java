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
	public Empresa insertaEmpresa(Empresa obj) {
		return repository.save(obj);
	}

	@Override
	public List<Empresa> listaEmpresaPorNombreLike(String razonSocial) {
		return repository.listaPorNombreLike(razonSocial);
	}
	
	
	@Override
	public List<Empresa> listaEmpresaPorRaSocialRucUbigeoPais(String razonSocial, String ruc, int idUbigeo, int idPais) {
		return repository.listaRaSocialRucUbigeoPais(razonSocial, ruc, idUbigeo, idPais);
	}
	
	@Override
	public Empresa insertaActualizaEmpresa(Empresa empresa) {
		return repository.save(empresa);
	}

}
