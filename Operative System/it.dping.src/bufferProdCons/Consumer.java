package bufferProdCons;

public class Consumer extends Thread {
	private Buffer shareLocation;

	public Consumer(Buffer shareLocation) {
		super("Consumer");
		this.shareLocation = shareLocation;
	}
	int sum=0;

	// comportamento del Consumer Legge 4 volte la variabile condivisa
	@Override
	public void run() {		
		for(int count=1; count<=4; ++count){
			try {
				Thread.sleep((int) (Math.random() * 3001 ));
				sum += shareLocation.get();
			}catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
		System.err.println(getName()+ " totale dei valori letti."
				+ sum +"\nTerminato. " + getName()+".");
	}

}
