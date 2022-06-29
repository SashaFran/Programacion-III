package trabajos;

import java.util.HashMap;
import java.util.Iterator;

public class BusquedaCiclo {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int tiempo;
	private HashMap<Integer, Integer> descubrimiento;
	private HashMap<Integer, Integer> finalizacion;
	
	public BusquedaCiclo(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.tiempo = 0;
		this.descubrimiento = new HashMap<>();
		this.finalizacion = new HashMap<>();
		
	}
	
	public boolean hayCiclo() {
		Iterator<Integer> it =this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "Blanco");;
		}
		this.tiempo = 0;
		
		it= this.grafo.obtenerVertices();
		boolean encontre = false;
		
		while(it.hasNext() && !encontre) {
			int verticeId = it.next();
			if(colores.get(verticeId).equals("Blanco"))
				encontre = dfs_visit(verticeId);
		}
		return encontre;
		
		}
	
	public boolean dfs_visit(int vertice) {
		colores.put(vertice, "Amarillo");
		tiempo =+ 1;
		descubrimiento.put(vertice, tiempo);
		
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
		boolean encontre = false;
		while(it.hasNext() && !encontre) {
			int adyacente = it.next();
			if(colores.get(adyacente).equals("Blanco"))
				encontre = dfs_visit(adyacente);
			//ponemos el else if con el objetivo de saber si un vertice tiene otro arco
			else if(colores.get(adyacente).equals("Amarillo")) {
				//encontre un ciclo
				encontre = true;
			}
		}
		
		colores.put(vertice, "Negro");
		tiempo +=1;
		finalizacion.put(vertice, tiempo);
		
		return encontre;
	}
	
}
