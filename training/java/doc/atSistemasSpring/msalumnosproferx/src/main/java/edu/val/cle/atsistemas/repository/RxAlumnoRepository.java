package edu.val.cle.atsistemas.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import edu.val.cle.atsistemas.entity.Alumno;

//simple - al heredar de esta ya encuentra un repo
@Repository
public interface RxAlumnoRepository extends ReactiveCrudRepository<Alumno, Long> {

	

}
