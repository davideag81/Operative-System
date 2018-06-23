package elezioniSemplificato;

public class Seggio {

	private int r = (int)(Math.random()*5);
	private boolean [] cabine = new boolean [r]; 		//variabile condivisa
	private int contatoreVotanti; 		//condiction
	
	// costruttore seggio, numero di cabine casuali
	public Seggio() {
		for(int i =0 ; i < r ; i++ ) { 	//da 1 a 5 cabine	
		this.cabine[i] = false ;
		this.contatoreVotanti = 0;	// inizializza variabile di condizione
		System.out.println("Il seggio #"+ i +" ha "+ r +" cabine.");
		}
	}
	
	public boolean noCabineLibere() {
		boolean cabineLibere = false;
		for(int i = 0; i < this.r; i++) {
			if(cabine[i] == false) {
				cabineLibere = false;
			}
		}
		return cabineLibere;
	}
	
	public void situazioneCabine() {
		for(int i = 0; i < this.r; i++) {
			if(cabine[i] == true) {
				System.out.println("Cabina "+ i + " \tLIBERO");
			}else {
				System.out.println("Cabina "+ i + " \tOCCUPATO");
			}
		}
		System.out.println();
	}
	
	public void SpostaCabine()	//Serve per riordinare l'array cabine quando un votante vota
	{
		System.out.println("Cabine prima del ricollocamento : ");
		situazioneCabine();

		int i=0, j=1, c=0;

		while (c<=4)
		{
			if(c==4)
			{
				cabine[i]=false;  
			}
			else
			{
				cabine[i]=cabine[j]; //sposto le cabine verso verso sinistra
			}

			i++;
			j++;
			c++;
		}

		System.out.println("Cabine dopo il ricollocamento : ");
		situazioneCabine();
	}
	
	public synchronized void accediAlSeggio(int idVotante) {
		if (noCabineLibere() == true) {
			System.out.println("Non ci sono posti in coda. Votante #" + idVotante + " prova in un altro seggio.");
		}
	}
	
	public synchronized void accediAllaCabina(int idVotante) {
		while (noCabineLibere() == true) {
			System.out.println("Non ci sono cabine libere. Votante #" + idVotante + " attendi...");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Thread.currentThread().sleep(1000);
			System.out.println("Il Votante ha votato!");
		}
		contatoreVotanti++;
		cabine[(contatoreVotanti - 1)] = true;
		System.out.println("Il cliente #"+ idVotante +" entra in cabina ");
		situazioneCabine();
		notify();
	}
	
}
