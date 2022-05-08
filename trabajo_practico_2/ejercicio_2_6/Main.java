package ejercicio_2_6;


//import ejercicio_2_3.Main;

//Falta array.sort()
public class Main {

	final static int N = 10;
	
	public static void main(String[] args) {
		Main m = new Main();
		ejercicio_2_4.Main n = new ejercicio_2_4.Main();
		ejercicio_2_3.Main n2 = new ejercicio_2_3.Main();
		int[] A = new int[N];
		long startTime = System.currentTimeMillis();
		for(int i = 0; i<10000; i++) {			
			m.fillArray(A); 
			m.print(A);						
		}
		long endTime = System.currentTimeMillis() - startTime;	
		System.out.println("Tiempo array: " + Long.toString(endTime));

		System.out.println("\nSelection sort: ");
		n.selectionSort(A);
		n.print(A);
		System.out.println("\nEjercicio 3: ");
		for(int i = 0; i< A.length; i++) {
			int b = n2.integerToBinary(A[i]);
			n2.print(b);
			System.out.print(" ");
		}
		
	}

	private void print(int[] a) {
        for (int element: a) {
            System.out.print(" " +element);
        }
	}

	private int fillArray(int[] a) {
		int num = 0;
        for (int i = 0; i < a.length; i++) {
            num = (int) Math.floor(Math.random()*100+1);
            a[i] = num;
        }
        return num;
	}

}
