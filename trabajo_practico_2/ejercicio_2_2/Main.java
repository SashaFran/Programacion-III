package ejercicio_2_2;

public class Main {

	public static void main(String[] ar) {
		Main re = new Main();
		int[] array  = {2, 3, 4, 5, 6, 7, 8, 9};
		re.imprimirRec(array);
		int i = 8;
		int inicio = 0;
		int fin = array.length -1;
		System.out.println("Posicion: " + re.ejercicio(array, i, inicio, fin)); 
		

	}

	private int ejercicio(int[] A, int X, int inicio, int fin) {
		int medio;
		if (inicio > fin) return -1; //sucederá si no se encuentra el elemento
		else {
			medio = (inicio + fin) / 2; //al ser medio un int, se realiza un truncado (pierde la parte decimal)
		if (X > A[medio])
			return ejercicio(A, X, medio+1, fin);
		else
			if (X < A[medio])
				return ejercicio(A, X, inicio, medio -1);
			else
				return medio;
		}
	}

//	private static int buscar(int[] arr, int valor, int inicio, int fin) {
//		int pos = 0;
//		for(int i= 0; i < arr.length; i++) {
//			if(arr[i] == valor) {
//				pos = i;
//			}
//		}
//		return pos;
//	}
//	
	void imprimirRec(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("pos " + i + " " + array[i]);
		}
	}


}
