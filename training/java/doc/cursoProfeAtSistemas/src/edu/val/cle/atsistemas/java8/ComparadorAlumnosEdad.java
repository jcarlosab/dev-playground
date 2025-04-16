package edu.val.cle.atsistemas.java8;

import java.util.Comparator;

public class ComparadorAlumnosEdad implements Comparator<Alumno> {

	@Override
	public int compare(Alumno o1, Alumno o2) {
		
		return o1.getEdad()-o2.getEdad();
	}

}
