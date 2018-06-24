package Elezioni;

public class Seggio {
	
	int cabineLibere;
	
	public Seggio(int nCabine) {
		super();
		this.cabineLibere = nCabine;
	}

	public synchronized void entra() {
		while(cabineLibere == 0){
			try {
				System.out.println("Tutte le cabine sono occupate, attendi");
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		cabineLibere--;
		System.err.println(Thread.currentThread().getName() + " ha votato!");
	}

	public synchronized boolean esce() {
		cabineLibere++;
		System.out.println(Thread.currentThread().getName() + " esce dal seggio");
		notifyAll();
		return true;	
	}

}
