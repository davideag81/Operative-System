package prodcons;

public class Consumer extends Thread {
 
	// reference shared Object
		private Buffer sharedLocation;

		public Consumer(Buffer sharedLocation) {
			super("Consumer");			// create Producer
			this.sharedLocation = sharedLocation;
		}

		@Override
		public void run() {
			int sum=0;
		for(int count =1; count <=4; count ++) {
			try {
				Thread.sleep((int) (Math.random() * 3001));
				sum += sharedLocation.get();
			} catch(InterruptedException exc) {
				exc.printStackTrace();
				
			}
			System.err.println(getName() + " read values totaling "+
			sum +"\nTerminating " + getName() + ".");
		}
		}
		
}
