package semaphoreRun;

import java.util.concurrent.Semaphore;

public class Incrocio {

	Semaphore semaforo = new Semaphore(1);
	
	public void rispettaSemaforo() {
		try {
			semaforo.acquire();
			System.out.println(Thread.currentThread().getName() 
					+ " sta superando l'incrocio");
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			System.out.println(Thread.currentThread().getName() + " ha superato l'incrocio");
		}
	}
}
