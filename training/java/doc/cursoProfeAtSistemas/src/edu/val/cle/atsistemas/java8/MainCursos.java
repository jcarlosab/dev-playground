package edu.val.cle.atsistemas.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainCursos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Curso> listaCursos = new ArrayList<>();
		listaCursos.add(new Curso("JAVA 18", 1.5f, 22, 3));
		listaCursos.add(new Curso("ANGULAR", 35.5f, 65, 83));
		listaCursos.add(new Curso("SPRING", 120.5f, 36, 23));
		listaCursos.add(new Curso("KAFKA", 250.5f, 18, 33));
		listaCursos.add(new Curso("MAGNOLIA", 4.5f, 15, 54));
		
		
		//1obtener la cantidad de cursos con duración mayor a 5 horas
		System.out.println("La cantidad de cursos mayor a 5 horas es " +listaCursos.stream().filter(c-> c.getDuracion()>5).count());
		//2obtener la cantidad de cursos con duración MENOR A 2 HORAS
		System.out.println("La cantidad de cursos menor a 2 horas es " + 
				listaCursos.stream()
							.filter(curso -> curso.getDuracion() < 2)
		 					//.peek(curso -> System.out.println("" + curso.getTitulo()))
		 					.count());
	  //Listar el título de aquellos cursos con más de 50 videos
		System.out.println("Cursos con más de 50 videos");
	  listaCursos.stream().filter(t -> (t.getVideos()>50)).forEach(c -> System.out.println(c.getTitulo()));
	  System.out.println("Cursos con más de 50 videos version 2 Sergio");
	//Listar el título de aquellos cursos con más de 50 videos
		listaCursos.stream()
                .filter(curso -> curso.getVideos() > 50)
                .map(curso -> curso.getTitulo())//.map(Curso::getTitulo)
                .forEach(titulo-> System.out.println(titulo));
		//4 Mostrar el titulo de los 3 cursos con mayor duración
		
		System.out.println("Mostrar el titulo de los 3 cursos con mayor duración");
		listaCursos.stream()
		.sorted((c1, c2)-> (int)(c2.getDuracion()-c1.getDuracion()))//Comparator.comparing(Curso::getDuracion).reversed()
		.limit(3)
	    .forEach(curso->System.out.println(curso.getTitulo()));
		
		//
		//5 Mostrar todos aquellos cursos cuya duración supere el promedio de duración en horas del conjunto
		System.out.println("Mostrar todos aquellos cursos cuya duración supere el promedio de duración en horas del conjunto ");
		double average = listaCursos.stream().mapToDouble(Curso::getDuracion).average().orElse(0.0);
		listaCursos.stream().filter(curso -> curso.getDuracion() > average).collect(Collectors.toList())
				.forEach(System.out::println);
		
		
		//5 Mostrar todos aquellos cursos cuya duración supere el promedio de duración en horas del conjunto ALT2
		//listaCursos.stream().sorted((c1, c2)-> (int)(c2.getDuracion()-c1.getDuracion()))
		//		.limit(listaCursos.size()/2+1).forEach(c->System.out.println())
	
		//6 Mostrar la duración total de los cursos	
		System.out.println("Duración total de los cursos " +
		listaCursos.stream().map(c -> c.getDuracion()).mapToDouble(i -> i.doubleValue()).sum());
		
		//6 Mostrar la duración total de los cursos alt 2
		System.out.println("Duración total de los cursos: " + listaCursos.stream().mapToDouble(Curso::getDuracion).sum());
		
		//Curso::getDuracion METHOD REFEFRENCE - forma abreviada lambda
		
		/* TAREA PENDIENTE TODO: */
		/*
		 * Crear una lista de string con los titulos de todos los cursos
		   Mostrar todos aquellos cursos cuya duración supere el promedio de duración en horas del conjunto
		   Mostrar la duración de los cursos con menos de 500 alumnos
		 * */
		
		// Crear una lista de string con los titulos de todos los cursos
		System.out.println("Lista de cursos: " + listaCursos.stream().map(Curso::getTitulo).toList());
		// Mostrar todos aquellos cursos cuya duración supere el promedio de duración en horas del conjunto
		System.out.println("Cursos cuya duración supere el promedio: " +listaCursos.stream().filter(curso -> curso.getDuracion() > listaCursos.stream().mapToDouble(Curso::getDuracion).average().getAsDouble()).map(Curso::getTitulo).toList());
		
		var d = listaCursos.stream().collect(
				Collectors.teeing(
						Collectors.averagingDouble(Curso::getDuracion), 
						Collectors.toList(), 
						(media, lista)->{
							//System.out.println("media = "+media);
							var c = lista.stream().filter(curso -> curso.getDuracion() > media).collect(Collectors.toList());
							return c;
						}));
		System.out.println("a = " + d);
		
		
		
		// Mostrar la duración de los cursos con menos de 500 alumnos
		System.out.println("Duracion de los cursos con menos de 500 alumnos: " +listaCursos.stream().filter(curso -> curso.getAlumnos() < 500).map(Curso::getDuracion).toList());
		//for each Collection vs for each stream https://stackoverflow.com/questions/23218874/what-is-difference-between-collection-stream-foreach-and-collection-foreach
		listaCursos.forEach(curso-> System.out.println(curso.getTitulo()));
		listaCursos.stream().forEach(curso-> System.out.println(curso.getTitulo()));
	}

}
