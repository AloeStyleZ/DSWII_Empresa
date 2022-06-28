package com.empresa.service;

import java.util.List;

import com.empresa.entity.Empresa;

public interface EmpresaService {

	public abstract List<Empresa> listaTodos();
	
	public Empresa insertaActualizaEmpresa(Empresa obj);
	public abstract List<Empresa> listaEmpresaPorRucAndRaSocial(String razonSocial, String ruc);
	public abstract List<Empresa> listaEmpresaPorRaSocialRucUbigeoPais(String razonSocial, String ruc, int idUbigeo, int idPais);
	
}
