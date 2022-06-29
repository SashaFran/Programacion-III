package ejercicio_1;

import java.util.HashMap;

public class GrafoNoDirigido<T> extends GrafoDirigido<T> {

	private HashMap<Integer,Boolean> visitados;
	private HashMap<Integer, Integer> padres;
	
	
	
	public GrafoNoDirigido() {
		this.visitados = new HashMap<Integer,Boolean>();
		this.padres = new HashMap<Integer, Integer>();
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		super.agregarArco(verticeId1, verticeId2, etiqueta);
		super.agregarArco(verticeId2, verticeId1, etiqueta);
	}
	
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		super.borrarArco(verticeId1, verticeId2);
		super.borrarArco(verticeId2, verticeId1);
	}
}
