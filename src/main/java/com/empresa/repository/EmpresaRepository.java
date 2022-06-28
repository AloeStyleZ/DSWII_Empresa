package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{
	
	
	public List<Empresa> findByRuc(String ruc);
	public List<Empresa> findByNombre(String nombre);
	
	//Query JPQL
	@Query("select e from Empresa e where e.razonSocial like ?1 and e.ruc like ?2")
	public List<Empresa> listaRucAndRaSocial(String raSocial,String ruc);
	
	//query completo
	@Query("select e from Empresa e where (?1 is '' or e.razonSocial like ?1) and (?2 is '' or e.ruc like ?2) and (?3 is -1 or e.ubigeo.idUbigeo = ?3) and (?4 is -1 or e.pais.idPais = ?4)")
	public List<Empresa> listaRaSocialRucUbigeoPais(String raSocial, String dni, int idUbigeo, int idPais);

}
