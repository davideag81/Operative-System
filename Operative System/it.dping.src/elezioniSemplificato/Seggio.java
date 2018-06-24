package elezioniSemplificato;

public class Seggio {
	int cabine = 3;	// buffer condiviso
	private boolean [] cabin = new boolean [cabine]; 		// contatore variabile condivisa
	private int contatoreVotanti; 		//condiction
	
	public boolean noCabineLibere() {
		boolean cabineLibere = false;
		for(int i = 0; i < this.cabine; i++) {
			if(cabin[i] == false) {
				cabineLibere = false;
			}
		}
		return cabineLibere;
	}
	
	public void situazioneCabine() {
		for(int i = 0; i < this.cabine; i++) {
			if(cabin[i] == true) {
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
				cabin[i]=false;  
			}
			else
			{
				cabin[i]=cabin[j]; //sposto le cabine verso verso sinistra
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
		cabin[contatoreVotanti] = true;
		System.out.println("Il cliente #"+ idVotante +" entra in cabina ");
		situazioneCabine();
		notify();
	}
	
}
