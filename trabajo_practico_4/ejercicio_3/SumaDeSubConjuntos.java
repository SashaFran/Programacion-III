package ejercicio_3;

import java.util.ArrayList;

public class SumaDeSubConjuntos {

	public  Solucion solucion ;


	public SumaDeSubConjuntos() {
		this.solucion = new Solucion();
	}
	
	public Solucion getSolucion() {
		return solucion;
	}

	public void sumaSubconjuntos(ArrayList<Integer>numeros,int sumaBuscada) {
		int puntero = 0;
		ArrayList<Integer> selector = new ArrayList<>(numeros.size());
		sumaSubconjuntos(numeros,selector,puntero,sumaBuscada);
	}


	public  void sumaSubconjuntos(ArrayList<Integer>numeros,ArrayList<Integer> selector,int puntero,int sumaBuscada) {
		// base case :si estado  es == suma buscada
		if(puntero == numeros.size()) {
			if(esSolucion(selector,sumaBuscada))
				solucion.addSolucion(new ArrayList<Integer>(selector));
			return;
		}
		if(poda(selector,sumaBuscada,numeros.get(puntero))) {
			selector.add(numeros.get(puntero));
			sumaSubconjuntos(numeros,selector,puntero+1,sumaBuscada);
			selector.remove(selector.size()-1);
			sumaSubconjuntos(numeros,selector,puntero+1,sumaBuscada);
		}

	}


	private boolean poda(ArrayList<Integer> selector,int siguienteValor, int sumaBuscada) {
		int suma = 0;
		for (Integer integer : selector) {
			suma+= integer;
		}
		suma+=siguienteValor;
		return suma>sumaBuscada;
	}
	
	private boolean esSolucion(ArrayList<Integer> selector,int sumaBuscada) {
		int suma = 0;
		for (Integer valor : selector) {
			suma+= valor;
		}
		return suma==sumaBuscada;
	}

}
