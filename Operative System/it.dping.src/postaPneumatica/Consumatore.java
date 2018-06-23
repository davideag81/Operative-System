package postaPneumatica;

public class Consumatore extends Thread {
	private PostaP posta ;

	public Consumatore(PostaP posta) {
		super();
		this.setName("Destinatario");
		this.posta = posta;
		this.start();
	}
	
	@Override
	public void run() {
		try {
			for (int i =0; i<10; i++) {
				posta.recive();
				Thread.sleep(2000);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
