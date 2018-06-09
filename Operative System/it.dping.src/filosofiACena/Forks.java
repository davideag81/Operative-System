package filosofiACena;


public class Forks {
	
	private boolean[] forks;
	private final Supervisor supervisor;
	
	public Forks(int num, Supervisor sup){
		
		forks = new boolean[num];
		supervisor = sup;
	}
	
	
	public synchronized boolean getForks(int id) throws InterruptedException {
		
		//Forchetta successiva
		int nextFork = (id + 1)%forks.length;
		
		//Aspetto finchè non è disponibile la forchetta col mio stesso indice
		//O finchè i filosofi accanto sono favoriti
		while(forks[id] || supervisor.cantEat(id)){
			
			if(forks[id])
				System.out.printf("Filosofo %d: aspetto perchè la forchetta non è disponibile\n", id);
			else
				System.out.printf("Filosofo %d: aspetto per favorire un altro filosofo\n", id);
			
			//Finchè aspetto incremento la mia priorità
			supervisor.incrementPriority(id);
			
			wait();
		}
			
		
		//Prendo la forchetta col mio stesso indice
		forks[id] = true;
		
		//Se la forchetta successiva è disponibile mangio
		if(!forks[nextFork]){
			
			forks[nextFork] = true;
			notifyAll();
			return true;
		}
		//In caso contrario poso la forchetta già presa
		else{
			
			forks[id] = false;
			
			//Incremento la mia priorità
			supervisor.incrementPriority(id);
			
			notifyAll();
			return false;
		}
		
	}
	
	public synchronized void releaseForks(int id){
		
		forks[id] = forks[(id + 1)%forks.length] = false;
		
		//Ho mangiato: la mia priorità diventa 0
		supervisor.zeroPriority(id);
		
		notifyAll();
	}
	
}
