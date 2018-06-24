package parcheggioAuto;

public class Auto extends Thread {

	Parcheggio parcheggio;

	public Auto(String id, Parcheggio parcheggio) {
		super(id);
		this.parcheggio = parcheggio;
	}

	public void run() {
		while (true) {
			try {
				sleep((int) (Math.random() * 20000)); // guida prima del parcheggio
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " sta cercando parcheggio!");
			parcheggio.parcheggia();
			System.out.println(getName() + ": entrata posti liberi:" + parcheggio.postiLiberi);
			try {
				sleep((int) (Math.random() * 10000)); // tempo di parcheggio
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + " sta uscendo dal parcheggio!");
			parcheggio.esce();
			System.out.println(getName() + " uscita posti liberi:" + parcheggio.postiLiberi);
		}
	}
}
