package trabajos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BFS {

	private Grafo<Integer> grafo;
	private HashMap<Integer,Boolean> visitados;
	
	
	public ArrayList<Integer> bfsVisit(int origen) {
		
		ArrayList<Integer> fila = new ArrayList<>();
		ArrayList<Integer> salida = new ArrayList<>();

		this.visitados.put(origen, true); // Marcar el vertice como VISITADO.
		fila.add(origen); // Agrega a la fila F.
		salida.add(origen);
		
		while (!fila.isEmpty()) { // Mientras la fila F no esta vacia
			
			int x = fila.remove(0); // Tomamos vertice x de la fila,
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(x);
			while (it.hasNext()) {
				int y = it.next(); // Para cada vertice y adyacente a x:
				if (!this.visitados.get(y)) { // Si y es NO_VISITADO 
					this.visitados.put(y, true); // Marcar el vertice y como VISITADO.
					fila.add(y); // Agregar y a la fila F.
					salida.add(y);
				}
			}
		}
		
		return salida;
	}
	
	
	
	
}
