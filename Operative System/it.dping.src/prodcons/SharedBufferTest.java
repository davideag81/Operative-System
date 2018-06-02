package prodcons;

public class SharedBufferTest {

	public static void main(String[] args) {
		Buffer sharedBuffer = new UnSyncronizedBuffer();
		
		Producer producer = new Producer(sharedBuffer);
		Consumer consumer = new Consumer(sharedBuffer);
		
		producer.start();
		consumer.start(); 
	}

}
