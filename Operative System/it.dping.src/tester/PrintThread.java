package tester;

public class PrintThread extends Thread {
	private int sleepTime;
	
	public PrintThread() {
		super("PIPPO");
	}

	//Costructor of Thread
	public PrintThread(String name) {
		super(name);
		
		// set sleepTime
		sleepTime= (int) (Math.random() * 5001);
	}

	// behavior of th Thread
	@Override
	public void run() {
		try {
			System.err.println(getName() + " going sleep for " + sleepTime + " milliseconds!");
			Thread.sleep(sleepTime);
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}
		System.err.println(getName() + " done sleeping");
	}


}
