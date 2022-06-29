package ejercicio_1;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// Creo un grafo dirigdo donde las etiquetas de los arcos son valores Float
		/*
		 * GrafoDirigido<Float> g = new GrafoDirigido<>();
		 * 
		 * // Agrego los vertices 1 y 2 g.agregarVertice(1); g.agregarVertice(2);
		 * g.agregarVertice(3); g.agregarVertice(4); g.agregarVertice(5);
		 * 
		 * System.out.println(
		 * "--------------------------------------------------------------------");
		 * System.out.println("Vertices: "); int cant = g.cantidadVertices();
		 * System.out.println("Cantidad de vertices: " + cant);
		 * 
		 * Iterator<Integer> it = g.obtenerVertices(); while(it.hasNext()) { int valor =
		 * it.next(); System.out.println("Vertice: " + valor); }
		 * 
		 * g.agregarArco(1, 2, 1F); g.agregarArco(1, 3, 2F); g.agregarArco(2, 3, 3F);
		 * g.agregarArco(3, 4, 4F); g.agregarArco(3, 5, 5F); g.agregarArco(5, 2, 6F);
		 * 
		 * System.out.println(
		 * "--------------------------------------------------------------------");
		 * System.out.println("Etiquetas:"); // Arco entre 1 y 2, y le pido la etiqueta
		 * Float etiqueta1 = g.obtenerArco(1, 2).getEtiqueta(); Float etiqueta2 =
		 * g.obtenerArco(1, 3).getEtiqueta(); Float etiqueta3 = g.obtenerArco(2,
		 * 3).getEtiqueta(); Float etiqueta4 = g.obtenerArco(3, 4).getEtiqueta();
		 * 
		 * System.out.println("Etiqueta de 1: " + etiqueta1);
		 * System.out.println("Etiqueta de 2: " + etiqueta2);
		 * System.out.println("Etiqueta de 3: " + etiqueta3);
		 * System.out.println("Etiqueta de 4: " + etiqueta4);
		 * 
		 * System.out.println(
		 * "--------------------------------------------------------------------");
		 * 
		 * Iterator<Integer> adyacentes = g.obtenerAdyacentes(1);
		 * while(adyacentes.hasNext()) { int c = adyacentes.next();
		 * System.out.println("Adyacentes" + c); } System.out.println(
		 * "--------------------------------------------------------------------");
		 * System.out.println("Arcos:"); System.out.println("Cantidad de arcos: " +
		 * g.cantidadArcos());
		 * 
		 * Iterator<Arco<Float>> obArcos = g.obtenerArcos(); while(obArcos.hasNext()) {
		 * Arco<Float> valor = obArcos.next(); System.out.println("Vertice: " + valor);
		 * }
		 */
				
				GrafoNoDirigido<String> grafo = new GrafoNoDirigido();
				grafo.agregarVertice(1);
				grafo.agregarVertice(2);
				grafo.agregarVertice(3);
				grafo.agregarVertice(4);
				grafo.agregarVertice(5);
				grafo.agregarVertice(6);
				grafo.agregarVertice(7);
				
				grafo.agregarArco(1, 2, "FF");
				grafo.agregarArco(2, 3, "F2");
				grafo.agregarArco(1, 3, "FF");
				grafo.agregarArco(2, 4, "FF");
				grafo.agregarArco(3, 7, "F2");
				grafo.agregarArco(7, 4, "FF");
				grafo.agregarArco(4, 5, "F2");
				grafo.agregarArco(2, 6, "FF");
				grafo.agregarArco(5, 6, "F2");
				
				System.out.println("--------------------------------------------------------------------"); 
				System.out.println("Vertices grafo no dirigido: ");
				int cant1 = grafo.cantidadVertices();
				System.out.println("Cantidad de vertices grafo no dirigido: " + cant1);
				
				Iterator<Integer> it2 = grafo.obtenerVertices();
				while(it2.hasNext()) { 
					int valor = it2.next();
					System.out.println("Vertice grafo no dirigido: " + valor);
				}
				
				CaminoCorto c = new CaminoCorto(grafo);
				ArrayList<Integer> it3 = c.caminoCortoevitarVertice(1, 6, 3);
				System.out.print(it3);
				
				
				System.out.println("Camino: " + c.bfsVisit(1, 7));
				System.out.println();
			}

}
