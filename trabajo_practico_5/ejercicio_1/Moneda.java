package ejercicio_1;

public class Moneda implements Comparable<Moneda>{


	int value;
	int quantity;
	
	public Moneda(int value, int quantity){
		
		this.value = value;
		this.quantity = quantity;
		
	}
	
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString(){
		return "Value: " + value + " Quantity: " + quantity;  
	}

	@Override
	public int compareTo(Moneda o) {		
		return this.value - o.getValue();		
	}

	public void increaseQuantity() {
		this.quantity++;
	}
}
