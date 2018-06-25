package autostradaA20;

public class Veicolo extends Thread {
	String tipo; // AUTO PESANTE SOCCORSO
	Casello cIn;
	Casello cOut;
	boolean telepass = false; // se paga con telepass
	boolean ticket = false; // se ha ricevuto il ticket per pagamento contanti all'ingresso
	boolean stato; // se ha completato l'attraversamento del casello in uscita

	// costruttore parametrizzato generico
	public Veicolo(String tipo, Casello cIn, Casello cOut, String name, boolean telepass) {
		super(name);
		this.cIn = cIn;
		this.cOut = cOut;
		this.tipo = tipo;
		this.telepass = telepass;
		this.start(); // avvio in fase di costruzione
	}

	// ciclo Thread
	public void run() {
		while (this.stato == false) {
			try {
				System.out.println(tipo + getName() + " sta raggiungendo il casello.");
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.ticket = cIn.entra(this.tipo);
			System.out.println(tipo + getName() + " libera la corsia.");
			cIn.libera();
			try {
				System.out.println(tipo + getName() + " sta raggiungendo il casello.");
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.stato = cOut.esci(this.tipo);
			System.out.println(tipo + getName() + " libera la corsia.");
			cOut.libera();
		}
	}
}
