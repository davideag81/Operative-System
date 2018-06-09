package ponteSenzoUnico;

import java.util.LinkedList;

public class Ponte {	//monitor
	private int autoOnBridge;
	private boolean isEmpty;
	private Provenienza direzione;
	private LinkedList<Integer> code[] = new LinkedList<>[2]; //vettore di LinkedList
	
	
	public Ponte() {
		super();
		this.autoOnBridge = 0;
		this.isEmpty = true;
		this.direzione = null;
	}
	
	public synchronized void attraversaPonte(Provenienza direzione) {
		System.out.println(Thread.currentThread().getName() + " Sta per attraversare il ponte");
		while (this.isEmpty != true && this.direzione != direzione) { // verifica lo stato del ponte
		try {
			System.out.println("Il Ponte è occupato nella direzione opposta quindi Aspetta...");
			wait();
			
		}catch (InterruptedException exc) {
			exc.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "Sta transitando sul ponte proveniendo da " + direzione);
		++autoOnBridge;
		isEmpty= false;
		notify();
		}
	}
	

	public synchronized void liberaPonte() {
		System.err.println(Thread.currentThread().getName() + " Sta per lasciare il ponte");
		
		try {
			while(this.isEmpty = true)
			wait();
			
		}catch (InterruptedException exc) {
			exc.printStackTrace();
		}
		--onBridge;
		isEmpty= true;
		System.err.println(Thread.currentThread().getName() + " ha lasciato il ponte");
		if (onBridge==0) {
			System.out.println("La corsia del Ponte è libera adesso! può passare la prossima auto");
		notifyAll();
	}
	}
	
}
