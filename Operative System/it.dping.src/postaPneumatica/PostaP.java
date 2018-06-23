package postaPneumatica;

import java.util.concurrent.Semaphore;

public class PostaP {
	static Semaphore semaforoProduttore = new Semaphore(1);
	static Semaphore semaforoConsumatore = new Semaphore(0);
	int value;
	
	public void send(int n) {
		try {
			semaforoProduttore.acquire();
			this.value = n;
			System.out.println("Il "+Thread.currentThread().getName() +" sta inviando una capsula con ID "+value);
			semaforoConsumatore.release();
			System.out.println("Tutti gli altri devono aspettare... ");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void recive() {
		try {
			semaforoConsumatore.acquire();
			System.out.println("Il "+Thread.currentThread().getName() +" sta ricevendo la capsula con ID "+value);
			semaforoProduttore.release();
			System.out.println("Tutti gli altri devono aspettare... ");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
