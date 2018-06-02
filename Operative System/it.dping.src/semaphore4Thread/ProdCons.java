package semaphore4Thread;
/*Modificare l’esempio del produttore – consumatore con i semafori, supponendo che vi possano essere più thread
 *  che scrivono contemporaneamente su un array condiviso. Successivamente espandere il tutto al caso di più 
 *  consumatori, in cui ogni consumatore consuma un valore in modo univoco (lo stesso valore può essere letto
 *  da un solo consumatore). */
 
import java.util.concurrent.Semaphore;
import java.util.NoSuchElementException;

public class ProdCons{
	
	public static void main(String args[]){
		Coda q = new Coda(3);
		int numeroProduttori = 10;
		int numeroConsumatori = 10;
		int valoriDaProdurre = 10;
		Producer[] produttori = new Producer[numeroProduttori];
		Consumer[] consumatori = new Consumer[numeroConsumatori];
		
		for(int i = 0; i < numeroProduttori; i++){
			produttori[i] = new Producer(q, "Thread produttore P" + (i+1),valoriDaProdurre);
			produttori[i].start();
		}
		for(int i = 0; i < numeroConsumatori; i++){
			consumatori[i] = new Consumer(q, "Thread consumatore C" + (i+1),valoriDaProdurre);
			consumatori[i].start();
		}
		try{
			for(int i = 0; i < produttori.length; i++){
				produttori[i].join();
			}
			for(int i = 0; i < consumatori.length; i++){
				consumatori[i].join();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	
	}
}

class Producer extends Thread{
	private Coda queue;
	private int valoriProdotti;
	private int valoriDaProdurre;
	
	public Producer(Coda q, String name, int valoriDaProdurre){
		this.queue = q;
		this.setName(name);
		this.valoriProdotti = 0;
		this.valoriDaProdurre = valoriDaProdurre;
	}
	
	@Override
	public void run(){
		try{
			while(valoriDaProdurre > 0){
			this.queue.put();
			this.valoriProdotti++;
			this.valoriDaProdurre--;
			}
		}catch(NoSuchElementException e){
			System.out.println("Qualcosa e' andato storto con " + this.getName() + ".");
			e.printStackTrace();
		}finally{
			System.out.println(this.getName() + " ha terminato di scrivere sulla coda dopo aver prodotto " 
			+ this.valoriProdotti + " valori.");
		}
	}
}

class Consumer extends Thread{
	private Coda queue;
	private int valoriConsumati;
	private int valoriDaConsumare;
	
	public Consumer(Coda q, String name, int valoriDaConsumare){
		this.queue = q;
		this.setName(name);
		this.valoriConsumati = 0;
		this.valoriDaConsumare = valoriDaConsumare;
	}
	
	@Override
	public void run(){
		try{
			while(valoriDaConsumare > 0){
				queue.get();
				valoriConsumati++;
				valoriDaConsumare--;
			}
		}catch(NoSuchElementException e){
			System.out.println("Qualcosa e' andato storto con " + this.getName() + ".");
			e.printStackTrace();
		}finally{
			System.out.println(this.getName() + " ha terminato di leggere dalla coda dopo aver letto " +
			this.valoriConsumati + " valori.");
		}
	}
}

class Coda{
	
	private Semaphore semProducer;
	private Semaphore semConsumer;
	private Semaphore semConsumerTurn;
	private Semaphore semProducerTurn;
	private int writeIndex;
	private int readIndex;
	private int[] values;
	
	public Coda(int size){
		this.values = new int[size]; 
		this.semProducer = new Semaphore(size,true);
		this.semConsumer = new Semaphore(0,true);
		this.semConsumerTurn = new Semaphore(1,true);
		this.semProducerTurn = new Semaphore(1,true);
		this.writeIndex = 0;
		this.readIndex = -1;
	}
	
	void put(){
		try{
			semProducer.acquire();
			semProducerTurn.acquire();
			// sezione critica
			this.values[writeIndex] = writeIndex;
			System.out.println(Thread.currentThread().getName() + " -> " + this.writeIndex);
			this.writeIndex = (this.writeIndex + 1) % this.values.length;
			// fine sezione critica
			semConsumer.release();
			semProducerTurn.release();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	void get(){
		try{
			semConsumer.acquire();
			semConsumerTurn.acquire();
			// sezione critica
			this.readIndex = (this.readIndex + 1) % values.length;
			System.out.println(Thread.currentThread().getName() + " -> " + this.readIndex);
			// fine sezione critica
			semConsumerTurn.release();
			semProducer.release();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}