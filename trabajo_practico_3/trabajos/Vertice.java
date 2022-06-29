package trabajos;
import java.util.ArrayList;

public class Vertice<T> {

	private int id;
	private ArrayList<Arco<T>> arcos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Arco<T>> getArcos() {
		return arcos;
	}
	public void setArcos(ArrayList<Arco<T>> arcos) {
		this.arcos = arcos;
	}
	
}
