package com.empresa.service;

import java.util.List;

import com.empresa.entity.Empresa;

public interface EmpresaService {

	public abstract List<Empresa> listaTodos();
	
	public Empresa insertaEmpresa(Empresa obj);
	public abstract Empresa insertaActualizaEmpresa(Empresa empresa);
	
	public abstract List<Empresa> listaEmpresaPorNombreLike(String razonSocial);
	public abstract List<Empresa> listaEmpresaPorRaSocialRucUbigeoPais(String razonSocial, String ruc, int idUbigeo, int idPais);
	
}
