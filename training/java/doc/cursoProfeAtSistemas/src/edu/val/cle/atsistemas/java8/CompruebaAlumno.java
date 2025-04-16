package edu.val.cle.atsistemas.java8;

@FunctionalInterface//PARA QUE SEA FI, UN SÓLO MÉTODO ABSTRACTO (puede haber más de default y static,sobreescritos object)
public interface CompruebaAlumno {

	boolean test(Alumno a);

	default boolean test2(Alumno a) {
		return false;
	}
	
//	@Override
//	boolean equals(Object obj) 
//	{return false;}

}
