package tester;

public class ThreadTester {
	public static void main(String args[]) {
		//create three Threads
		PrintThread thread1 = new PrintThread("thread1");
		PrintThread thread2 = new PrintThread("thread2");
		PrintThread thread3 = new PrintThread("thread3");

		System.err.println("Starting Threads");
		
		//start, place  the Tread in ready state
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
