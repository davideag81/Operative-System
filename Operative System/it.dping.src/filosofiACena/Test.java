package filosofiACena;


public class Test {
	
	private static final int NUM_PHILOSOPHERS = 5;

	public static void main(String[] args){
		
		Supervisor sup = new Supervisor(NUM_PHILOSOPHERS, 5);
		Forks forks = new Forks(NUM_PHILOSOPHERS, sup);
		Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
		
		for(int i = 0; i < NUM_PHILOSOPHERS; ++i)
			philosophers[i] = new Philosopher(i, forks, sup);
	}
}
