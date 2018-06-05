package filosofi;

public class Tavolo {
	private int nForchette;
	private int nMangiano;
	private boolean statoForchette[];//true occupato e false libero
	private int nVolte[];
	private int nVolteMangiato[]; // il filosofo ha mangiato n volte
	
	public Tavolo(int nForchette) {
		this.nForchette = nForchette;
		this.statoForchette = new boolean [nForchette];
		this.nVolte = new int [nForchette];
		this.nVolteMangiato = new int [nForchette];
		
		for(int i=0; i<nForchette; i++) {
			statoForchette[i] = false;
			nVolte[i]=0;
			nVolteMangiato[i]=0;
		}
		nMangiano=0;
			
		}
	public synchronized void prendiForchette(int id){
		//System.out.println("***Stanno mangiando in " + nMangiano + "***");
		//calcolo forchette dx e sx
		int forchettasx = id;
		int forchettadx = (id+1)%5;
		int delta = 0;//1000000000
		//System.out.println("Il filosofo " + id + " sta provando a prendere " + forchettasx + " e " + forchettadx);
		while(statoForchette[forchettasx] || statoForchette[forchettadx] || nVolteMangiato[id]>nVolteMangiato[(id-1+5)%5]+delta || nVolteMangiato[id]>nVolteMangiato[(id+1)%5]+delta){//|| nvolte[id]<nvolte[(id-1+5)%5] || nvolte[id]<nvolte[(id+1)%5]
			//stampaStato();
			try{
				if(statoForchette[forchettasx]){
					System.out.println("Il filosofo " + id + " sta aspettando la forchetta " + forchettasx);
				}
				if(statoForchette[forchettadx]){
					System.out.println("Il filosofo " + id + " sta aspettando la forchetta " + forchettadx);
				}
				System.out.println("***Stanno mangiando in " + nMangiano + "***");
				nVolte[id]++;
				stampaMangiato(id,"-");

				wait();
				System.out.println("risvegliato");
				
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}

		statoForchette[forchettasx]=true;
		statoForchette[forchettadx]=true;
		nVolte[id]=0;
		nMangiano++;
		stampaMangiato(id, "+");
		
	}

	public synchronized void rilasciaForchette(int id){
		//calcolo forchette dx e sx
		int forchettasx = id;
		int forchettadx = (id+1)%5;
		//libero le forchette
		statoForchette[forchettasx]=false;
		statoForchette[forchettadx]=false;
		//System.out.println("Il filosofo " + id + " libera " + forchettasx + " e " + forchettadx);
		nMangiano--;
		nVolteMangiato[id]++;
		stampaMangiato(id, "");
		notifyAll();
	}
	private void stampaMangiato(int id, String s){
		for(int i=0; i < nVolteMangiato.length; i++){
				System.out.print(nVolte[i] + " ");
		}
		System.out.print("***");
		for(int i=0; i < nVolteMangiato.length; i++){
				System.out.print(nVolteMangiato[i] + " ");
		}
		System.out.println("---> " + id + s);
	}
}
