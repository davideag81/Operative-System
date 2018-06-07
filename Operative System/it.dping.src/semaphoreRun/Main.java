package semaphoreRun;

public class Main {

	public static void main(String args[]) {
		Incrocio incrocio = new Incrocio();
		Thread t1 = new Thread(new Veicolo(incrocio), "Una Ford");
		t1.start();
		Thread t2 = new Thread(new Veicolo(incrocio), "Una Seat");
		t2.start();
	}
}
