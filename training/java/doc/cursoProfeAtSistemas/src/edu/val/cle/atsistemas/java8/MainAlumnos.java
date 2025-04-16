package edu.val.cle.atsistemas.java8;

import java.util.ArrayList;
import java.util.List;

public class MainAlumnos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Alumno> lista_alumnos = new ArrayList<>();
		lista_alumnos.add(new Alumno("Luisa", 39, 9));
		lista_alumnos.add(new Alumno("Pepe", 22, 3));
		lista_alumnos.add(new Alumno("Jon", 36, 6));
		lista_alumnos.add(new Alumno("Vale", 52, 1));
		
		//imprimirAlumnos(lista_alumnos, new AlumnoExcelente());
		
		//boolean test (Alumno a);
		//Ahora los alumnos son execelentes si tienen más de un 5
		
		imprimirAlumnos(lista_alumnos, a -> a.getNota_media()>=5);
		imprimirAlumnos(lista_alumnos, (var a) -> a.getNota_media()>=5);
		imprimirAlumnos(lista_alumnos, (Alumno a) -> {
			//si el cuerpo de la expresion lambada tiene más de una instrucción
			//uso llaves para delimitar su alcance
			//en ese caso, si la funcion devuevel algo debo usar return
			 
			 return a.getNota_media()>=5;
			}
		);
		
		lista_alumnos.sort(new ComparadorAlumnosEdad());
		System.out.println("Lista ORDENADA POR EDAD ASC= " + lista_alumnos);
		
		/*int compare(T o1, T o2)*/
		
		lista_alumnos.sort((a1, a2) -> a2.getEdad()-a1.getEdad());
		System.out.println("Lista ORDENADA POR EDAD DESC = " + lista_alumnos);
	}
	/**
	 * este método imprimer los alumnos de lAlumnos que cumplen con compruebaALumno
	 * @param lAlumnos
	 * @param compruebaAlumno
	 */
	private static void imprimirAlumnos (List<Alumno> lAlumnos, CompruebaAlumno compruebaAlumno)
	{
		for (Alumno a:lAlumnos)
		{
			if (compruebaAlumno.test(a))
			{
				System.out.println("ALUMNOS SUPERA CRIBA " + a);
			}
		}
	}
	

}
