package ejercicio_2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args){
    	Main m = new Main();
        System.out.println("Por favor ingrese el numero que desea convertir a binario: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num;
		try {
			num = Integer.parseInt(reader.readLine());
			int bin = m.integerToBinary(num);
			m.print(bin);
		}catch (Exception exc) {
			System.out.println(exc);
		}
    }

    public int integerToBinary(int num) {
        if (num<=0) return 0;
        if  (num >= 2) {
            return num%2 + integerToBinary(num / 2)*10;
        } else {
            return num;
        }
    }
	public void print(int a) {
       System.out.print(a);
	}

}
