package edu.val.cle.atsistemas.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autinc en MYSQL
	private Long id;
	
	private String nombre;
	private String email;
	private int edad;
	
	public Alumno() {
		
	}
	
	
	
	public Alumno(Long id, String nombre, String email, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
