package elezioniUniversitarie;

public class Votante extends Thread {
	int idVotante;
	boolean haVotato;
	Categoria cat;
	Seggio seggio;
	
	public Votante(int idVotante, Categoria cat, Seggio seggio) {
		super();
		this.idVotante = idVotante;
		this.haVotato = false;
		this.cat = cat;
		this.seggio = seggio;
	}
	
	//public void vaiAVotare();
	
	public boolean accediSeggio() {
		boolean esito = false;
		System.out.println("Utente " + idVotante + " sta provando ad accedere al seggio...");
		esito = seggio.entraCabina(idVotante);
		return esito;
	}
	
	public boolean vota() {
		try {
			System.out.println(Thread.currentThread().getName() + " sta votando.");
			Thread.sleep( /* Math.round(Math.random()* */ 2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this.haVotato;
	}
	
	public void lasciaSeggio() {
		System.out.println("Utente " + idVotante + " sta lasciando il seggio...");
		seggio.liberaCabina(idVotante);
	}
	
	@Override
	public void run() {
		while(this.haVotato != true) {				
				if(this.accediSeggio()) {
					this.vota();
					this.lasciaSeggio();
				}
			}
		}
	}
	
