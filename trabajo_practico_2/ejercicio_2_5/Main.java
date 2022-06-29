package ejercicio_2_5;

public class Main {

	public static void main(String[] args) {
		int[] example = {9, 7, 2, 1, 6, 3, 5, 10, 4, 8};
		System.out.println("Sin mergear");
		for (int i= 0; i< example.length; i++) {
			System.out.print(example[i] + " ");
		}
		Mergesort2.sort(example);

		System.out.println("\nCombinado: ");
		for (int i= 0; i< example.length; i++) {
			System.out.print(example[i] + " ");
		}
	}

}
