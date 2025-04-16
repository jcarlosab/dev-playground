package edu.val.cle.atsistemas.java9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryConRecursosMejorado {
	
	public static void main(String[] args) throws IOException {
		//BufferedReader bf = null;
		//TWR - 7 Recurso implementa Autocloseable (se cierran solitos)
		//Try With Resources mejora de la nueva
		//lo puedo declarar fuera simpre que sea un objeto final o final efectivo
		BufferedReader bf = new BufferedReader(new FileReader("./src/module-info.java"));
		//BufferedReader bf2 = new BufferedReader(new FileReader("./src/module-info.java"));
		//try (bf;bf2)
		try (bf) {
			//bf = new BufferedReader(new FileReader("./src/module-info.java"));
			String linea =  bf.readLine();
			System.out.println(linea);
			//aquí llama a close bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//ESTA SECCIÓN LA PUEDO OMITIR POR LA MEJORA DEL TWR
		/*finally { 
			try {
				bf.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro al librear recursos");
			}
			
		}*/
	}

}
