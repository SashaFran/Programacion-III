package ejercicio_3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		numeros.add(3);
		numeros.add(4);
		numeros.add(1);
		numeros.add(5);
		numeros.add(9);
		numeros.add(8);
		numeros.add(7);
		numeros.add(6);
		int sumaBuscada = 20;
		System.out.println("Array: " + numeros);
		SumaDeSubConjuntos suma = new SumaDeSubConjuntos();
		suma.sumaSubconjuntos(numeros,sumaBuscada);
	}

}
