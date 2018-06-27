package autostradaA20;

public class Casello {
	int tipoCasello; // Casello ingersso = 1 Casello Uscita = 0
	int tipoCorsia; // Corsia ingersso A = 1 Corsia ingersso B = 0 Corsia uscita X = 3 Corsia uscita
					// Y = 2
	int nCorsie;
	int corsieLibere = nCorsie;
	String name;

	public Casello(int tipoCasello, int nCorsie, String name) {
		super();
		this.tipoCasello = tipoCasello;
		this.nCorsie = nCorsie;
		this.corsieLibere = nCorsie;
	}

	public synchronized int entra(String tipoVeicolo) {
		if (tipoVeicolo == "SOCCORSO") {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " HA LA PRIORITA' E PASSA COMUNQUE!");
			corsieLibere--;
			return 1;
		}
		if (tipoCasello == 1 && tipoCorsia == 1) {	// qualunque mezzo
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere--;
			return 1;	//riceve il ticket per il passaggio da A
		} else if (tipoCasello == 1 && tipoCorsia == 0 && tipoVeicolo == "PESANTI") {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere--;
			return 0;
		} else {
			System.out.println(
					Thread.currentThread().getName() + " questo è in casello sbagliato, prova dall'altro lato");
			return 0;
		}

	}

	public synchronized void libera() {
		// implementare controllo tipo casello
		if (this.tipoCasello == 1) {
		System.out.println(Thread.currentThread().getName() + " lascia la corsia.");
		corsieLibere++;
		notify();
		}

	}

	public synchronized boolean liberaUscita() {
		System.out.println(Thread.currentThread().getName() + " lascia la corsia.");
		corsieLibere++;
		notify();
		return true;

	}

	public synchronized boolean esci(String tipoVeicolo, int ticket) {
		if (tipoVeicolo == "SOCCORSO") {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " HA LA PRIORITA' E PASSA COMUNQUE!");
			corsieLibere--;
			return true;
		}
		if (tipoCasello == 0 && tipoCorsia == 1 && ticket == 1) {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere--;
			return true;
		} else if (tipoCasello == 0 && tipoCorsia == 0 && tipoVeicolo == "AUTO") {
			while (corsieLibere == 0) {
				try {
					System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere--;
			return true;
		} else {
			System.out.println(
					Thread.currentThread().getName() + " questo è in casello sbagliato, prova dall'altro lato");
			return false;
		}

	}

}
