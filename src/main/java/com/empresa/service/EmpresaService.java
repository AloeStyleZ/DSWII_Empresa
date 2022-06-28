package com.empresa.service;

import java.util.List;

import com.empresa.entity.Empresa;

public interface EmpresaService {

	public abstract List<Empresa> listaTodos();
	
	public abstract Empresa insertaActualizaEmpresa(Empresa obj);
	
	public abstract List<Empresa> listaEmpresaPorRuc(String ruc);
	public abstract List<Empresa> listaEmpresaPorRaSocial(String raSocial);
	public abstract List<Empresa> listaEmpresaPorRucAndRaSocial(String raSocial, String ruc);
	public abstract List<Empresa> listaEmpresaPorRaSocialRucUbigeoPais(String raSocial, String ruc, int idUbigeo, int idPais);
	
}
