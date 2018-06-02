package threadCreate;

public class ThreadCreate extends Thread {
	private int carta=-1;
	private final int[] mazzo = new int[52];
	
	public ThreadCreate(String name) {
		super(name);
		this.carta = 0;
	}
	
 @Override
	public void run() {
	try	{
		creaMazzo(mazzo);
		carta += Math.random() * 51;
		System.out.println("Il Thread "+ getName()+ " estrae la carta ... "+ carta);
		Thread.sleep(5000);
	}catch(InterruptedException exc) {
		exc.printStackTrace();
	}
	System.out.println("Il thread ha finito! ");
 }
 
 public int[] creaMazzo(int[] mazzo) {
		for (int i=0; i<52; i++) {
			mazzo[i] = i +1;
		}
		return mazzo;
	}
}
