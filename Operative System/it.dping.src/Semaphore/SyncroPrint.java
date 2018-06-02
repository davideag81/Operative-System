package Semaphore;

import java.util.concurrent.Semaphore;

public class SyncroPrint extends Thread {

	// Semaphore sintax have two variabiles Mapped
	Semaphore semaphore;
	String message;
	
	//Constructor for Semaphore
	public SyncroPrint(Semaphore s, String m) {
		semaphore = s;
		message = m;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " prova acquirente()...");
			semaphore.acquire(); //P(S)
			System.out.println(Thread.currentThread().getName() + " prova sem...");
			
			// -- sezione critica
			
			for ( int i = 1; i<=10; i++) {
				System.out.println(message + " : " + i);
				Thread.sleep(500);
			}
			
			// -- fine sezione critica	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + " released sem...");
		semaphore.release(); // V(S)
	}
	
}