package biglietteriaStadio;

/***Testo*******************************
Si modelli il sistema informatico per la gestione della biglietteria di uno stadio.
Per ciascun evento, vengono messi in vendita un numero TOT di biglietti totali che 
possono essere acquistati presso N diverse rivendite.
Ciascun cliente può acquistare fino ad un massimo di MAX biglietti e può scegliere
se pagare in contanti o tramite carta di credito (si simuli un tempo per 
transazione più breve nel secondo caso rispetto al primo).
Alcune rivendite accettano solo il pagamento mediante carta di credito, mentre 
altre accettano entrambi i tipi di pagamento, ma daranno precedenza ai clienti che
pagano con carta di credito rispetto a quelli che pagano in contanti. A ciascuna
rivendita verrà assegnato inizialmente un lotto di L biglietti (L << TOT); se 
questi si esauriscono, la rivendita potrà rifornirsi, a patto che rimangano 
ancora biglietti disponibili.

***************************************/

import java.util.Random;

public class Biglietteria {
	private int bigliettiResidui;
	private final static int lotto = 50;
	public Biglietteria(int inizioTOT){
		bigliettiResidui=inizioTOT;
	}

	public synchronized int allocaLotto(){
		int bigliettiRilasciati = lotto;
		if(bigliettiResidui < lotto){
			bigliettiRilasciati = bigliettiResidui;
		}
		bigliettiResidui-=bigliettiRilasciati;
		//System.out.println("totale in deposito = " + bigliettiResidui);
		return bigliettiRilasciati;
	}

	public static void main(String[] args) {
		int numRivendite = 5;
		int totaleBiglietti = 10000;
		int clientiMAX=50;
		int bigliettiMAX=50;
		Cliente c[]=new Cliente[clientiMAX];
		Biglietteria biglietteria = new Biglietteria(totaleBiglietti);
		Rivendita rivendite[] = new Rivendita[numRivendite];

		for(int i=0; i<numRivendite; i++){
			rivendite[i] = new Rivendita(biglietteria,i);
		}
		int clientiGenerati=0;
		Random r = new Random();
		for(clientiGenerati=0; clientiGenerati<clientiMAX;clientiGenerati++){
			clientiGenerati++;
			int index = r.nextInt(numRivendite);
			int biglietti=r.nextInt(bigliettiMAX)+1;
			//int index = (int) Math.round(Math.random()*(numRivendite-1));
			c[clientiGenerati] = new Cliente(clientiGenerati, rivendite[index], biglietti);
			c[clientiGenerati].start();
			System.out.println("R"+index +" nuovo C"+clientiGenerati+ "-->B"+biglietti);
			try{
				Thread.sleep(r.nextInt(100));
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}



	}
}