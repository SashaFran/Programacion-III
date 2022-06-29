package trabajos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DFS {

	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	private int tiempo;
	private HashMap<Integer, Integer> descubrimiento;
	private HashMap<Integer, Integer> finalizacion;
	
	
	public DFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.tiempo = 0;
		this.descubrimiento = new HashMap<>();
		this.finalizacion = new HashMap<>();
		
	}
	
	public void dfs() {
		
		Iterator<Integer> it =this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "Blanco");;
		}
		this.tiempo = 0;
		
		it= this.grafo.obtenerVertices();
		while(it.hasNext()) {
			int verticeId = it.next();
			if(colores.get(verticeId).equals("Blanco"))
				dfs_visit(verticeId);
		}
		
		}
	
	public List<Integer> dfs_visit(int vertice) {
		
		ArrayList<Integer> v = new ArrayList<>();
		colores.put(vertice, "Amarillo");
		tiempo =+ 1;
		descubrimiento.put(vertice, tiempo);
		v.add(vertice);
		
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(vertice);
		while(it.hasNext()) {
			int adyacente = it.next();
			if(colores.get(adyacente).equals("Blanco"))
				return dfs_visit(adyacente);
			//ponemos el else if con el objetivo de saber si un vertice tiene otro arco
			else if(colores.get(adyacente).equals("Amarillo")) {
				v.add(adyacente);
			}
		}
		
		colores.put(vertice, "Negro");
		tiempo +=1;
		finalizacion.put(vertice, tiempo);
		
		return v;
	}
	
	
}
