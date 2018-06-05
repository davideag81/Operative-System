package magazzino;

public class WareHouse {
	private int numberOfProduct;
	private int idProduct; // variabile condivisa
	
	public synchronized void put(int idProduct) {
		this.idProduct = idProduct; // accesso alla varibile condivise
		// zona critica
		numberOfProduct++;
		printSituation("Producer" + idProduct);	
	}
	
	public synchronized int get() {
		// zona critica
		numberOfProduct--; // accesso alla varibile condivise
		printSituation("Producer" + idProduct);	
		return idProduct;
	}
	
public void printSituation(String msg) {
	System.out.println(msg + "\n"
			+ numberOfProduct + " Product in WareHouse");
}
}

