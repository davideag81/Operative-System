package filosofiACena;

import java.util.Random;

public class Philosopher extends Thread {

	private static final int MAX_SLEEP = 3001;
	
	private final int id;
	private final Forks forks;
	private final Supervisor supervisor;
	
	Random rand = new Random();
	
	public Philosopher(int id, Forks forks, Supervisor sup){
		
		this.id = id;
		this.forks = forks;
		supervisor = sup;
		
		start();
	}
	
	public void run(){
		
		try{
			
			while(true){
				
				if(forks.getForks(id)){

					eat();
					//supervisor.zeroPriority(id);
					forks.releaseForks(id);					
				}
				else{
					
					//supervisor.incrementPriority(id);
					think();
				}
				
				supervisor.priorityState();
			}
			
		}
		catch(InterruptedException e){
			
			System.err.println("Interrupted nel filosofo " + id);
			e.printStackTrace();
		}
	}
	
	private void think() throws InterruptedException {
		
		int n = rand.nextInt(MAX_SLEEP);
		System.out.println("Filosolo " + id + " pensa per " + n + " ms.");
		sleep(n);
		System.out.println("Filosofo " + id + " ha finito di pensare.");
	}
	
	private void eat() throws InterruptedException {
		
		int n = rand.nextInt(MAX_SLEEP);
		System.out.println("Filosolo " + id + " mangia per " + n + " ms.");
		sleep(n);
		System.out.println("Filosofo " + id + " ha finito di mangiare.");
	}
}
