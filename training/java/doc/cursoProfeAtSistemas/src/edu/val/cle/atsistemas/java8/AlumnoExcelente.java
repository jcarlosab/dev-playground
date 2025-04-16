package edu.val.cle.atsistemas.java8;

public class AlumnoExcelente implements CompruebaAlumno{

	@Override
	public boolean test(Alumno a) {
		//un alumno es excelente si su nota media es mayor o igual a 8
		boolean bdev = false;
		
			bdev = a.getNota_media() >=8;
			
		return bdev;
	}
	

}
