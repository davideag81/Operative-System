package filosofi2;


public class Filosofo extends Thread {

	
	private Forchette forchette;	// Monitor
	private int id;
	String name = Thread.currentThread().getName();
	

	public Filosofo(Forchette forchette, String name) {
		super(name);
		this.forchette = forchette;
		this.id = id;
	}
	
	@Override
	public void run() {
		while(true) {
			pensa();
			prendiForchette();
			mangia();
			posaForchette();
			
		}
	}

	private void posaForchette() {
		System.out.println(name + " sta posando le forchette.");
		
	}

	private void mangia() {
		System.out.println(name + " sta mangiando.");
		try {
			wait();
			System.out.println(name + " sta mangiando.");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void prendiForchette() {
		System.out.println(name + " sta prendendo le forchette.");
		
	}

	private void pensa() {
		System.out.println(name + " sta pensando.");
		try {
			wait();
			System.out.println(name + " sta pensando.");
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
