package trabajos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCaminoCorto {

	private Grafo<Integer> grafo;
	private HashMap<Integer,Boolean> visitados;
	private HashMap<Integer,Integer> padres;

	private HashMap<Integer,ArrayList<Integer>> caminos;

	public ArrayList<Integer> bfsVisit(int origen, int destino) {
		
		ArrayList<Integer> fila = new ArrayList<>();

		this.visitados.put(origen, true); // Marcar el vértice s como VISITADO.
		fila.add(origen); // Agregar s a la fila F.
		
		boolean llegue = false;
		
		while (!fila.isEmpty() && !llegue) { // Mientras la fila F no esté vacía
			
			int x = fila.remove(0); // Tomamos vértice x de la fila,
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(x);
			while (it.hasNext() && !llegue) {
				int y = it.next(); // Para cada vértice y adyacente a x:
				if (!this.visitados.get(y)) { // Si y es NO_VISITADO 
					this.visitados.put(y, true); // Marcar el vértice y como VISITADO.
					fila.add(y); // Agregar y a la fila F.
					this.padres.put(y, x);
					// this.caminos.put(y, this.caminos.get(x) + y)
					if (y == destino)
						llegue = true;
				}
			}
		}
		
		if (llegue) {
			ArrayList<Integer> salida = new ArrayList<>();
			Integer aux = destino;
			while(aux != null) {
				salida.add(0, aux);
				aux = this.padres.get(aux);
			}
			return salida;
		} else {
			return null;
		}
		
	}
	
	
	
	
}
