package elezioniSemplificato;

public class Votante extends Thread {
	int id;
	Seggio seggio;	// monitor
	
	boolean haVotato = false;
	
	public Votante(Seggio seggio, int id) {
		super("Votante "+id);
		this.id = id;
		this.seggio = seggio;
	}
	public void run() {
		for(int count =1; count<=4; count++) {
			try {
				Thread.sleep(Math.round(Math.random()*3001));
				seggio.accediAllaCabina(count); // set scrive nel buffer
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " ha votato!\n");
		}
	}
	
	

}
