package trabajos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCamino {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private HashMap<Integer,String> colores;
	
	public EncontrarCamino(Grafo<?> grafo, int origen, int destino) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.colores = new HashMap<>();
	}
	
	public ArrayList<Integer> encontrarCamino() {
		
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
	
		return encontrarCamino(this.origen);		
	}

	private ArrayList<Integer> encontrarCamino(int verticeActual) {

		colores.put(verticeActual, "amarillo");

		ArrayList<Integer> salida = new ArrayList<Integer>();
		if (verticeActual == this.destino) {
			salida.add(verticeActual);
			return salida;
		} else {
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeActual);
			while (it.hasNext()) {
				int adyacente = it.next();
				if (colores.get(adyacente).equals("blanco")) {
					ArrayList<Integer> camino = encontrarCamino(adyacente);
					if (!camino.isEmpty()) {
						salida.add(verticeActual);
						salida.addAll(camino);
						return salida;
					}
				}
			}
			
			// colores.put(verticeActual, "negro");
	
			return salida;
			
		}
	}
	
}
