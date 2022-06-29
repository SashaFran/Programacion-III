package ejercicio_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GrafoDirigido<T>{

	// G=(V, A)
	// A ⊆ VxV 
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	private HashMap<Integer, String> colores;
	private HashMap<Integer,Boolean> visitados;
	
	// Guarda el vertice y la etiqueta
	private HashMap<Integer, T> recorrido;
	
	
	public GrafoDirigido() {
		this.vertices = new HashMap<Integer,ArrayList<Arco<T>>>();
		this.recorrido = new HashMap<Integer, T>();
		this.colores = new HashMap<Integer, String>();
		this.visitados = new HashMap<Integer,Boolean>();
	}

	
	public void agregarVertice(int verticeId) {
		// Para guardar el vertice, pide el id y se guardan los arcos del vertice.
		vertices.put(verticeId, new ArrayList<Arco<T>>());
	}

	
	public void borrarVertice(int verticeId) {
		//Key value en una linea
		vertices.forEach((k,v) -> {
					this.borrarArco(k, verticeId);
		});
		vertices.remove(verticeId);
	}

	
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco a = new Arco(verticeId1, verticeId2, etiqueta);
		vertices.get(verticeId1).add(a);
	}

	
	public void borrarArco(int verticeId1, int verticeId2) {
		//si existe (puede no existir) tanto el v1 como el v1 con v2
		ArrayList<Arco<T>> arregloDeArcos = vertices.get(verticeId1);
		if (!arregloDeArcos.isEmpty()) {
			//por cada arco del arreglo
			for(Arco a : arregloDeArcos) {
				//fijate si el origen es igual al vertice 1 y si el destino es el vertice 2
				if((a.getVerticeOrigen() == verticeId1) && (a.getVerticeDestino() == verticeId2)) {
					//si cumple, lo elimina
					arregloDeArcos.remove(a);
				}
			}
		}
	}

	
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	
	public boolean existeArco(int verticeId1, int verticeId2) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arregloDeArcos = vertices.get(verticeId1);
			if (!arregloDeArcos.isEmpty()) {
				for(Arco arco : arregloDeArcos) {
					if((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arregloDeArcos = vertices.get(verticeId1);
			if (!arregloDeArcos.isEmpty()) {
				for(Arco arco : arregloDeArcos) {
					if((arco.getVerticeOrigen() == verticeId1) && (arco.getVerticeDestino() == verticeId2)) {
						return arco;
					}
				}
			}
		}
		return null;
	}

	
	public int cantidadVertices() {
		return vertices.size();
	}

	
	public int cantidadArcos() {
		int contador = 0;
		for (ArrayList<Arco<T>> arregloDeArcos : vertices.values()) {
			if (!arregloDeArcos.isEmpty()) {
				contador = contador + arregloDeArcos.size();
			}
		}
		return contador;
	}

	
	public Iterator<Integer> obtenerVertices() {
		//Devuelve un conjunto con las claves que hay en el HashMap
		 return this.vertices.keySet().iterator(); 
	}

	
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>> arcosAdyacentes = vertices.get(verticeId);
		ArrayList<Integer> numeroAdyacentes = new ArrayList<Integer>();
		for (Arco<T> arco :arcosAdyacentes) {
			if(arco != null) {
				numeroAdyacentes.add(arco.getVerticeDestino());
			}
		}
		return numeroAdyacentes.iterator();
	}

	
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> adyacentes = new ArrayList<Arco<T>>();
		for(ArrayList<Arco<T>> arcos: vertices.values()) {
			adyacentes.addAll(arcos);
		}
		return adyacentes.iterator();
	}

	
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		return vertices.get(verticeId).iterator();
	}
	
	public void DFS() {
		Iterator<Integer> it = this.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			colores.put(verticeId, "Blanco");;
		}
		it = this.obtenerVertices();
		while(it.hasNext()) {
			int verticeId = it.next();
			if(colores.get(verticeId).equals("Blanco"))
				dfs_visit(verticeId);
		}
	}


	private List<Integer> dfs_visit(int verticeId) {
		ArrayList<Integer> descubrimiento = new ArrayList<>();
		ArrayList<Integer> finalizacion = new ArrayList<>();
		ArrayList<Integer> v = new ArrayList<>();
		colores.put(verticeId, "Amarillo");
		descubrimiento.add(verticeId);
		v.add(verticeId);
		
		Iterator<Integer> it = this.obtenerAdyacentes(verticeId);
		while(it.hasNext()) {
			int adyacente = it.next();
			if(colores.get(adyacente).equals("Blanco"))
				return dfs_visit(adyacente);
			else if(colores.get(adyacente).equals("Amarillo")) {
				v.add(adyacente);
			}
		}
		
		colores.put(verticeId, "Negro");
		finalizacion.add(verticeId);
		return v;
	}
	
	public ArrayList<Integer> bfsVisit(int origen) {
		
		ArrayList<Integer> fila = new ArrayList<>();
		ArrayList<Integer> salida = new ArrayList<>();
		this.visitados.put(origen, true); 
		fila.add(origen);
		salida.add(origen);
		while (!fila.isEmpty()) {
			int x = fila.remove(0);			
			Iterator<Integer> it = this.obtenerAdyacentes(x);
			while (it.hasNext()) {
				int y = it.next();
				if (!this.visitados.get(y)) {
					this.visitados.put(y, true);
					fila.add(y);
					salida.add(y);
				}
			}
		}return salida;
	}
	


	
}
