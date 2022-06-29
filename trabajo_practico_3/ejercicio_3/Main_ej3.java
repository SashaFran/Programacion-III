package ejercicio_3;

import java.util.Iterator;

public class Main_ej3 {

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

				Iterator<Integer> it2 = g.obtenerVertices();
				while(it2.hasNext()) { 
					int valor = it2.next();
					System.out.println("Vertice grafo no dirigido: " + valor);
				}
				
				Float etiqueta11 = g.obtenerArco(1, 2).getEtiqueta();
				Float etiqueta31 = g.obtenerArco(2, 3).getEtiqueta();
				
				System.out.println("Etiqueta de 1: " + etiqueta11);
				System.out.println("Etiqueta de 2: " + etiqueta31);

			}

}
