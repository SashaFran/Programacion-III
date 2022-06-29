package trabajos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarMejorCamino {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private HashMap<Integer,String> colores;
	
	public EncontrarMejorCamino(Grafo<?> grafo, int origen, int destino) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.colores = new HashMap<>();
	}
	
	public ArrayList<ArrayList<Integer>> encontrarCaminos() {
		
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
	
		return encontrarCaminos(this.origen);		
	}

	private ArrayList< ArrayList<Integer> > encontrarCaminos(int verticeActual) {

		colores.put(verticeActual, "amarillo");

		ArrayList<ArrayList<Integer>> salida = new ArrayList<ArrayList<Integer>>();
		if (verticeActual == this.destino) {
			ArrayList<Integer> caminoUnico = new ArrayList<Integer>();
			caminoUnico.add(verticeActual);
			salida.add(caminoUnico);
			
			colores.put(verticeActual, "blanco");

			return salida;
		} else {
			
			// Variable auxiliar: ir guardando el mas corto
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeActual);
			while (it.hasNext()) {
				int adyacente = it.next();
				if (colores.get(adyacente).equals("blanco")) {
					ArrayList<ArrayList<Integer>> caminos = encontrarCaminos(adyacente);
					
					for (ArrayList<Integer> camino: caminos) {
						if (!camino.isEmpty()) {
							ArrayList<Integer> caminoCompleto = new ArrayList<Integer>();
							caminoCompleto.add(verticeActual);
							caminoCompleto.addAll(camino);
							salida.add(caminoCompleto);
						}
					}
					
				}
			}
			
			colores.put(verticeActual, "blanco"); // IMPORTANTE
	
			return salida;
			
		}
	}
	
}
