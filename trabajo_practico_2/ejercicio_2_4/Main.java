package ejercicio_2_4;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		int[] array  = {5, 3, 6, 2, 6, 1, 8, 0};
		m.print(array);
		
		m.bubbleSort(array);
		m.print(array);
		m.selectionSort(array);
		m.print(array);
		
	}

	//COmplejidad O(n^2)
	public void selectionSort(int[] arr) {
	    for (int i = 0; i < arr.length; i++) {
	        // min is the index of the smallest element with an index greater or equal to i
	        int min = i;
	        for (int j = i + 1; j < arr.length; j++) {
	            if (arr[j] < arr[min]) {
	                min = j;
	            }
	        }
	        // Swapping i-th and min-th elements
	        int swap = arr[i];
	        arr[i] = arr[min];
	        arr[min] = swap;
	    }
	}
	
	//COmplejidad O(n^2)
	public void bubbleSort(int[] arr) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i=0; i<arr.length - j; i++) {
				if (arr[i] > arr[i + 1]) {
					tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
					swapped = true;
				}
			}
		}
		
	}
	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" "+array[i]);
			
		}
		System.out.println(" ");
		
	}



}
