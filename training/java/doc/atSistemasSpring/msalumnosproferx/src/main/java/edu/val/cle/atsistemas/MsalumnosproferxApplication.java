package edu.val.cle.atsistemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import edu.val.cle.atsistemas.controller.AlumnoHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@SpringBootApplication
public class MsalumnosproferxApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsalumnosproferxApplication.class, args);
	}
	
	 @Bean
	    RouterFunction<ServerResponse> routes(AlumnoHandler handler) {
	        return RouterFunctions.route(GET("/fep/alumno").and(accept(MediaType.APPLICATION_JSON)), handler::getAllAlumnos)
	                .andRoute(GET("/fep/alumno/{alumnoId}").and(contentType(MediaType.APPLICATION_JSON)), handler::getAlumnoById)
	                .andRoute(POST("/fep/alumno").and(accept(MediaType.APPLICATION_JSON)), handler::create)
	                .andRoute(PUT("/fep/alumno/{alumnoId}").and(contentType(MediaType.APPLICATION_JSON)), handler::updateAlumnoById)
	                .andRoute(DELETE("/fep/alumno/{alumnoId}").and(accept(MediaType.APPLICATION_JSON)), handler::deleteAlumnoById);
	    }

}
