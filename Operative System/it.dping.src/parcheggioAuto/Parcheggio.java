package parcheggioAuto;

public class Parcheggio {
	int postiLiberi;	// variabile condivisa

	public Parcheggio(int postiLiberi) {
		super();
		this.postiLiberi = postiLiberi;
	}

	public synchronized void parcheggia() {		//metodo synchro set
		while(postiLiberi == 0) {
			try {
				System.out.println("Tutti i posti sono occupati. Aspetta...");
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Ha parcheggiato");
		postiLiberi--;

	}

	public synchronized void esce() {		//metodo synchro get
		postiLiberi++;
		notifyAll();
		System.out.println(Thread.currentThread().getName() + " Ha lasciato il parcheggio.");
	}
}
