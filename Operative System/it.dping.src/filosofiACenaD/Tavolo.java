package filosofiACenaD;
//Si immagini che la vita di un filosofo consista di periodi alterni di mangiare e pensare, e che ciascun filosofo abbia bisogno di due 

//forchette per mangiare, ma che le forchette vengano prese una per volta. Dopo essere riuscito a prendere due forchette il filosofo mangia per
//un po', poi lascia le forchette e ricomincia a pensare. Il problema consiste nello sviluppo di un algoritmo che impedisca lo stallo
//(deadlock) o la morte d’inedia (starvation).  SOLUZIONE CON MONITOR USANDO METODI SYNCHRONIZED
//forchetta iesima=i(sinistra) forchetta successiva=(i+1)%5 o (i+4)%5 (destra)

public class Tavolo { // monitor
	private boolean[] forchette = { true, true, true, true, true }; // variabile condivisa
	int priorita[] = { 0, 0, 0, 0, 0 }; // mi serve a garantire la priorità tra processi e a evitare starvation filosofo

	public synchronized boolean prendiForchette(int i) { // passo la prima forchetta che prendo (iesima sinistra)
		while (!forchette[i] || !forchette[(i + 1) % 5] || priorita[i] > priorita[(i + 4) % 5]) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.err.println(Thread.currentThread().getName() + " prende le forchette!");
		forchette[i] = false; // prendo la prima forchetta sx //operazioni atomiche grazie a synchronize
		forchette[(i + 1) % 5] = false; // prendo la seconda (dx);
		return true;
	}

	public synchronized void posaForchette(int i) {
		System.err.println(Thread.currentThread().getName() + " posa le forchette!");
		forchette[i] = true; // prendo la prima forchetta sx //operazioni atomiche grazie a synchronize
		forchette[(i + 1) % 5] = true; // prendo la seconda (dx);
		priorita[i]++; // incremento la priorità di quel filosofo (tengo traccia di quanto mangia)
						// risolvo starvation
		notifyAll();
	}
}