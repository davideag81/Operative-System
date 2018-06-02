package semaphoreSyncronized;
import java.util.concurrent.Semaphore;
public class SemaphoreSyncronized {

	Semaphore valueProducer = new Semaphore(0);
	Semaphore valueConsumer = new Semaphore(1);
	int sharedValue;
	
/*	startThreads();*/
}
