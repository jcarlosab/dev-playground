package edu.val.cle.atsistemas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.val.cle.atsistemas.model.entity.Alumno;

//@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
