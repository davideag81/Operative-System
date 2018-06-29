package autostradaA20;

public class Veicolo extends Thread {
	String tipo; // AUTO PESANTE SOCCORSO
	int id;
	Casello cIn;
	Casello cOut;
	boolean telepass = false; // se paga con telepass
	boolean ticket; // se ha ricevuto il ticket per pagamento contanti all'ingresso
	boolean stato[]={false,false}; // se ha completato l'attraversamento del casello ingresso e/o uscita

	// costruttore parametrizzato generico
	public Veicolo(String tipo, Casello cIn, Casello cOut, String name, boolean telepass, int id) {
		super(name);
		this.id = id;
		this.cIn = cIn;
		this.cOut = cOut;
		this.tipo = tipo;
		this.telepass = telepass;
		this.start(); // avvio in fase di costruzione
	}

	// ciclo Thread
	public void run() {
		while (this.stato[1] == false) {
			try {
				System.out.println(tipo + getName() + " sta raggiungendo il casello.");
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cIn.mettiInCoda(this.tipo, this.id);
			this.ticket = cIn.entra(this.tipo, this.id); //se entra in A riceve il ticket, in B puo passare solo chi ha il telepass
			System.out.println(tipo + getName() + " entra nella corsia.");
			cIn.libera();
			try {
				System.out.println(tipo + getName() + " sta raggiungendo il casello.");
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean test = cOut.esci(this.tipo, this.ticket);
			if (test) {
				System.out.println(tipo + getName() + " lascia l'autostrada.");
				this.stato[1] = cOut.liberaUscita();
				System.err.println(tipo + getName() + " lascia l'autostrada.");
			}
		}
	}
}
