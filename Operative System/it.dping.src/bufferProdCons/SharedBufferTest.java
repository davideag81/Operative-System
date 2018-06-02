/*l'oggetto syncronized usa monitor */
  package bufferProdCons;
 
public class SharedBufferTest {

	public static void main(String[] args) {
		//non sincronizzato
	// Buffer sharedLocation = new UnsyncronizedBuffer();
		//sincronizzato
	Buffer sharedLocation = new SyncronizedBuffer();
	
	Producer producer = new Producer(sharedLocation);
	Consumer consumer = new Consumer(sharedLocation);
	
	producer.start();
	consumer.start();
	}

}
