package ejercicio_2;

/*Dado un laberinto consistente en una matriz cuadrada que tiene en cada posición un valor natural
y cuatro valores booleanos, indicando estos últimos si desde esa casilla se puede ir al norte, este,
sur y oeste, encontrar un camino de longitud mínima entre dos casillas dadas, siendo la longitud
de un camino la suma de los valores naturales de las casillas por las que pasa. Idea: podría
representarse el laberinto como una matriz, de objetos, donde cada objeto tiene el valor natural, y
cuatro booleanos, uno para cada dirección a la que se permite ir desde allí.*/

import java.util.ArrayList;
public class Backtracking {

	private Casillero destino;
	private Solucion solucion;

	public void resolver(Casillero inicio, Casillero fin) {
		destino = fin;
		Estado e = new Estado();
		e.setPosActual(inicio);
		back_laberinto(e);
	}

	public void back_laberinto(Estado e){
		if(e.getPosActual() == destino){
			if(solucion == null || solucion.getCosto() > e.getCosto()){
				solucion.agregarCamino(e.getCaminoActual());
				solucion.agregarCosto(e.getCosto());
			}
		}
		else{
			ArrayList<Casillero> vecinos = e.getVecinos();
			for(Casillero c:vecinos){
				if(!e.getCaminoActual().estaVisitado(c)){
					e.agregarCasillero();
					e.marcarVisitado(c);
					e.incrementarCosto(c);
					back_laberinto(e);
					e.eliminarCasillero(c);
					e.desmarcarVisitado(c);
					e.decrementarCosto(c);
				}
			}
		}
	}
}
