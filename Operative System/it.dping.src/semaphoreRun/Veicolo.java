package semaphoreRun;

public class Veicolo implements Runnable {

	private Incrocio incrocio;
	public Veicolo (Incrocio incrocio) {
		this.incrocio = incrocio;
	}
	
	@Override
	public void run() {
		incrocio.rispettaSemaforo();

	}

}
