package bufferProdCons;

public class SyncronizedBuffer implements Buffer {

	private int buffer= -1; // condivisa
	private int occupiedBuffers=0; //momitor
	
	public synchronized void set(int value) {
		//visualizza il Thread ciamante
		String name = Thread.currentThread().getName(); 
		
		// controllo che il buffer sia vuoto
		while (occupiedBuffers == 1) {
			try {
				//stampa info su Threads e buffer
				System.err.println(name +" ha tenteto di scrivere! ");
				displayState("Buffer pieno. " + name + " in attesa");
				wait();
			}catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
		//nuovo buffer
		buffer = value;
		// blocca il produttore
		++occupiedBuffers;
		
		displayState(name + " scrive " + buffer);
		
		//notifica al prossimo Thread
		notify();
		// rilascia il buffer
	}
	
	public synchronized int get() {
		//visualizza il Thread ciamante
				String name = Thread.currentThread().getName(); 
				
				// controllo se ci sono dati da leggere
				while (occupiedBuffers == 0) {
					try {
						//stampa info su Threads e buffer
						System.err.println(name +" ha tenteto di leggere! ");
						displayState("Buffer vuoto. " + name + " in attesa");
						// attesa di un nuovo dato da leggere
						wait();
					}catch (InterruptedException exc) {
						exc.printStackTrace();
					}
				}
				// valore letto 
				--occupiedBuffers;
				
				displayState(name + " scrive " + buffer);
				
				//notifica al prossimo Thread di uscire da wait
				notify();
				// ritorna il buffer
				return buffer;
	}
	
	
	
	// visualizza lo stato corrente del buffer
	public void displayState(String operation) {
		StringBuffer opt = new StringBuffer(operation);
		opt.setLength(40);
		opt.append(buffer+ "\t\t" +occupiedBuffers);
		System.err.println(opt);
		System.err.println();
		
		

	}

}
