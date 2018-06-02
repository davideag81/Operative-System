package prodcons;

public class Producer extends Thread {
	
	// reference shared Object
	private Buffer sharedLocation;

	public Producer(Buffer sharedLocation) {
		super("Procucer");			// create Producer
		this.sharedLocation = sharedLocation;
	}

	@Override
	public void run() {
	for(int count =1; count <=4; count ++) {
		try {
			Thread.sleep((int) (Math.random() * 3001));
			sharedLocation.set(count);
		} catch(InterruptedException exc) {
			exc.printStackTrace();
			
		}
		System.err.println(getName() + " done producing "+
		"\nTerminating " + getName() + ".");
	}
	}
	
	
}
