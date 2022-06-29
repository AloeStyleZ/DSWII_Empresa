package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Empresa;

public interface EmpresaService {

	public abstract List<Empresa> listaTodos();
	
	//public Empresa insertaEmpresa(Empresa obj);
	
	
	
	//crud
	public abstract List<Empresa> listaEmpresaPorNombreLike(String razonSocial);
	public abstract Empresa insertaActualizaEmpresa(Empresa empresa);
	public abstract void eliminaEmpresa(int id);
	//consulta
	public abstract List<Empresa> listaEmpresaPorRaSocialRucUbigeoPais(String razonSocial, String ruc, int idUbigeo, int idPais);
	public abstract Optional<Empresa> buscaEmpresa(int id);
}
