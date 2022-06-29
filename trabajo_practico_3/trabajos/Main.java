package trabajos;

import java.util.Iterator;

public class Main {

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
		
		System.out.println("--------------------------------------------------------------------"); 
		System.out.println("Etiquetas:");
		// Arco entre 1 y 2, y le pido la etiqueta
		Float etiqueta1 = g.obtenerArco(1, 2).getEtiqueta();
		Float etiqueta2 = g.obtenerArco(1, 3).getEtiqueta();
		Float etiqueta3 = g.obtenerArco(2, 3).getEtiqueta();
		Float etiqueta4 = g.obtenerArco(3, 4).getEtiqueta();
		
		System.out.println("Etiqueta de 1: " + etiqueta1);
		System.out.println("Etiqueta de 2: " + etiqueta2);
		System.out.println("Etiqueta de 3: " + etiqueta3);
		System.out.println("Etiqueta de 4: " + etiqueta4);
		
		System.out.println("--------------------------------------------------------------------"); 
		
		Iterator<Integer> adyacentes = g.obtenerAdyacentes(1);
		while(adyacentes.hasNext()) {
			int c = adyacentes.next();
			System.out.println("Adyacentes" + c);
		}
		System.out.println("--------------------------------------------------------------------"); 
		System.out.println("Arcos:");
		System.out.println("Cantidad de arcos: " + g.cantidadArcos());

		Iterator<Arco<Float>> obArcos = g.obtenerArcos();
		while(obArcos.hasNext()) { 
			Arco<Float> valor = obArcos.next();
			System.out.println("Vertice: " + valor);
		}
		
		System.out.println("--------------------------------------------------------------------"); 
		System.out.println("Caminos: ");
		EncontrarCaminoDif camino = new EncontrarCaminoDif(g, 1, 5);
		System.out.println("camino largo: ");
		Iterator<Integer> it2 = camino.mayorLongitud();
		while(it2.hasNext()) { 
			int valor = it2.next();
			System.out.print(valor + " ");
		}
		
		System.out.println("\nvertices que llegan: ");
		Iterator<Integer> it3 = camino.lleganAFinal();
		while(it3.hasNext()) { 
			int valor = it3.next();
			System.out.print(valor + " ");
		}
		
		System.out.println("\ncamino alternativo: ");
		Iterator<Integer> it4 = camino.caminoAlternativo();
		while(it4.hasNext()) { 
			int valor = it4.next();
			System.out.print(valor + " ");
		}
		
		//- ----------------------------------------
		System.out.println("\nDFS");
		DFS dfs = new DFS(g);
		dfs.dfs();
	}
	
	

}
