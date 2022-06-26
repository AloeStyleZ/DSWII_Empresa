package com.empresa.service;

import java.util.List;

import com.empresa.entity.Empresa;

public interface EmpresaService {

	public abstract List<Empresa> listaTodos();
	
	public abstract Empresa insertaActualizaEmpresa(Empresa obj);
	
	public abstract List<Empresa> listaEmpresaPorRuc(String ruc);
	public abstract List<Empresa> listaEmpresaPorNombre(String nombre);
	public abstract List<Empresa> listaEmpresaPorRucAndNombre(String nombre, String ruc);
	
}
