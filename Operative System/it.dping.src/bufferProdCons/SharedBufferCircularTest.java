package bufferProdCons;

public class SharedBufferCircularTest {

	/*l'oggetto syncronized usa monitor circolare */

		public static void main(String[] args) {

			//sincronizzato
		SyncronizedBuffer sharedLocation = new SyncronizedBuffer();
		
		//visualizza intestazione
		StringBuffer columnHeads = new StringBuffer("Operazione");
		columnHeads.setLength(40);
		columnHeads.append("Buffer\t\t Contatore occupato");
		System.err.println(sharedLocation);
		System.err.println();
		sharedLocation.displayState("StatoIniziale");
		
		// crea produttore e consumatore
		Producer producer = new Producer(sharedLocation);
		Consumer consumer = new Consumer(sharedLocation);
		
		producer.start();
		consumer.start();
		}

	}
