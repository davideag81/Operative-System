package autostradaA20;

import java.util.Arrays;
import java.util.LinkedList;

public class Casello {
	LinkedList<Integer> coda = new LinkedList<>();
	int tipoCasello; // Casello ingersso = 1 Casello Uscita = 0
	int tipoCorsia; // Corsia ingersso A = 1 Corsia ingersso B = 0 Corsia uscita X = 3 Corsia uscita
					// Y = 2
	int priorita[] = { 0, 0 };
	int nCorsie = 2;
	int corsieLibere = nCorsie;
	String name;

	public Casello(int tipoCasello, int nCorsie, String name) {
		super();
		this.tipoCasello = tipoCasello;
		this.nCorsie = nCorsie;
		this.corsieLibere = nCorsie;

	}

	public synchronized void mettiInCoda(String tipoVeicolo, int veicolo) {

		if (tipoVeicolo == "SOCCORSO") {

			System.out.println(Thread.currentThread().getName() + " HA LA PRIORITA' E PASSA COMUNQUE!");
			coda.addFirst(veicolo);
		} else {
			coda.add(veicolo);
		}
	}

	public synchronized boolean entra(String tipoVeicolo, int veicolo) { // soccorso passa senza controlli da qualunque
																			// casello
		if (tipoCasello == 1 && tipoCorsia == 1) {
			while (corsieLibere == 0 || veicolo != coda.getFirst()) {
				try {
					//System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere--;
			return true;
		}

		else if (tipoCasello == 1 && tipoCorsia == 0) { // mezzo pesante
			while (corsieLibere == 0 || veicolo != coda.getFirst()) {
				try {
					//System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere--;
			return true; // riceve il ticket per il passaggio da A
		} else if (tipoCasello == 1 && tipoCorsia == 0 && tipoVeicolo == "PESANTI")

		{
			while (corsieLibere == 0 || veicolo != coda.getFirst()) {
				try {
					//System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			corsieLibere--;
			return false;
		} else {
			// System.out.println(
			// Thread.currentThread().getName() + " questo è in casello sbagliato, prova
			// dall'altro lato");
			return false;
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

	public synchronized boolean esci(String tipoVeicolo, boolean ticket) {
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
		if (tipoCasello == 0 && tipoCorsia == 1 && ticket == true) {
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
			// System.out.println(
			// Thread.currentThread().getName() + " questo è in casello sbagliato, prova
			// dall'altro lato");
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Casello [tipoCasello=" + tipoCasello + ", tipoCorsia=" + tipoCorsia + ", priorita="
				+ Arrays.toString(priorita) + ", nCorsie=" + nCorsie + ", corsieLibere=" + corsieLibere + ", name="
				+ name + "]";
	}

}
