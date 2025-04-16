package edu.val.cle.atsistemas.controller;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.val.cle.atsistemas.entity.Alumno;
import edu.val.cle.atsistemas.services.RxAlumnoService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequestMapping("/alumno")
@RestController
public class RxAlumnoController {
	
	
	  @Autowired
	  RxAlumnoService rxAlumnoService;
	
	  @GetMapping
	    public Flux<Alumno> getAllUsers(){
	        return rxAlumnoService.getAllAlumnos();
	    }
	  
	  @GetMapping("/{id}")
	    public Mono<Alumno> getAlumnoById(@PathVariable Long id){
	        return rxAlumnoService.findById(id);
	    }
	  
	  @PostMapping
	    public Mono<Alumno> postAlumno(@RequestBody Alumno alumno){
		  	return rxAlumnoService.createAlumno(alumno);
	    }
	  
	  //TODO: FALTAN PUT Y DELETE
	  
	  
	  //CADA 5 SEGUNDOS EMITIMOS LA LISTA DE ALUMNOS
	  @GetMapping(path = "flujo", produces = "text/event-stream")
	  public Flux<Alumno> streaAlumnos2() {
		    return rxAlumnoService.getAllAlumnos().timeout(Duration.ofSeconds(5));
	  }
	  

}
