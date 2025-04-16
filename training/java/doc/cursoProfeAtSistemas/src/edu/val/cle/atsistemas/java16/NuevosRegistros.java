package edu.val.cle.atsistemas.java16;

import java.util.ArrayList;
import java.util.List;

//import edu.val.cle.atsistemas.java8.Alumno;

public class NuevosRegistros {
	
	/**
	 * Los registros son como una clase bean, pero con restricciones. Donde:
	 * 
	 * Se crean por defecto:
	 * 		- los atributos son finales ( y el propio registro tb )
	 * 		- NO PUEDO HACER SET (por ser final los atributos)
	 * 		- métodos de acceso (sólo los get)
	 * 		- toString
	 *      - equals
	 *      - hashCode
	 *      - constructor "largo"  con todos los atributos como parámetros
	 *      - los métodos dados, los puedo sobreescibir
	 * 
	 * De los records ni heredan ni se puede heredar
	 * Puedo add nuevos métodos (siempre que no modiquen el estado)
	 */
	
	
	public static void main(String[] args) {
		List<Alumno> lista_alumnos = new ArrayList<>();
		lista_alumnos.add(new Alumno("Luisa", 39, 9));
		lista_alumnos.add(new Alumno("Pepe", 22, 3));
		lista_alumnos.add(new Alumno("Pepe", 22, 3));
		lista_alumnos.add(new Alumno("Jon", 36, 6));
		lista_alumnos.add(new Alumno("Vale", 52, 1));
		lista_alumnos.add(new Alumno("Luis", 37));
		
		for (Alumno a: lista_alumnos)
		{
			System.out.println("NOMBRE " + a.nombre());
			System.out.println("EDAD " + a.edad());
			System.out.println("NOTA " + a.nota());
			System.out.println(a.toString());
		}
		boolean son_iguales = lista_alumnos.get(1).equals(lista_alumnos.get(2));
		System.out.println(son_iguales);
	}

}
