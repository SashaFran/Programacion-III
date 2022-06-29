package trabajos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {
	
	private HashMap<Integer,ArrayList<Arco<T>>> vertices;
	HashMap<Integer,String> recorrido = new HashMap<Integer,String>();

	public GrafoDirigido() {
		this.vertices = new HashMap<Integer,ArrayList<Arco<T>>>();
	}

	
	@Override
	public void agregarVertice(int verticeId) {
//		Vertice ver = new Vertice(verticeId);
		vertices.put(verticeId, new ArrayList<Arco<T>>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		vertices.forEach((k,v) -> {
//			for(Arco a : v) {
//				if(a.getVerticeDestino() == verticeId) {
					this.borrarArco(k, verticeId);
//				}
//			}
		});
		vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco a = new Arco(verticeId1, verticeId2, etiqueta);
		vertices.get(verticeId1).add(a);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		//si existe (puede no existir) tanto el v1 como el v1 con v2
		ArrayList<Arco<T>> arr = vertices.get(verticeId1);
		if (!arr.isEmpty()) {
			for(Arco a : arr) {
				if(a.getVerticeDestino() == verticeId2 && a.getVerticeOrigen() == verticeId1) {
					arr.remove(a);
				}
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) { 
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arr = vertices.get(verticeId1);
			if (!arr.isEmpty()) {
				for(Arco a : arr) {
					if(a.getVerticeDestino() == verticeId2 && a.getVerticeOrigen() == verticeId1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if(this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arr = vertices.get(verticeId1);
			if (!arr.isEmpty()) {
				for(Arco a : arr) {
					if(a.getVerticeDestino() == verticeId2 && a.getVerticeOrigen() == verticeId1) {
						return a;
					}
				}
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return vertices.size();
	}

	@Override
	public int cantidadArcos() {
		int contador = 0;
		for (ArrayList<Arco<T>> arr : vertices.values()) {
			if (!arr.isEmpty()) {
				contador += arr.size();
			}
		}
		return contador;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		
		// Alternativa con lista de vertices --> O(n)
		/*
		ArrayList<Integer> listaAux = new ArrayList<>();
		for (Vertice<T> v: this.verticesJ)
			listaAux.add(v.getId());
		return listaAux.iterator(); 
		*/
		
//		// O(1)
//		Iterator<Vertice<T>> iteradorInterno = this.verticesJ.iterator(); // O(1)
//		return new IteradorVertice<T>(iteradorInterno);  // O(1)
//		

		// O(1)
		 return this.vertices.keySet().iterator(); 
		
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		//TODO si existe el vertice dado
		ArrayList<Arco<T>> arcosAd = vertices.get(verticeId);
		ArrayList<Integer> adyacentes = new ArrayList<Integer>();
		for (Arco<T> a :arcosAd) {
			if(a != null) {
			adyacentes.add(a.getVerticeDestino());
			}
		}
		return adyacentes.iterator();
	}

	@Override 
	public Iterator<Arco<T>> obtenerArcos() {
		// Aca esta bien hacer un for y crear una lista auxiliar
		ArrayList<Arco<T>> adyacentes = new ArrayList<Arco<T>>();
		for(ArrayList<Arco<T>> arcos: vertices.values()) {
			adyacentes.addAll(arcos);
		}
		return adyacentes.iterator();
	}

	@Override 
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {	
		//TODO si existe el vertice dado
		return vertices.get(verticeId).iterator();
	}
}
