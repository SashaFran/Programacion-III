package ejercicio_7;

import java.util.ArrayList;
import java.util.Map.Entry;

public class Leoncito {

	public Solucion greedy(ArrayList<Personaje> conjunto, int maxMov) {
		Solucion solucion = new Solucion();
		int index = 0;
		
		boolean primeraVez = true;
		int indexCazador = 0;
		int indexLeon = 0;
		
		while (indexCazador < conjunto.size() && indexLeon < conjunto.size()) {//Selecciono el proximo par de cazador y leon
			Entry<Integer, Integer> x = seleccionar(conjunto, indexCazador, indexLeon);
			remove(conjunto, x); //marco el leon como cazado y marco el cazador como que ya cazo
			if(factible(x, maxMov)){ // cazador.distancia(leon) < maxMov
			solucion.add(x);//Aca tengo que agregar un cazador - leon
			indexCazador = conjunto.indexOf(x.getKey());
			indexLeon = conjunto.indexOf(x.getValue());
			}else {
				if(indexCazador < indexLeon)
					indexCazador++;
				else
					indexLeon++;
			}
			primeraVez = false;
		}
			return solucion;
	}

	private boolean factible(Entry<Integer, Integer> candidato, int distanciaMax) {
		return Math.abs(candidato.getKey() - candidato.getValue() < distanciaMax);
	}

	private Entry<Integer, Integer> seleccionar(ArrayList<Personaje> conjunto, int indexCazador, int indexLeon) {
//		recorro el arreglo y busco el cazzador con menos leones a su alrededor
		//Selecciono ESE caz<aador con alguno de los leones que tenga alrededor
		//Leones no cazados y cazadores que no hayan cazado
		//el recorrido arranca desde los indices que me pasaron
		
		
		return null;
	}

	private boolean termineDeRecorrer(int index, ArrayList<Personaje> conjunto) {
		// TODO Auto-generated method stub
		return index == conjunto.size();
	}

	private boolean es_solucion(Solucion solucion) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void remove (ArrayList<Personaje> conjunto, Entry<Integer, Integer> candidato) {
		conjunto.get(candidato.getKey().marcarUsado();
		conjunto.get(candidato.getValue().marcarUsado();
	}

	
}
