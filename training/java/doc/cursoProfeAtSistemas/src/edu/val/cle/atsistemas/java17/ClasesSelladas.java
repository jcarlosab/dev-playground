package edu.val.cle.atsistemas.java17;

//import javax.crypto.SealedObject;

public class ClasesSelladas {
	
	/**
	 * SEALED CLASSEs: MECANISMO PARA LIMITAR LA HERENCIA DE CLASES E INTERFACES
	 * LAS SUBCLASES AUTORIZADAS ESTÁN ACOTADAS EXPLÍCITAMENTE
	 * 
	 * las clases que entran en esta relación deben estar en el mismo paquete
	 * o en el mismo módulo (si estamos usando un proyecto modulor)
	 */
	public sealed class Persona permits Alumno, Profesor {
		
	}
	
	//CUANDO UNA SUBCLASES HEREDA DE UNA SELLADA, TIENE QUE INDICARLO CON extends
	//PERO ADEMÁS, debe usar uno de los siguientes adjetivos/palabras reservadas
		 // - sealed -> algunas subclases podrán heredar
		 // - non-sealed -> todas las subclases podrán heredar
	     // - final -> ninguna clase puede heredar
	
	public final class Profesor extends Persona {
	}
	
	public sealed class Alumno extends Persona permits AlumnoExcelente {
	}
	
	public non-sealed class AlumnoExcelente extends Alumno {
	}
}
