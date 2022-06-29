package trabajos;

import java.util.HashMap;
import java.util.Iterator;

public class ExisteCamino {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private HashMap<Integer,String> colores;
	
	public ExisteCamino(Grafo<?> grafo, int origen, int destino) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.colores = new HashMap<>();
	}
	
	public boolean existeCamino() {
		
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "blanco");
		}
	
		boolean hayCamino = existeCaminoVisit(this.origen);		
		return hayCamino;
	}

	private boolean existeCaminoVisit(int verticeActual) {

		colores.put(verticeActual, "amarillo");

		if (verticeActual == this.destino) {
			return true;
		} else {
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeActual);
			while (it.hasNext()) {
				int adyacente = it.next();
				if (colores.get(adyacente).equals("blanco")) {
					boolean hayCamino = existeCaminoVisit(adyacente);
					if (hayCamino)
						return true;
				}
			}
			
			// colores.put(verticeActual, "negro");
	
			return false;
			
		}
	}
	
}
