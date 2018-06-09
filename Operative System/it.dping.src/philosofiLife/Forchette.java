package philosofiLife;

public class Forchette {

	private int nForks; // variabile di controllo
	private int [] statoForks;
	
	// costruttore del monitor passo la variabile di controllo
	public Forchette(int nForks) {
		super();
		this.nForks = nForks;
		this.statoForks = new int [nForks];
	}
	
	public synchronized void prendiForchette(int idFilosofo) {
		int forkSx, forkDx;
		
		forkSx = idFilosofo; // forchetta alla sua sinistra
		forkDx = (idFilosofo+1)%5; // forchetta successiva in un set da 5
		
		System.out.println(Thread.currentThread().getName() + " sta cercando di prendere le forchette "
				+ forkDx+ " e " +forkSx);
		// viengono impostate le condizioni che evita il deadLock e lo StarVation
		while(statoForks[forkSx] != idFilosofo && statoForks[forkSx] != idFilosofo) {
			if(statoForks [forkSx] != -1) { //forchetta non disponibile
				try {
					System.out.println(Thread.currentThread().getName() + " aspetta poichè ci sono " + statoForks[forkSx]+" forchette disponibili");
					// il filosofo deve aspettare dato che non ha forchetta sx
					wait();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
			
	}
	
	public synchronized void lasciaForchette(int idFilosofo) {
		
	}
	
}
