package trabajos;
import java.util.Iterator;

public class IteratorAdyacente<T> implements Iterator<Integer> {

	private Iterator<Arco<T>> iterador;
	
	public IteratorAdyacente(Iterator<Arco<T>> iterador) {
		this.iterador = iterador;
	}
	
	@Override
	public boolean hasNext() {
		return iterador.hasNext();
	}

	@Override
	public Integer next() {
		Arco<T> arco = iterador.next();
		return arco.getVerticeDestino();
	}

}
