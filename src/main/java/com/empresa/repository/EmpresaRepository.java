package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	
	
	public List<Empresa> findByRuc(String ruc);
	public List<Empresa> findByNombre(String nombre);
	
	//Query JPQL
	@Query("select e from Empresa e where e.nombre like ?1 and e.dni like ?2")
	public List<Empresa> listaRucAndNombre(String nombre,String ruc);

}
