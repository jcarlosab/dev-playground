package edu.val.cle.atsistemas.services;

import edu.val.cle.atsistemas.entity.Alumno;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RxAlumnoService {
	
	
	public Flux<Alumno> getAllAlumnos();
	public Mono<Alumno> createAlumno(Alumno alumno);
	public Mono<Void> deleteAlumno(Long id);
	public Mono<Alumno> findById(Long id);
	public Mono<Alumno> updateAlumno(Long id,  Alumno alumno);

}
