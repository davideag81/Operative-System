package prodcons;

public class UnSyncronizedBuffer implements Buffer {
	private int buffer  = -1; // shared variable
	
	
// place value in to the buffer
	@Override
	public void set(int value) {
		System.err.println(Thread.currentThread().getName() + " writes " + value);
		buffer=value;
	}

	@Override
	public int get() {
		System.err.println(Thread.currentThread().getName() + " reads " + buffer);
		return buffer;
	}

}