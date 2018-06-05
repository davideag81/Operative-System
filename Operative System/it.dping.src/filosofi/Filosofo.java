package filosofi;

public class Filosofo extends Thread{
	private int numForchette;
	private int statoForchette[];
	private int id;	// identificativo del Thread
	private Tavolo tavolo; // monitor
	
	// variabili di controllo
	private int mangia = 1; 
	private int pensa = 1;
	
	// costruttore Thread
	public Filosofo(int id, Tavolo tavolo) {
		this.id = id;
		this.tavolo = tavolo;
	}
	
	
	
	public Filosofo(int id, Forchette forchette) {
		super();
		statoForchette = new int[numForchette];
		this.id = id;
	}



	// implementazione dei metodi comportamentali
	public void mangia() {
		try {
		Thread.sleep(Math.round(Math.random()*mangia*1000));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Il filosofo "+id +" ha finito di mangiare");
		
	}
	
	public void pensa() {
		try {
		Thread.sleep(Math.round(Math.random()*pensa*1001));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.err.println("Il filosofo "+id +" ha finito di pensare");
		
	}
	
	// il filosofo entra nel monitor
	public void prendi() {
	     //tavolo.prendiForchette(id);	
		
	}
	
	//il filosofo esce dal monitor
	public void lascia(){
	 		
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
			while(true) {
				prendi();
				mangia();
				lascia();
				pensa();
			}
	}

	
}
