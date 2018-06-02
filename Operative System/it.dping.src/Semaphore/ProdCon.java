package Semaphore;
import java.util.concurrent.Semaphore;

public class ProdCon {
	public static void main(String[] args) {
		Coda q = new Coda();

		Consumer consumer = new Consumer(q);
		Producer producer = new Producer(q);

	}
}

class Producer extends Thread {

	Coda queue;

	public Producer(Coda q) {
		this.queue = q;
		this.setName("Thread prodotto P1");
		this.start();
	}

	public void run() {
		for (int i=1; i<=5; i++) {
			queue.put(i);
		}
	}
}


class Consumer extends Thread {

	Coda queue;

	public Consumer(Coda q) {
		this.queue = q;
		this.setName("Thread Consumatore C");
		this.start();
	}

	public void run() {
		for (int i=1; i<=5; i++) {
			queue.get();
		}
	}
}

class Coda {
	
	static Semaphore semProducer = new Semaphore(1);
	static Semaphore semConsumer = new Semaphore(0);
	
	int value;
	
	void put(int n) {
		try {
			
			semProducer.acquire();
			// -- sezione critica
			this.value = n;
			System.out.println("Producer -> " + value);
			// -- fine sezione critica
			semConsumer.release();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	void get() {
		
		try {
			
			semConsumer.acquire();
			// -- sezione critica
			System.out.println("-- Consumer <-  " + value);
			// -- fine sezione critica
			semProducer.release();
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}














