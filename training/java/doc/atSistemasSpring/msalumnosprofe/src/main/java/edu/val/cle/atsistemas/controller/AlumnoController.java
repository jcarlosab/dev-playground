package edu.val.cle.atsistemas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.val.cle.atsistemas.model.entity.Alumno;
import edu.val.cle.atsistemas.services.AlumnoService;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	/**
	 * LEER LOS ALUMNOS -get LEER UN ALUMNO - get BORRAR UN ALUMNO - delete CREAR UN
	 * ALUMNO - post ACTUALIZAR UN ALUMNO - put
	 */

	@GetMapping("/alumno-test") // GET http://localhost:8081/alumno/alumno-test
	public Alumno obtenerAlumnoTest() {
		Alumno alumno = null;

		alumno = new Alumno(5l, "PACO", "paco@correo.es", 19);

		return alumno;
	}

	@GetMapping // GET http://localhost:8081/alumno/
	public ResponseEntity<?> listarAlumnos() {
		ResponseEntity<?> responseEntity = null;
		Iterable<Alumno> lista_alumnos = null;

		lista_alumnos = this.alumnoService.findAll();
		responseEntity = ResponseEntity.ok(lista_alumnos);// construyo el mensaje HTTP con 200/ok y en el cuerpo, el
															// listado

		return responseEntity;// este es el mensaje HTTP de vuelta
	}

	@GetMapping("/{id}") // GET http://localhost:8081/alumno/1
	public ResponseEntity<?> listarAlumnoPorID(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Optional<Alumno> optional_a = null;

		optional_a = this.alumnoService.findById(id);

		if (optional_a.isPresent()) {
			Alumno alumno = optional_a.get();
			responseEntity = ResponseEntity.ok(alumno);
		} else {
			// el alumno no existía en la base de datos
			responseEntity = ResponseEntity.noContent().build();
		}

		return responseEntity;// este es el mensaje HTTP de vuelta
	}

	@PostMapping // POST http://localhost:8081/alumno/
	public ResponseEntity<?> insertarAlumno(@RequestBody Alumno alumno) {
		ResponseEntity<?> responseEntity = null;
		Alumno alumno_creado = null;

		alumno_creado = this.alumnoService.save(alumno);
		responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(alumno_creado);

		return responseEntity;// este es el mensaje HTTP de vuelta
	}

	@DeleteMapping("/{id}") // delte localhost:8081/alumno/1
	public ResponseEntity<?> borrarAlumno(@PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;

		this.alumnoService.deleteById(id);
		responseEntity = ResponseEntity.ok().build();

		return responseEntity;// este es el mensaje HTTP de vuelta
	}

	@PutMapping("/{id}") // put localhost:8081/alumno/1
	public ResponseEntity<?> modificarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		ResponseEntity<?> responseEntity = null;
		Alumno alumno_modificado = null;

		
			alumno_modificado = this.alumnoService.update(alumno, id);

			if (alumno_modificado != null) {
				responseEntity = ResponseEntity.ok(alumno_modificado);
			} else {

				responseEntity = ResponseEntity.notFound().build();
			}


	return responseEntity;// este es el mensaje HTTP de vuelta
}

}
