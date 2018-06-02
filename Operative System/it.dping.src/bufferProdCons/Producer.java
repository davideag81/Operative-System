package bufferProdCons;

import javax.sound.midi.SysexMessage;

public class Producer extends Thread {
	private Buffer shareLocation;

	public Producer(Buffer shareLocation) {
		super("Producer");
		this.shareLocation = shareLocation;
	}

	// comportamento del Producer dorme da 0 a 3 secondi e poi scrive la variabile condivisa
	@Override
	public void run() {		
		for(int count=1; count<4; count++){
			try {
				Thread.sleep((int) (Math.random() * 3001 ));
				shareLocation.set(count);
			}catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
		System.err.println(getName()+ " ha effettuato la produzione."
				+ "\nTerminato. " + getName());
	}
	
	
}
