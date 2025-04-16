package edu.val.cle.atsistemas.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "ALUMNO")
public class Alumno {
	
	@Id
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	
	private int edad;
	
	
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



	public Alumno(Long id, String nombre, String apellido, String email, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.edad = edad;
	}
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", edad="
				+ edad + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		
			if (this == obj)
			{
				iguales = true;
			} else if (obj instanceof Alumno) //if (obj instanceof Alumno a)//https://docs.oracle.com/en/java/javase/14/language/pattern-matching-instanceof-operator.html
			{
				Alumno a = (Alumno)obj;
				Objects.equals(this.id, a.id);
				iguales = ((this.id != null)&&(this.id.equals(a.id)));//Objects.equals(this.id, a.id);
			}
		
		return iguales;
	}


}