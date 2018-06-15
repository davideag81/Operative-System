package barbiereDiSiviglia;

public class Divano {
	boolean posti[];		// variabile condivisa
	int contatoreclienti;		// contatore accesi
	int nPosti = 5;
	
	public Divano () {
		this.posti = new boolean[5];
		this.contatoreclienti = 0;
	}
	
	public boolean noPostiLiberi() {	//metodo che controlla la disponibilità di posti
		boolean postiLiberi = true;
		for(int i =0; i < nPosti; i++) {
			if(posti[i] == false) {
				postiLiberi = false;
			}
		}
		return postiLiberi;
	}

	public synchronized void salaDAttesa( int idCliente) {
		
		
	}
}
