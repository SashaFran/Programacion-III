package ejercicio_2;

import java.util.ArrayList;

public class Estado {


	private Casillero posActual;
	private Camino caminoActual;
	private int costo;

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public Camino getCaminoActual() {
		return caminoActual;
	}

	public void setCaminoActual(Camino caminoActual) {
		this.caminoActual = caminoActual;
	}

	public Casillero getPosActual() {
		return posActual;
	}

	public void setPosActual(Casillero posActual) {
		this.posActual = posActual;
	}

	public void incrementarCosto(Casillero c) {

	}

	public void decrementarCosto(Casillero c) {
		// TODO Auto-generated method stub

	}

	public boolean estaVisitado(Casillero vecino) {
		// TODO Auto-generated method stub
		return false;
	}

	public void marcarVisitado(Casillero vecino) {
		// TODO Auto-generated method stub

	}

	public void desmarcarVisitado(Casillero vecino) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Casillero> getVecinos() {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarCasillero() {
		// TODO Auto-generated method stub
		
	}

	public void eliminarCasillero(Casillero c) {
		// TODO Auto-generated method stub
		
	}
}
