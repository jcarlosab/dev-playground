package edu.val.cle.atsistemas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.val.cle.atsistemas.entity.Alumno;
import edu.val.cle.atsistemas.repository.RxAlumnoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class RxAlumnoServiceImp implements RxAlumnoService {
	
	@Autowired
	RxAlumnoRepository rxAlumnoRepository;
	
	public Flux<Alumno> getAllAlumnos(){
        return rxAlumnoRepository.findAll();
    }

	@Override
	public Mono<Alumno> createAlumno(Alumno alumno) {
		return rxAlumnoRepository.save(alumno);
	}
	
	public Mono<Void> deleteAlumno(Long id){
        return rxAlumnoRepository.deleteById(id);
    }
	
	public Mono<Alumno> findById(Long id){
        return rxAlumnoRepository.findById(id);
    }
	
	 public Mono<Alumno> updateAlumno(Long id,  Alumno alumno){
	        return rxAlumnoRepository.findById(id)
	                .flatMap(alumno_leido -> {
	                	alumno_leido.setNombre(alumno.getNombre());
	                	alumno_leido.setApellido(alumno.getApellido());
	                	alumno_leido.setEdad(alumno.getEdad());
	                	alumno_leido.setEmail(alumno.getEmail());
	                    return rxAlumnoRepository.save(alumno_leido);
	                });
	    }

}
