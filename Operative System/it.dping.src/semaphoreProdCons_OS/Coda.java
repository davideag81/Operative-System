package semaphoreProdCons_OS;
import java.util.concurrent.Semaphore;

public class Coda {
	static Semaphore semProduttore = new Semaphore(1);
	static Semaphore semConsumatore = new Semaphore(0);
	
	int value;
	
	public Coda() {
		
	}
	
	public void put(int value) {
		try {
			semProduttore.acquire();	//entra sezione critica
			this.value = value;
			System.out.println("Il produttore dcrive " + value);
			semConsumatore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void get() {
		try {
			semConsumatore.acquire();
			
		}
	}
}
