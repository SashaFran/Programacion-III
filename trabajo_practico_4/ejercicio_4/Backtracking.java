package ejercicio_4;

public class Backtracking {

	private Solucion solucion;
	private Conjunto conjunto;

	  public void resolver(Conjunto c) {
	    this.conjunto = c;
	    Estado e = new Estado();
	    e.agregarOrigen();
	    back_conjunto(e);
	  }

	  // Estado contiene el conjunto de numeros y 2 subconjuntos
	  public Boolean back_conjunto(Estado e) {
	    if (e.getConjuntoNumeros() == 0) {
	      if (e.sumaIgualSubconjuntos()) {
	        this.solucion.setConjunto1(e.getConjunto1());
	        this.solucion.setConjunto2(e.getConjunto2());
	        return true;
	      }
	    } else {
	      Integer numero = e.getProximoNumero(); // Retorna el primer numero y lo borra del conjunto
	      for (Conjunto c : e.getSubconjuntos()) {
	        if (!e.poda(numero)) { // Hace....
	          c.agregar(numero);
	          boolean resultado = back_conjunto(e);
	          if (resultado)
	            return true;
	          	c.eliminar(numero);
	        }
	      }
	    }
		return null;
	  }
}
