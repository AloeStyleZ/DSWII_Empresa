package com.empresa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alumno")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idalumno")
	private int idAlumno;
	
	@Column(name = "nombre")
	private String nombre;
	
	private String dni;
	
	private String correo;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	

}
