package autostradaA20;

public class Casello {
	int tipoCasello;	// Casello ingersso = 1 	Casello Uscita = 0
	char tipoCorsia;	// Corsia ingersso A = A 	Corsia ingersso B = B 	Corsia uscita X = X		Corsia uscita Y = Y
	int nCorsie;
	int corsieLibere = nCorsie;
	String name;
	
	
	
	public Casello(int tipoCasello, int nCorsie, String name) {
		super();
		this.tipoCasello = tipoCasello;
		this.nCorsie = nCorsie;
		this.corsieLibere = nCorsie;
	}

	public synchronized boolean entra(String tipoVeicolo) {
		if(tipoCasello == 1 && tipoVeicolo == "AUTO" ) {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere -- ;
			return true;
		}
		else if(tipoCasello == 1 && tipoVeicolo == "AUTO" ) {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere -- ;
			return true;
		}
		else {
			System.out.println(Thread.currentThread().getName() + " questo è in casello sbagliato, prova dall'altro lato");
			return false;
		}
		
	}

	public synchronized void libera() {
		System.out.println(Thread.currentThread().getName() + " lascia la corsia.");
		corsieLibere ++;
		notifyAll();
		
		
	}

	public synchronized boolean esci(String tipoVeicolo) {
		if(tipoCasello == 0 && tipoVeicolo == "AUTO" ) {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere -- ;
			return true;
		}
		else if(tipoCasello == 0 && tipoVeicolo == "AUTO" ) {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere -- ;
			return true;
		}
		else {
			System.out.println(Thread.currentThread().getName() + " questo è in casello sbagliato, prova dall'altro lato");
			return false;
		}
		
	}

}
