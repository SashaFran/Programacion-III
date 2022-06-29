package ejercicio_2;

public class Mochila {

	private static Integer P; // capacidad total de la mochila
	private static Integer n; // cantidad de objetos
	private static int control;

	public static void main(String[] args) {
		P = 20;
		n = 3;
		control = 0;
		
		int[] p = {18, 15, 10};
		int[] v = {25, 24, 15};
		double[] x = new double[n];
		
		int i = 0;
		int peso = 0;
		for(int k = 0; k < n; k++) {
			
		}
		
		while(peso < P) {
			i = seleccionGreedy(p, v);
			
			if(peso + p[i] < P) {
				x[i] = 1; 
				peso = peso + p[i];
				System.out.println("peso: " + peso);
			} else {
				x[i] = (P - peso) / p[i];
				peso = P;
				System.out.println("peso: " + peso);
			}
				
		}
		
		System.out.println(x);
	}
	
	public static int seleccionGreedy(int[] p, int[] v) {
		double aux = 0;
		double max = 0;
		int pos = 0;
		return pos;
	}
}
