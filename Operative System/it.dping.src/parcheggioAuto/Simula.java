package parcheggioAuto;
/* Realizza un programma che simuli l'attività di 10 automobili che utilizzano un 
 * parcheggio di 5 posti; se il parcheggio è totalmente occupato le eventuali
 * auto che vogliono entrare devono essere messe in attesa (wait) circolando per
 * un tempo massimo di 20 secondi. Le auto in attesa devono ritentare l'ingresso 
 * appena si libera un posto (notify). Ogni auto può restare parcheggiata solo 
 * per un tempo massimo di 10 secondi.          
*/
public class Simula {

	public static void main(String[] args) {
		int nAuto= 10;
		int nPosti= 5;
		
		Parcheggio park = new Parcheggio(nPosti);	//monitor
		
		Auto automobili[]  = new Auto[nAuto];	//tread
		for(int i = 1; i <= nAuto; i++) {
			automobili[i] = new Auto("Auto "+i, park);
			automobili[i].start();
		}
	}

}
