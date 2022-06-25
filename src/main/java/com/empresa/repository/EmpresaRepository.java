package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	
	
	public List<Empresa> findByDni(String dni);
	

}
