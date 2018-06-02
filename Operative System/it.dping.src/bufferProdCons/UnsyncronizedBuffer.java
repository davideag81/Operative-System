package bufferProdCons;

public class UnsyncronizedBuffer implements Buffer {
	private int buffer= -1;
	
	@Override
	public void set(int value) {
		System.err.println(Thread.currentThread().getName() + " scrive "+ value);
		buffer= value;

	}

	@Override
	public int get() {
		System.err.println(Thread.currentThread().getName() + " legge "+ buffer);
		return buffer;
	}

}
