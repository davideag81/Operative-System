package filosofiACenaD;

import java.util.Random;

class Filosofo extends Thread {

	private int id;
	private Tavolo tavolo;
	Random rand = new Random();

	public Filosofo(Tavolo tavolo, int id, String name) {
		super(name);
		this.tavolo = tavolo;
		this.id = id;
		this.start();
	}

	public void pensa() {
		try {
			int num = rand.nextInt(3001);
			sleep(num);
			System.err.println(getName() + " ha pensato per " + num + " millisecondi.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void mangia() {
		try {
			int num = rand.nextInt(3001);
			sleep(num);
			System.err.println(getName() + " ha mangiato " + num + " millisecondi.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// il filosofo prima pensa e poi mangia
	public void run() { // qui sono contenute tutte le azioni
		/*
		 * Appunto: Ogni filosofo aspetta che tutti gli altri finiscano prima di passare
		 * alla seconda portata.
		 */
		while (true) {
			pensa();
			tavolo.prendiForchette(this.id);
			mangia();
			tavolo.posaForchette(this.id);
		}
	}
}
