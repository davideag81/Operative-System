package magazzino;

public class Producer implements Runnable {

	WareHouse whareHouse;
	
	
	
	public Producer(WareHouse wharehouse) {
		super();
		this.whareHouse = wharehouse;
		new Thread(this, "Producer").start();
	}



	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			whareHouse.put(i);
		}

	}

}
