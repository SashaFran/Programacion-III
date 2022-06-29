package trabajos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class EncontrarCaminoDif {


	final private String NOVISITADO = "blanco";
	final private String VISITADOx1 = "amarillo";
	final private String VISITADOX2 = "negro";
	
	private Grafo grafo;
	private Integer verticeOrigen, verticeFinal, verticeActual, verticeDeshabilitado;
	private HashMap<Integer,String> recorrido;
	private HashMap<Integer,Integer> nvlVertices, padres;//agregarlo dentro de la clase vertice
	private LinkedHashSet<Integer> caminoDefinitivo;
	
	public EncontrarCaminoDif (Grafo grafo, Integer verticeOrigen, Integer verticeFinal/*, Integer verticeDeshabilitado*/) {
		this.grafo = grafo;
		this.verticeOrigen = verticeOrigen;
		this.verticeFinal = verticeFinal;
//		this.verticeDeshabilitado = verticeDeshabilitado;
		this.verticeActual = null;
		this.nvlVertices = new HashMap<Integer,Integer>();
		this.padres = new HashMap<Integer,Integer>();
		this.recorrido = new HashMap<Integer,String>();
		this.caminoDefinitivo = new LinkedHashSet<Integer>();
	}
	
	public Iterator<Integer> mayorLongitud (){
		this.caminoDefinitivo = new LinkedHashSet<Integer>();
		this.verticeActual = this.verticeOrigen;
		this.recorrido(verticeActual, new ArrayList<Integer>());
		this.verticeActual = null;
		return this.caminoDefinitivo.iterator();
	}
	 
	private void recorrido(Integer verticeActual, ArrayList<Integer> caminoParcial){
		caminoParcial.add(verticeActual);
		if (verticeActual == this.verticeFinal) {
			if (caminoParcial.size() >= this.caminoDefinitivo.size()) {
				this.caminoDefinitivo = new LinkedHashSet<Integer>(caminoParcial);
			}
		} else {
			Iterable<Integer>adyacentes = (Iterable<Integer>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.grafo.obtenerAdyacentes(verticeActual), 0), false).collect(Collectors.toList());
			for (Integer v : adyacentes) {
				this.recorrido(v, caminoParcial);
				caminoParcial.remove(v);
			}
		}
	}
	
	public Iterator<Integer> lleganAFinal(){
		this.recorrido = new HashMap<Integer,String>(); //blanqueo
		this.grafo.obtenerVertices().forEachRemaining((verticeRecorrido) -> recorrido.put((Integer) verticeRecorrido, NOVISITADO));
		Iterable<Integer>vertices = (Iterable<Integer>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.grafo.obtenerVertices(), 0), false).collect(Collectors.toList());
		this.caminoDefinitivo = new LinkedHashSet<Integer>();
		
//		System.out.println("estado de vertice V: " + recorrido);
		for (Integer v : vertices) {
//			if (!caminoDefinitivo.contains(v) && recorrido.get(v) == NOVISITADO) {
			if (recorrido.get(v) == NOVISITADO) {
				this.recorridoProvicional(v, new ArrayList<Integer>());
			}
		}
		return this.caminoDefinitivo.iterator();
	}
	
	private void recorridoProvicional(Integer verticeActual, ArrayList<Integer> caminoParcial) {
		caminoParcial.add(verticeActual);
		this.recorrido.put(verticeActual, VISITADOx1);
		if (verticeActual == this.verticeFinal) {
			if (caminoParcial.size() >= this.caminoDefinitivo.size()) {
				this.caminoDefinitivo.addAll(caminoParcial);
			}
		} else {
			Iterable<Integer>adyacentes = (Iterable<Integer>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.grafo.obtenerAdyacentes(verticeActual), 0), false).collect(Collectors.toList());
			for (Integer v : adyacentes) {
				if (recorrido.get(v) == NOVISITADO) {
					this.recorridoProvicional(v, caminoParcial);
					caminoParcial.remove(v);
				} else {
					if (caminoDefinitivo.contains(v)) {
						this.caminoDefinitivo.addAll(caminoParcial);
					}
				}
			}
		}
	}
	
	public Iterator<Integer> caminoAlternativo(){
		this.caminoDefinitivo = new LinkedHashSet<Integer>();
		this.verticeActual = this.verticeOrigen;
		this.recorridoAlternativo (verticeActual, new ArrayList<Integer>());
		this.verticeActual = null;
		return this.caminoDefinitivo.iterator();
	}
	
	//TODO: condicion de corte para que no itere por siempre?? (verificar si existen dichos vertices)
	private void recorridoAlternativo (Integer verticeActual , ArrayList<Integer> caminoProvisorio) {
		caminoProvisorio.add(verticeActual);
		if(verticeActual == this.verticeFinal) {
			this.caminoDefinitivo = new LinkedHashSet<Integer>(caminoProvisorio);
			return; //no hay necesidad de seguir, ya encontré uno
		} else {
			Iterable<Integer>vertices = (Iterable<Integer>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.grafo.obtenerAdyacentes(verticeActual), 0), false).collect(Collectors.toList());
			for (Integer v : vertices) {
				if(v != this.verticeDeshabilitado) {
					this.recorridoAlternativo(v, caminoProvisorio);
					caminoProvisorio.remove(v);
				}
			}
		}
	}
	
	private ArrayList<Integer> recorridos(String tipo){ //dfs/bfs
//		HashMap<Integer,Boolean> recorrido = new HashMap<Integer,Boolean>();
		ArrayList<Integer> rta = new ArrayList<Integer>();
		this.grafo.obtenerVertices().forEachRemaining((verticeRecorrido) -> recorrido.put((Integer) verticeRecorrido, NOVISITADO));

		for(Integer i : recorrido.keySet()) {
			if (recorrido.get(i) == NOVISITADO) {
				if (tipo == "bfs") {
					rta.addAll(this.bfs(i));
				} else {
					rta.addAll(this.dfs(i));
				}
				
			}
		}
		return rta;
	}
	
	//verdadero ya paso, falso sin pasar, eliminado volvio a pasar
		private ArrayList<Integer> dfs(Integer verticeActual){
			ArrayList<Integer> resultado = new ArrayList<Integer>();
			resultado.add(verticeActual);
			this.recorrido.put(verticeActual, VISITADOx1); //amarillo
			Iterator<Integer> ady = grafo.obtenerAdyacentes(verticeActual);
			while (ady.hasNext() == true) {
				Integer v = ady.next();
				if (recorrido.containsKey(v)) {
					if(recorrido.get(v) == NOVISITADO) {
						this.dfs(v);
					}
					if(recorrido.get(v) == VISITADOx1) {
						//hay ciclo
					}
				}			
			}
			//color negro
			this.recorrido.put(verticeActual, VISITADOX2);
			return resultado;
		}
		
		//"x2" ya pasó, "novisitado" sin pasar (sólo tiene dos estados)
		private ArrayList<Integer> bfs(Integer verticeOrigen){
			ArrayList<Integer> resultado = new ArrayList<Integer>();
			ArrayList<Integer> aux = new ArrayList<Integer>();
			resultado.add(verticeOrigen);
			this.recorrido.put(verticeOrigen, VISITADOX2);
			aux.add(verticeOrigen);
			while(!aux.isEmpty()) {
				Integer verticeActual = aux.remove(0);
				Iterable<Integer>vertices = (Iterable<Integer>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.grafo.obtenerAdyacentes(verticeActual), 0), false).collect(Collectors.toList());
				for(Integer adyacente : vertices) {
					if (recorrido.get(adyacente) == NOVISITADO) {
						resultado.add(adyacente);
						recorrido.put(adyacente, VISITADOX2);
						aux.add(adyacente);
					}
				}
			}
			return resultado;
		}
		
		//ejercicio calle
		public ArrayList<Integer> obtenerMenorCamino(){
			this.grafo.obtenerVertices().forEachRemaining((verticeRecorrido) -> recorrido.put((Integer) verticeRecorrido, NOVISITADO));
			this.caminoPorNvl(this.verticeOrigen);
			return obtenerCaminoNvl();

		}
		
		//TODO si origen es igual a destino
		//"x2" ya pasó, "novisitado" sin pasar (sólo tiene dos estados)
		private void caminoPorNvl(Integer verticeOrigen){
			ArrayList<Integer> aux = new ArrayList<Integer>();
			int nvl = 0;
			this.recorrido.put(verticeOrigen, VISITADOX2);
			this.nvlVertices.put(verticeOrigen, nvl);
			aux.add(verticeOrigen);
			while(!aux.isEmpty()) {
				nvl ++;
				Integer verticeActual = aux.remove(0);
				Iterable<Integer>vertices = (Iterable<Integer>) StreamSupport.stream(Spliterators.spliteratorUnknownSize(this.grafo.obtenerAdyacentes(verticeActual), 0), false).collect(Collectors.toList());
				for(Integer adyacente : vertices) {
					if (recorrido.get(adyacente) == NOVISITADO) {
						this.nvlVertices.put(adyacente, nvl);
						this.padres.put(adyacente, verticeActual);
						aux.add(adyacente);
						recorrido.put(adyacente, VISITADOX2);
					}
					if (adyacente == this.verticeFinal) {
						return;
					} 
				}
			}
		}
		
		private ArrayList<Integer> obtenerCaminoNvl(){
//			padres.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
			ArrayList<Integer> rta = new ArrayList<Integer>();
			if (padres.containsKey(verticeFinal) && padres.containsValue(verticeOrigen)  ) {
				Integer vertice = this.verticeFinal;
				Integer padre = null;
				while (padre != this.verticeOrigen) {
					rta.add(vertice);
					padre = this.padres.get(vertice);
					vertice = padre;
				}
				rta.add(padre);
			}
			return rta;
		}
}
