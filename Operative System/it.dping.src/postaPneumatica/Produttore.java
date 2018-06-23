package postaPneumatica;

public class Produttore extends Thread {
	private PostaP posta ;

	public Produttore(PostaP posta) {
		super();
		this.setName("Mittente");
		this.posta = posta;
		this.start();

	}
	
	@Override
	public void run() {
		try {
			for (int i =0; i<10; i++) {
				posta.send((int)(Math.round(Math.random()*9)));
				Thread.sleep(2000);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
