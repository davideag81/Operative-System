package funivia;
/*In una piccola località turistica è in funzione una funivia, con una cabina che
può contenere al massimo MAX passeggeri. La funivia effettua due fermate:
una a valle e una a monte. La cabina parte dalla fermata a valle solo quando
ha caricato almeno MIN passeggeri, mentre è sufficiente anche solo un
passeggero per partire dalla fermata a monte. Ogni passeggero, dopo essere
entrato nella cabina a valle, aspetta che questa arrivi a monte per uscire;
quando ha finito la visita, riprende la funivia e attende che la cabina arrivi a
valle per uscire.
Si implementi una soluzione usando il costrutto monitor per modellare la
funivia e i processi per modellare i passeggeri e la cabina e si descriva la
sincronizzazione tra i processi. Nella soluzione si massimizzi l'utilizzo delle
risorse. Si discuta se la soluzione proposta può presentare rinvio indefinito e
in caso positivo per quali processi, e si propongano modifiche e/o aggiunte
per evitare ciò.
*/

public class Main {

	public static void main(String[] args) {
/*		int numRivendite = 5;
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


*/
	}

}
