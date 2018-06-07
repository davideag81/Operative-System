package magazzino;
// se non lo hai capito... questo è il monitor
public class WareHouse {
	private int numberOfProduct;
	private int idProduct; // variabile condivisa
	private boolean isEmpty = true; // variabile di controllo
	
	
	public synchronized void put(int idProduct) {
		if (!isEmpty)
			try {
				wait();
			}catch(InterruptedException exc) {
				exc.printStackTrace();
			}

		this.idProduct = idProduct; // accesso alla varibile condivise
		// zona critica
		numberOfProduct++;
		printSituation("Producer" + idProduct);
		isEmpty=false;
		notify();
	}
	
	public synchronized int get() {
		if (isEmpty)
			try {
				wait();
			}catch(InterruptedException exc) {
				exc.printStackTrace();
			}
		// zona critica
		numberOfProduct--; // accesso alla varibile condivise
		printSituation("Producer" + idProduct);	
		isEmpty = true;
		notify();
		return idProduct;
	}
	
public void printSituation(String msg) {
	System.out.println(msg + "\n"
			+ numberOfProduct + " Product in WareHouse");
}
}

