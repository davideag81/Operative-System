package ElezioniConOsar;

public class Votante extends Thread {

	int id;
	boolean haVotato = false;
	Seggio seggio;	// monitor
	int categoria[]= new int [3]; // Studenti, Docenti, PersonaleTAB
	
	
	public Votante(int id, Seggio seggio, int[] categoria) {
		super();
		this.id = id;
		this.seggio = seggio;
		this.categoria = categoria;
	}
	
	// void 
	
	
	
}
