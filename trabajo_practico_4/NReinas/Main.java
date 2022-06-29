package NReinas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        int tam;
	    int[][] matriz;
        Scanner papas = new Scanner(System.in);
        Tablero tablero = new Tablero();
        NReinas problemaNReinas;
        System.out.println("|================================= Problema de las n reinas=========================================|");
        System.out.print("      Introduzca el tamano del tablero: ");
        tam = papas.nextInt();
        problemaNReinas = new NReinas(tam); 
	    matriz = problemaNReinas.resolver();
        problemaNReinas.resolver(); 
        tablero.setMatriz(matriz);
        tablero.construye();
        tablero.mostrar();
    }

}
