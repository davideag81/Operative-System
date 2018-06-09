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
		
		//Aspetto finch� non � disponibile la forchetta col mio stesso indice
		//O finch� i filosofi accanto sono favoriti
		while(forks[id] || supervisor.cantEat(id)){
			
			if(forks[id])
				System.out.printf("Filosofo %d: aspetto perch� la forchetta non � disponibile\n", id);
			else
				System.out.printf("Filosofo %d: aspetto per favorire un altro filosofo\n", id);
			
			//Finch� aspetto incremento la mia priorit�
			supervisor.incrementPriority(id);
			
			wait();
		}
			
		
		//Prendo la forchetta col mio stesso indice
		forks[id] = true;
		
		//Se la forchetta successiva � disponibile mangio
		if(!forks[nextFork]){
			
			forks[nextFork] = true;
			notifyAll();
			return true;
		}
		//In caso contrario poso la forchetta gi� presa
		else{
			
			forks[id] = false;
			
			//Incremento la mia priorit�
			supervisor.incrementPriority(id);
			
			notifyAll();
			return false;
		}
		
	}
	
	public synchronized void releaseForks(int id){
		
		forks[id] = forks[(id + 1)%forks.length] = false;
		
		//Ho mangiato: la mia priorit� diventa 0
		supervisor.zeroPriority(id);
		
		notifyAll();
	}
	
}
