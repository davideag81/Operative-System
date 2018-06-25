package elezioniUniversitarie;

public class Votante extends Thread {
	int id;
	boolean haVotato;
	Seggio seggio;

	public Votante(String name, int id, Seggio seggio) {
		super(name);
		this.id = id;
		this.haVotato = false;
		this.seggio = seggio;
	}

	public boolean accediSeggio() {
		boolean esito = false;
		System.out.println(getName() + " sta provando ad accedere al seggio...");
		esito = seggio.mettinInLista(id);
		return esito;
	}

	public void vota() {
		try {
			System.out.println(getName() + " sta votando.");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (this.haVotato != true) {
			try {
				System.out.println(getName() + " prova ad entrare in un seggio");
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			while (!seggio.mettinInLista(this.id)) {
				seggio.mettinInLista(this.id);
			}
			System.out.println(getName() + " è entrato nel seggio " + seggio.name);
			seggio.entra(this.id);
			vota();
			this.haVotato = seggio.esce();
			// seggio.stampaCoda();
		}
	}
}
