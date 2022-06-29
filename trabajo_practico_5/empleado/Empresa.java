package empleado;

import java.util.ArrayList;
import java.util.Collections;

public class Empresa {

	private Solucion mejorSolucion;
	private static int contador;
	
	public Solucion backtracking(ArrayList<Empleado> empleados){
		
		contador = 0;
		
		this.mejorSolucion = null;
		int posicion = 0;
		Solucion solucionParcial = new Solucion();   //Creo la solución
		this.backTracking(empleados, posicion, solucionParcial/*, "Grupo 1"*/);
		
		return this.mejorSolucion;
	}
	
	
	private void backTracking(ArrayList<Empleado> empleados, int posicion, Solucion solucionParcial/*, String grupo*/) {
		
		contador++;
		
		if(es_estado_final(empleados, posicion/*, grupo*/)) {
			
			if(es_solucion(empleados, posicion, solucionParcial)) {
				operar_solucion(solucionParcial);
			}
			
		}
		else{
			//Obtengo el empleado de este estado
			Empleado empleado = empleados.get(posicion);
			
			//Tomo la decisión de agregarlo al Grupo 1
			agregar_solucion(empleado, "Grupo 1", solucionParcial);
			this.backTracking(empleados, posicion + 1, solucionParcial/*, "Grupo 1"*/);
			quitar_solucion(empleado, "Grupo 1", solucionParcial);
			
			//Tomo la decisión de agregarlo al Grupo 2
			agregar_solucion(empleado, "Grupo 2", solucionParcial);
			this.backTracking(empleados, posicion /*-+ 1+*/+1, solucionParcial/*, "Grupo 2"*/);
			quitar_solucion(empleado, "Grupo 2", solucionParcial);
			
		}
	}

	private void quitar_solucion(Empleado empleado, String grupo, Solucion solucionParcial) {
		
		solucionParcial.quitarBacktracking(empleado, grupo);
		
	}


	//Agrego el empleado al grupo correspondiente.
	private void agregar_solucion(Empleado empleado, String grupo, Solucion solucionParcial) {
		
		solucionParcial.agregarBacktracking(empleado, grupo);
		
	}


	//Actualizo la solución final por una mejor solución que fue encontrada.
	private void operar_solucion(Solucion solucionParcial) {

		this.mejorSolucion = new Solucion(solucionParcial);

	}

	//Es solución si mi solucion parcial es mejor que mi mejor solución
	private boolean es_solucion(ArrayList<Empleado> empleados, int posicion, Solucion solucionParcial) {
		
		if(mejorSolucion != null)
			return solucionParcial.getDiferenciaFuerzaTotalGrupos() < mejorSolucion.getDiferenciaFuerzaTotalGrupos();
		
		else	//estoy en el estado inicial
			return true;
		
	}

	//Es estado final si ya no me quedan decisiones por tomar.
	private boolean es_estado_final(ArrayList<Empleado> empleados, int posicion/*, String grupo*/) {
		
		//if(grupo == "Grupo 1")
			return posicion == empleados.size();
		
		//else
			//return posicion == 0;
	}


	//---------------------------------------- GREEDY ----------------------------------------
	
	/*En esta solución greedy siempre se agrega a un empleado al grupo donde la suma de fuerzas
	* acumulada sea menor. Por lo tanto, siempre se elije, se agrega a la solución general
	* (alguno de los grupos) o se elimina del conjunto de candidatos de entrada. */
	
	public Solucion greedy(ArrayList<Empleado> empleados){
		
		contador = 0;
		
		Solucion solucion = new Solucion();   //Creo la solución
		
		Collections.sort(empleados);	//Ordeno descendentemente por fuerza de trabajo a los empleados
		
		while (!empleados.isEmpty()) {
		 Empleado empleado = seleccionar(empleados);  //selecciono a un candidato
		 this.borrar(empleados);  //el empleado seleccionado ya no es candidato
		 solucion.agregarGreedy(empleado);  //lo agrego a la solución
		}
		return solucion;
	}

	//Retorna el primer empleado del conjunto.
	private Empleado seleccionar(ArrayList<Empleado> empleados) {
		
		contador++;
		
		return empleados.get(0);
		
	}
	
	//Borra al empleado seleccionado del conjunto de candidatos.
	private void borrar(ArrayList<Empleado> empleados) {
		
		empleados.remove(0);
		
	}


	//GETTERS
	
	public static int getContador() {
		return contador;
	}
}
