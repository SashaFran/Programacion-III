package empleado;

public class Empleado implements Comparable<Empleado>{

	private String id;
	private String nombre;
	private String apellido;
	private int edad;
	private int fuerzaTrabajo;

	
	//CONSTRUCTOR

	public Empleado(String id, String nombre, String apellido, int edad, int fuerzaTrabajo) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fuerzaTrabajo = fuerzaTrabajo;
	}

	
	//METHODS
	
	
	//GETTERS
	
	
	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public int getEdad() {
		return edad;
	}


	public int getFuerzaTrabajo() {
		return fuerzaTrabajo;
	}
	
	
	//OVERRIDES
	//Implementado para usar el sort descendentemente
	@Override
    public int compareTo(Empleado emp) {
    	
        int resultado = 0;
        
        if (this.fuerzaTrabajo < emp.getFuerzaTrabajo())
        	resultado = 1;
        else if (this.fuerzaTrabajo > emp.getFuerzaTrabajo())
        	resultado = -1;
        
        return resultado;
    }
	
	@Override
	public String toString(){
		return this.getId() + " - " + this.getNombre() + " " + this.getApellido();
	}
	
	@Override
	public boolean equals(Object obj) {
	
		try {
			
			Empleado empleado = (Empleado) obj;
			
			return this.getId() == empleado.getId();
			
		}
		catch(Exception e){
			
			return false;
			
		}
	
	}
}
