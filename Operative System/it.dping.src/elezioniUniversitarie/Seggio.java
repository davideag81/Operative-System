package elezioniUniversitarie;

import java.util.LinkedList;

public class Seggio {
	String name;
	private final static int MaxCoda = 25;
	int cabineLibere; // var condition
	Campus campus;
	private LinkedList<Integer> codaSeggio = new LinkedList<>();

	public Seggio(String name, int cabine) {
		this.name = name;
		this.cabineLibere = cabine;
	}

	public synchronized boolean mettinInLista(int idVotante) {

		while (codaSeggio.size() > MaxCoda) {
			System.out.println("Coda Piena. Recarisi in un altro seggio!");
			return false;
		}
		codaSeggio.addFirst(idVotante);
		System.out.println("La commissione di seggio consegna il token e l'utente attende una cabina libera.!");
		return true;
	}

	public synchronized void entra(int idVotante) {
		while (cabineLibere == 0) {
			try {
				System.out.println("Tutte le cabine sono occupate. Aspetta!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cabineLibere--;
		codaSeggio.removeFirst();
		System.out.println(Thread.currentThread().getName() + " entra in cabina.");
	}

	public synchronized boolean esce() {
		cabineLibere++;
		System.out.println(Thread.currentThread().getName() + " esce dalla cabina e dal seggio.");
		notifyAll();
		return true;
	}

	public void stampaCoda() {
		System.out.println("Coda al seggio #" + name + "\n");
		for (int tmp : codaSeggio) {
			System.out.println("Votante #" + tmp + ".\n");
		}
	}
}