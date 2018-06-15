package elezioniUniversitarie;

import java.util.LinkedList;

public class Seggio2 {

	int idSeggio;
	int nInCoda = 0;
	private final static int MaxCoda = 100;
	int nCabine;
	int inCabina = 0;	//var condition
	boolean statoCabine[];	// var condivisa
	int cabine[];
	Campus campus;
	boolean checkCommissione = false;
	private LinkedList<Integer> codaSeggio = new LinkedList<>();
	
	public boolean noCabineLibere() { //controlla se ci sono cabine libere
		boolean cabineLibere = true;
		for (int i = 0; i< nCabine; i++) {
			if(statoCabine[i] == false) {
				cabineLibere = false;
			}
		}
		return cabineLibere;
	}
	
	public void situazioneCabine() {
		for(int i = 0; i < nCabine; i++) {
			if(statoCabine[i] == true) {
				System.out.println("1 ");
			} else {
				System.out.println("0 ");
			}
		}
		System.out.println();
	}
	
	public Seggio2(int idSeggio, int nCabine, Campus campus) {
		super();
		this.idSeggio = idSeggio;
		this.nCabine = nCabine;
		
		this.statoCabine = new boolean [nCabine];
		this.campus = campus;
		for (int i=0; i<statoCabine.length; i++) {
			statoCabine[i] = false;
		}
	}
	
	public void ordinaCabine()	//Serve per riordinare l'array cabine quando un cliente viene servito
	{
		System.out.println("Cabine prima del ricollocamento : ");
		situazioneCabine();

		int i=0, j=1, c=0;

		while (c<=nCabine)
		{
			if(c== nCabine)
			{
				statoCabine[i]=false;  
			}
			else
			{
				statoCabine[i]=statoCabine[j]; //sposto i posti verso verso sinistra
			}

			i++;
			j++;
			c++;
		}

		System.out.println("Posti dopo il ricollocamento : ");
		situazioneCabine();
	}
	
	public boolean mettinInLista(int idVotante) {
		
		if(nInCoda <= MaxCoda) {
			codaSeggio.addFirst(idVotante);
			// stampaCodaSeggio(this.idSeggio);
			System.out.println("La commissione di seggio consegna il token e l'utente attende una cabina libera.!");
			return checkCommissione = true;
		} else {
			System.out.println("Coda Piena. Recarisi in un altro seggio!");
			return checkCommissione = false;
		}
	}
	
	private void stampaCodaSeggio(int idSeggio) {
		System.out.println("Coda al seggio #"+ idSeggio + "\n");
		for(int tmp : codaSeggio) {
			System.out.println("Votante #"+ tmp +".\n");
		}
		
	}

	public synchronized void liberaCabina(int i) {
		statoCabine[i]=true;		//esce dalla cabina 
		

		cabine[i]++;	//aumento la priorità, cosi dovrò aspettare che tutti abbiano votato almeno una volta

		notifyAll();			//sveglio tutti i thread eventualmente in attesa

		
	}
	public synchronized boolean entraCabina(int i) {
		while(!statoCabine[i] || cabine[i]>cabine[(i+1)%nCabine]) {
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		statoCabine[i]=false;		//entra in una cabina come metodo synchronized è come se fosse operazione atomica
	
		return statoCabine[i];
	}
	}