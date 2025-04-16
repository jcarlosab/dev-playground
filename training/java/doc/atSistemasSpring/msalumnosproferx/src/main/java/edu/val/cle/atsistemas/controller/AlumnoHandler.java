package edu.val.cle.atsistemas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import edu.val.cle.atsistemas.entity.Alumno;
import edu.val.cle.atsistemas.services.RxAlumnoService;
import reactor.core.publisher.Mono;

@Component
public class AlumnoHandler  {

	@Autowired
    private RxAlumnoService alumnoService;

    public Mono<ServerResponse> getAllAlumnos(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(alumnoService.getAllAlumnos(), Alumno.class);
    }

    public Mono<ServerResponse> getAlumnoById(ServerRequest request) {
        return alumnoService
        		.findById(Long.parseLong(request.pathVariable("userId")))
                .flatMap(user -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(user, Alumno.class)
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<Alumno> user = request.bodyToMono(Alumno.class);

        return user
                .flatMap(u -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(alumnoService.createAlumno(u), Alumno.class)
                );
    }

    public Mono<ServerResponse> updateAlumnoById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("userId"));
        Mono<Alumno> updatedAlumno = request.bodyToMono(Alumno.class);

        return updatedAlumno
                .flatMap(u -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(alumnoService.updateAlumno(id, u), Alumno.class)
                );
    }

    public Mono<ServerResponse> deleteAlumnoById(ServerRequest request){
        return alumnoService.deleteAlumno(Long.parseLong(request.pathVariable("userId")))
                .flatMap(u -> ServerResponse.ok().body(u, Alumno.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}