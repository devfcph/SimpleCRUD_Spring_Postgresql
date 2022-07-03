package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private String apellido;
	private String correo;
	
	
	
	/*Constructor*/
	public Persona(Long id, String nombre, String apellido, String correo) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
	}
	
	

	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
	
}
