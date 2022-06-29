package ejercicio_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Cajero {

	private static ArrayList<Integer> valorMonedas;
	private static HashMap<Integer, Integer> solucion;
	private static int objective;
	private static int valorActual;
	private static int moneda;
	
	public static HashMap<Integer, Integer> devolucion(ArrayList<Integer> monedas, int target){
		
		valorMonedas = monedas;
		Collections.sort(valorMonedas);
		Collections.reverse(valorMonedas);
		
		solucion = new HashMap<Integer,Integer>();
		for (Integer i : valorMonedas) {
			solucion.put(i, 0);
		}
		objective = target;
		valorActual = 0;
		
		while(!valorMonedas.isEmpty() && !solucion()){			
			moneda = seleccion();
			if(factible(moneda)){
				solucion.replace(moneda, (solucion.get(moneda))+1);
				valorActual += moneda;
			}else{
				valorMonedas.remove(0);
			}
		}
		
		return solucion;
		
	}
	
	
	public static String sortedPrint(HashMap<Integer, Integer> solucion) {
		
		String result = "";
		ArrayList <Integer> valores = new ArrayList<Integer>();
		Iterator<Entry<Integer, Integer>> it = solucion.entrySet().iterator();
		Entry<Integer, Integer> aux;
		
		
		while(it.hasNext()){
			aux = it.next();
			valores.add(aux.getKey());
		}
		
		Collections.sort(valores);
		Collections.reverse(valores);
		
		for (Integer i : valores) {
			result += " Valor: " + i + " Cantidad: " + solucion.get(i) + "\n";
		}
		
		return result;
	}


	private static boolean factible(int moneda) {
		
		return (valorActual + moneda) <= objective;
	}

	private static int seleccion() {
		return valorMonedas.get(0);
	}

	private static boolean solucion() {
		return objective == valorActual;
	}

	public static void main(String[] args) {		
		ArrayList<Integer> c = new ArrayList<Integer>();		
		c.add(50);
		c.add(20);
		c.add(10);
		c.add(5);
		c.add(2);
		c.add(1);		
		System.out.println(Cajero.sortedPrint(Cajero.devolucion(c, 177)));
		
	}
}
