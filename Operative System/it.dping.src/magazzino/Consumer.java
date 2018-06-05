package magazzino;

public class Consumer implements Runnable {

	WareHouse wareHouse;
	
	
	
	public Consumer(WareHouse wareHouse) {
		super();
		this.wareHouse = wareHouse;
		new Thread(this,"Consumer").start();
		}



	@Override
	public void run() {
		for(int i=1; i<=10000; i++) {
			i= wareHouse.get();
		}

	}

}
