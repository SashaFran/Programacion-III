package ejercicio_1;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T>{

	// G=(V, A)
	// A ⊆ VxV 
	private HashMap<Integer, ArrayList<Arco<T>>> vertices;
	
	// Guarda el vertice y la etiqueta
	private HashMap<Integer, T> recorrido;
	
	
	public GrafoDirigido() {
		this.vertices = new HashMap<Integer,ArrayList<Arco<T>>>();
		this.recorrido = new HashMap<Integer, T>();
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

	
}
