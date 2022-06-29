package ejercicio_4;

import java.util.Iterator;

/*Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que
el grafo de entrada es acíclico*/

public class Main_ej4 {

	public static void main(String[] args) {
		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
				GrafoDirigido<Float> g = new GrafoDirigido<>();
				
				// Agrego los vertices 1 y 2
				g.agregarVertice(1);
				g.agregarVertice(2);
				g.agregarVertice(3);
				g.agregarVertice(4);
				g.agregarVertice(5);
				
				System.out.println("--------------------------------------------------------------------"); 
				System.out.println("Vertices: ");
				int cant = g.cantidadVertices();
				System.out.println("Cantidad de vertices: " + cant);
				
				Iterator<Integer> it = g.obtenerVertices();
				while(it.hasNext()) { 
					int valor = it.next();
					System.out.println("Vertice: " + valor);
				}
				
				g.agregarArco(1, 2, 1F);
				g.agregarArco(1, 3, 2F);
				g.agregarArco(2, 3, 3F);
				g.agregarArco(3, 4, 4F);
				g.agregarArco(3, 5, 5F);
				g.agregarArco(5, 2, 6F);

				
				CaminoSimple camino = new CaminoSimple(g, 1, 5);
				
				System.out.println("Camino: " + camino.DFS());
			}

}
