package ejercicio_3;

import java.util.ArrayList;

public class Actividad {

	private SalaConferencia sala;
	private int tiempoComienzo;
	private int tiempoFinalizacion;
	private ArrayList<Integer> intervalos;
	
	
	public Actividad(int inicio, int fin) {
		this.sala = new SalaConferencia();
		this.tiempoComienzo = tiempoComienzo;
		this.tiempoFinalizacion = tiempoFinalizacion;
		this.intervalos = new ArrayList<>();
	}
	
	public SalaConferencia getSala() {
		return sala;
	}
	
	public void setSala(SalaConferencia sala) {
		this.sala = sala;
	}
	
	public int getTiempoComienzo() {
		return tiempoComienzo;
	}
	
	public void setTiempoComienzo(int tiempoComienzo) {
		this.tiempoComienzo = tiempoComienzo;
	}
	
	public int getTiempoFinalizacion() {
		return tiempoFinalizacion;
	}
	
	public void setTiempoFinalizacion(int tiempoFinalizacion) {
		this.tiempoFinalizacion = tiempoFinalizacion;
	}
	
	public void setIntervalos(ArrayList<Integer> intervalos) {
		this.intervalos = intervalos;
	}

	public void borrar(Actividad x) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
