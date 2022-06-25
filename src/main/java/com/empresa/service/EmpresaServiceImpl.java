package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Empresa;
import com.empresa.repository.AlumnoRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private AlumnoRepository repository;
	
	@Override
	public List<Empresa> listaTodos() {
		return repository.findAll();
	}

}
