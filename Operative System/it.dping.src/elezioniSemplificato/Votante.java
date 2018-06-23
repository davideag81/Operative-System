package elezioniSemplificato;

public class Votante extends Thread {
	int tipoVotante[];
	Seggio seggio;	// monitor
	
	boolean haVotato = false;
	
	public Votante(Seggio seggio, /*int[] tipoVotante, */int id) {
		super();
		//this.tipoVotante = tipoVotante;
		this.seggio = seggio;
	}
	
	public void get() {
		
	}
	
	public void set() {
		
	}
	

}
