package edu.val.cle.atsistemas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.val.cle.atsistemas.model.entity.Alumno;
import edu.val.cle.atsistemas.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	
	/**
	 * comprarBillete
	 * {
	 *  
	 *  MARCAS EL ASIENTO COMO OCUPADO
	 *  ACTUALIZA CONTABILIDAD
	 *  PAGAS
	 *  
	 *  
	 * }
	 */
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Alumno> findAll() {
		return this.alumnoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(Long id) {
		return this.alumnoRepository.findById(id);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		return this.alumnoRepository.save(alumno);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.alumnoRepository.deleteById(id);	
		
	}

	@Override
	@Transactional
	public Alumno update(Alumno alumno, Long id) {
		Optional<Alumno> oa = null;
		Alumno alumno_leido = null;
		Alumno alumno_modificado = null;
		
			oa = this.alumnoRepository.findById(id);
			if (oa.isPresent())
			{
				//el alumno que queremos modificar, existe
				alumno_leido = oa.get();
				alumno_leido.setEdad(alumno.getEdad());
				alumno_leido.setEmail(alumno.getEmail());
				alumno_leido.setNombre(alumno.getNombre());
				
				
				alumno_modificado = this.alumnoRepository.save(alumno_leido);
				
			}
		
		return alumno_modificado;
	}

}
