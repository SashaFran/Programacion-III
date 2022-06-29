package ejercicio_2_5;


/*
 * Complejidad:
 *  promedio: n log n.
	Peor caso: n^2.
 */
public class Mergesort2 {
	private static int[ ] numbers;
	private static int[ ] helper;
	private static int size;
	
	public static void sort(int[ ] values) {
		numbers = values;
		size = values.length;
		helper = new int[size];
		mergesort(0, size - 1);
	}
	
	private static void mergesort(int low, int high) {
		if (low < high) {
			int middle = (low + high) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}
	
	private static void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (helper[ i ] >= helper[ j ]) {
				numbers[ k ] = helper[ i ];
				i++;
		}else{
			numbers[ k ] = helper[ j ];
			j++;
		}
			k++;
		}
		while (i <= middle) {
			numbers[ k ] = helper[ i ];
			k++;
			i++;
		}
		while (j <= high) {
			numbers[ k ] = helper[ j ];
			k++;
			j++;
		}
	}

	
}
