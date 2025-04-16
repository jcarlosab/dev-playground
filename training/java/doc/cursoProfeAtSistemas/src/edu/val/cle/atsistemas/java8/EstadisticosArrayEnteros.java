package edu.val.cle.atsistemas.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class EstadisticosArrayEnteros {

	public static void main(String[] args) {

		int[] array_enteros = { 42, 1, 2, 3, 4, 5, 8, 19 };
		// int [] array_enteros = {};

		// TODO: vamos a sacar los datos estadísticos de máximo, mínimo y media de este
		// array
		// de 2 formas
		// clásica
		// java 8-9 streams


		// 1 obtener un array de stream
		IntStream intStream = Arrays.stream(array_enteros);
		// intStream.forEach(n -> System.out.println(n)); //NO PUEDO ACCEDER A UN STREAM
		// UNA VEZ CERRADO
		// IntStream intStream2 = Arrays.stream(array_enteros);
		// OptionalInt omax = intStream.max();
		// intStream.max().ifPresent(maximo->System.out.println("El máximo es
		// "+maximo));
		// int maximo0 = intStream.max().orElse(0);
		Arrays.stream(array_enteros).max().ifPresentOrElse(maximo -> System.out.println("El máximo es " + maximo),
				() -> System.out.println("NO TENEMOS MAXIMO"));
		Arrays.stream(array_enteros).min().ifPresentOrElse(maximo -> System.out.println("El mínimo es " + maximo),
				() -> System.out.println("NO TENEMOS MÍNIMO"));

		Arrays.stream(array_enteros).average().ifPresentOrElse(maximo -> System.out.println("La media es " + maximo),
				() -> System.out.println("NO TENEMOS MEDIA"));
		
		int maxclasic = clasicMax(array_enteros);
		int minclasic = clasicMin(array_enteros);
		float avgclasic = clasicAvg(array_enteros);
		
		System.out.println("MAX C " + maxclasic);
		System.out.println("MIN C " + minclasic);
		System.out.println("AVG C " + avgclasic);
		
		IntSummaryStatistics is = Arrays.stream(array_enteros).summaryStatistics();
		
		System.out.println("IS MAX C " + is.getMax());
		System.out.println("IS MIN C " + is.getMin());
		System.out.println("IS AVG C " + is.getAverage());
		
		
		// System.out.println(maximo0);
		/*
		 * if (omax.isPresent()) { System.out.println("el maximo es " +
		 * omax.getAsInt()); } else { System.out.println("no hay un máximo"); }
		 */

//		OptionalInt opi = Arrays.stream(array_enteros).peek(i -> System.out.println(i)).min();
//		OptionalDouble od = Arrays.stream(array_enteros).average();
//
//		Optional<String> ops = Optional.empty();// CREO EL OPTIONAL VACÍO
//		Optional<String> ops1 = Optional.of("PEPE"); // CON TEMA
//
//		if (ops.isPresent()) {
//			ops.get();
//		}

	}

	private static int clasicMax(int[] array_enteros) {
		int max = array_enteros[0];

		for (int i : array_enteros) {
			if (i > max) {
				max = i;
			}
		}

		return max;
	}

	private static int clasicMin(int[] array_enteros) {
		int min = array_enteros[0];

		for (int i : array_enteros) {
			if (i < min) {
				min = i;
			}
		}

		return min;
	}

	private static float clasicAvg(int[] array_enteros) {
		float media = 0;
		float total = 0;

		for (int i : array_enteros) {
			total = total + i;
		}

		media = total / array_enteros.length;
		return media;
	}

}
