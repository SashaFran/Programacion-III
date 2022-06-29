package ejercicio_6;

public class Campo {

	private int x, y;
	
	public Campo(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "fila :" + y+ " columna: "+x;
	}
}
