package philosofiLife;

public class Filosofo extends Thread {

	private int idFilosofo;
	private final int  nPensa =0;
	private final int nMangia =0;
	Forchette forks;
	
	
		
	public Filosofo(int idFilosofo, Forchette forks) {
		this.idFilosofo = idFilosofo;
		this.setName("Filosofo "+ idFilosofo);
		this.forks = forks;
	}

	public void pensa() {
		System.out.println("Il filosofo " + idFilosofo + " sta pensando!");
		try {
			Thread.sleep(Math.round(Math.random()* nPensa *1000));
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void prendiForks() { // zona critica
		System.out.println("Il filosofo " + idFilosofo + " si prepara a mangire!");
		forks.prendiForchette(idFilosofo);
		
	}

	public void mangia() {
		System.out.println("Il filosofo " + idFilosofo + " sta mangiando!");
		try {
			Thread.sleep(Math.round(Math.random()* nMangia *1000));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void posaForks() { // zona critica
		System.out.println("Il filosofo " + idFilosofo + " è sazio ed è pronto a pensare!");
		forks.lasciaForchette(idFilosofo);
	}

	@Override
	public void run() {
		this.pensa();
		this.prendiForks();
		this.mangia();
		this.posaForks();

	}

}
