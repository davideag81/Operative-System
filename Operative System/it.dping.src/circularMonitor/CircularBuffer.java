/* Circular Buffer sincronizza l'accesso ad un array condiviso
 */ 
package circularMonitor;

public class CircularBuffer implements Buffer {
	//ogni elemento dell'array è un buffer
	private int[] buffers= {-1,-1,-1};
	// conta quanti elementi dell'array sono occupati
	private int occupiedBuffers = 0;
	
	// variabili di controllo scorrimento array
	private int readLocation = 0;
	private int writeLocation = 0;
	

	@Override
	public synchronized void set(int value) {
		//visualizza il Thread ciamante
				String name = Thread.currentThread().getName(); 
				
				// controllo che il buffer sia vuoto
				while (occupiedBuffers == buffers.length) {
					try {
						//stampa info su Threads e buffer
						System.err.println("Tutti i buffers sono pieni! "
								+ name + " attende.");
						// attende spazio disponibile
						wait();
					}catch (InterruptedException exc) {
						exc.printStackTrace();
					}
				}
				//buffer in posizione di scrittura
				buffers [writeLocation] = value;
				
				System.err.println("\n" + name + " scrive " + buffers[writeLocation] + "");
				// buffer ora occupato
				++occupiedBuffers;
				
				writeLocation = (writeLocation + 1) % buffers.length;
				
				System.err.println("createStateOutput()"); //da implementare
				
				//notifica al prossimo Thread
				notify();
				// ritorna un valore dal buffer
	}

	@Override
	public synchronized int get() {
		//visualizza il Thread ciamante
		String name = Thread.currentThread().getName(); 
		
		// 
		while (occupiedBuffers == 0) {
			try {
				//
				System.err.println("\nTutti i buffers sono pienivuoti! "
						+ name + " in attesa.");
				// attende nuovi dati
				wait();
			}catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
		//buffer in posizione di lettura
		int readvalue =buffers [readLocation];
		
		System.err.println("\n" + name + " legge " + readvalue+ "");
		// buffer ora occupato
		--occupiedBuffers;
		
		readLocation = (readLocation + 1) % buffers.length;
		
		System.err.println("createStateOutput()"); //da implementare
		
		//notifica al prossimo Thread
		notify();
		// ritorna un valore dal buffer
		return readvalue;
	}

	public String createStateOutput() {
		String output= " (posizioni occupate di Buffers: "
				+ occupiedBuffers + ") buffers";
		return output;
	}
}
