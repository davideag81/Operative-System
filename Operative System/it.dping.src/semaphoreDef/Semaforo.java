package semaphoreDef;
import java.util.concurrent.Semaphore;
public class Semaforo {

	/* Contatore del semaforo */
	private int contatore;

	/* Numero di processi sospesi sul semaforo */
	private int contatoreProcessiInAttesa;

	/**
	 * Crea un nuovo semaforo con il contatore interno inizializzato al valore
	 * specificato da <CODE>contatore</CODE>.
	 */
	public Semaforo(int contatore) throws InterruptedException {
		if ( contatore < 0 )
			throw new InterruptedException("Semaforo inizializzato con un valore negativo" );
		this.contatore = contatore;
	}

	/**
	 * Se <CODE>contatore=0</CODE> si sospende sul semaforo il thread
	 * invocante la <CODE>wwait</CODE>, altrimenti <CODE>contatore--</CODE>.
	 */
	public synchronized void wwait() throws InterruptedException {
		if ( contatore == 0 ) {
			contatoreProcessiInAttesa++;
			wait();
			contatoreProcessiInAttesa--;
		} else
			contatore--;
	}

	/**
	 * Se esistono thread sospesi sul semaforo se ne risveglia uno, altrimenti
	 * <CODE>contatore++</CODE>.
	 */
	public synchronized void ssignal() {
		if ( contatoreProcessiInAttesa > 0 )
			notify();
		else
			contatore++;
	}

}