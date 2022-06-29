package empleado;

import java.util.ArrayList;

public class Solucion {

	private ArrayList<Empleado> grupo1;
	private ArrayList<Empleado> grupo2;
	private int totalAcumuladoGrupo1;
	private int totalAcumuladoGrupo2;
	
	
	//CONSTRUCTOR
	
	protected Solucion() {
		this.grupo1 = new ArrayList<Empleado>();
		this.grupo2 = new ArrayList<Empleado>();
		this.totalAcumuladoGrupo1 = 0;
		this.totalAcumuladoGrupo2 = 0;
	}
	
	protected Solucion(Solucion solucionParcial) {
		
		this.grupo1 = solucionParcial.getGrupo1();
		this.grupo2 = solucionParcial.getGrupo2();
		this.totalAcumuladoGrupo1 = solucionParcial.getTotalAcumuladoGrupo1();
		this.totalAcumuladoGrupo2 = solucionParcial.getTotalAcumuladoGrupo2();
		
	}
	
	//METHODS

	protected void agregarGreedy(Empleado empleado) {
		if(this.totalAcumuladoGrupo1 <= this.totalAcumuladoGrupo2){
			this.addGrupo1(empleado);
		}
		else{
			this.addGrupo2(empleado);
		}

	}
	
	protected void agregarBacktracking(Empleado empleado, String grupo) {
		if(grupo == "Grupo 1"){
			this.addGrupo1(empleado);
		}
		else{
			this.addGrupo2(empleado);
		}

	}
	
	protected void quitarBacktracking(Empleado empleado, String grupo) {
		
		if(grupo == "Grupo 1"){
			this.removeGrupo1(empleado);
		}
		else{
			this.removeGrupo2(empleado);
		}
		
	}
	
	private void removeGrupo1(Empleado emp) {
		this.totalAcumuladoGrupo1 -= emp.getFuerzaTrabajo();
		this.grupo1.remove(emp);
	}
	
	private void removeGrupo2(Empleado emp) {
		this.totalAcumuladoGrupo2 -= emp.getFuerzaTrabajo();
		this.grupo2.remove(emp);
	}


	private void addGrupo1(Empleado emp){
		this.grupo1.add(emp);
		this.totalAcumuladoGrupo1 += emp.getFuerzaTrabajo();
	}
	
	private void addGrupo2(Empleado emp){
		this.grupo2.add(emp);
		this.totalAcumuladoGrupo2 += emp.getFuerzaTrabajo();
	}

	public int getDiferenciaFuerzaTotalGrupos() {
		
		//Actualizo por el módulo de la diferencia entre las fuerzas totales acumuladas de los grupos.
		return Math.abs(this.totalAcumuladoGrupo1 - this.totalAcumuladoGrupo2);
	}

	//GETTERS & SETTERS
	
	public ArrayList<Empleado> getGrupo1() {
		return  new ArrayList<Empleado>(grupo1);
	}


	public ArrayList<Empleado> getGrupo2() {
		return new ArrayList<Empleado>(grupo2);
	}


	public int getTotalAcumuladoGrupo1() {
		return totalAcumuladoGrupo1;
	}


	public int getTotalAcumuladoGrupo2() {
		return totalAcumuladoGrupo2;
	}


}
