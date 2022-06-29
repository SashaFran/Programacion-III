package ejercicio_3;


public class Solucion_3 {

	public void agregarSolucion(Actividad x) {
		
		while(x.getTiempoComienzo()< x.getTiempoFinalizacion())
			agregarSolucion(x);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
