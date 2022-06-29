package ejercicio_6;

/*Caballo de Atila. Por donde pisa el caballo de Atila jamás vuelve a crecer el pasto. El caballo fue
directamente hacia el jardín de n x n casillas. Empezó su paseo por una casilla cualquiera y volvió
a ella, es decir hizo un recorrido cerrado. No visitó dos veces una misma casilla, se movió de una
casilla a otra vecina en forma horizontal o vertical, pero nunca en diagonal. Por donde pisó el
caballo, el pasto jamás volvió a crecer. Luego de terminado el recorrido en algunas casillas
todavía había pasto (señal de que en ellas no había estado el caballo). Escriba un algoritmo que
deduzca el recorrido completo que hizo el caballo.*/

public class Backtracking {

	public void Atila (Estado e, int nroPisada) { 
		e.marcar(nroPisada); 
		if (!e.HayMovimientos() ) { 
			if(nroPisada== e.cantPisadas() && e.vecinaOrigen()) {
				imprimirSolucion(e); 
			} else { 
				Estado sgte = null; 
				int nrohijo=1; 
				while (hijos(nrohijo, e, sgte)) { 
					if (sgte.esFactible() ) 
						Atila(sgte, nroPisada+1); 
						nrohijo++; 
					} 
				} 
		}
}

	private boolean hijos(int nrohijo, Estado e, Estado sgte) {
		// TODO Auto-generated method stub
		return false;
	}

	private void imprimirSolucion(Estado e) {
		// TODO Auto-generated method stub
		
	}
}
