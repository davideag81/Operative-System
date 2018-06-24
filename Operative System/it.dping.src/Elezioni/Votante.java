package Elezioni;

public class Votante extends Thread {
private int id;
// private int type = 0;
private Seggio seggio;
//private Cabina cabina;
private boolean haVotato= false;
int n;

public Votante(int id, Seggio seggio) {
	super();
	this.id = id;
	// this.type = type;
	this.seggio = seggio;
}

public void vota(int n, int votante) {
	this.haVotato = seggio.vota(n, votante);
}

@Override
public void run() {
	// seggio.mettiInLista(id);
	while(haVotato != true) {
		System.out.println(" Votante "+ this.id + "prova a votare nel Seggio #" + seggio.id + " votante");
		vota(n, id);
		
	}
	System.out.println(" Votante "+ this.id + "ha votato!");
}

}
