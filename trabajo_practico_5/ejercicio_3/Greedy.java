package ejercicio_3;

import java.util.ArrayList;


public class Greedy {

	/*
	Funcion greedy(conjunto<candidatos> C) { // Inicialmente el conjunto C contiene todos los candidatos
		conjunto<candidatos> S; // Conjunto solución, inicialmente Vacío
		while (!C.vacio() && !solucion(S)) {
			x = seleccionar(C); // determina el mejor candidatos del conjunto a seleccionar
			C.borrar(x);
			if (factible(S,x))
				S.agregar(x);
		}
		if solucion(S)
			return S
		else
			return “No_hay_solucion”;
	}
*/
	
	public Solucion greedy(Actividad actividades) {
		int inicio = actividades.getTiempoComienzo();
		int fin = actividades.getTiempoFinalizacion();
		int[] intervalo = {inicio, fin};
		
		Solucion S = new Solucion();
		
		while(!S.isEmpty() && !solucion(S)) {
			Actividad x = seleccionar(actividades);
			actividades.borrar(x);
			if(factible(S, x)) {
				S.agregar(x);
			}
		}
			if(solucion(S)) {
				return S;
			}else {
				return null;
			}		
	}

	private boolean factible(Solucion s, Actividad x) {
		// TODO Auto-generated method stub
		return false;
	}

	private Actividad seleccionar(Actividad a) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean solucion(Solucion S) {
		// TODO Auto-generated method stub
		return false;
	}

}
