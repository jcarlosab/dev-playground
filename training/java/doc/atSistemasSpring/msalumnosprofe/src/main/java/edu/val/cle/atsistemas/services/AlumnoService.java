package edu.val.cle.atsistemas.services;

import java.util.Optional;

import edu.val.cle.atsistemas.model.entity.Alumno;

public interface AlumnoService {

	public Iterable<Alumno> findAll();

	public Optional<Alumno> findById(Long id);

	public Alumno save(Alumno alumno);

	public void deleteById(Long id);

	public Alumno update(Alumno alumno, Long id);

}
