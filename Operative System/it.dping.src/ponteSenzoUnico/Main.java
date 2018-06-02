/* Esercizio 3 -Ponte con senso unico alternato 
	Un ponte contiene una sola corsia di traffico consentendo così l'accesso a macchine provenienti da una sola 
	direzione per volta, a senso unico alternato. Si identifichi ciascuna macchina con un processo (ci saranno 
	quindi due tipi di processo, le macchine provenienti da nord e le macchine provenienti da sud) e si scriva 
	un programma che sincronizzi l'accesso delle auto sul ponte, facendo uso dei costrutti monitor e variabili 
	condizionali. Si tenga conto che: 
		non esistono priorità tra i processi; 
		un processo può atbaversare il ponte solo se non vi sono sopra processi dell'altro tipo .
		 */
package ponteSenzoUnico;
import java.util.concurrent.Semaphore;

import semaphore4Thread.Coda;
import semaphore4Thread.Consumer;
import semaphore4Thread.Producer;

import java.util.*;
import java.util.NoSuchElementException;

public class Main {

	public static void main(String args[]){
		Coda q = new Coda(3);
		int numeroProduttori = 10;
		int numeroConsumatori = 10;
		int valoriDaProdurre = 10;
		Producer[] produttori = new Producer[numeroProduttori];
		Consumer[] consumatori = new Consumer[numeroConsumatori];
		
		for(int i = 0; i < numeroProduttori; i++){
			produttori[i] = new Producer(q, "Thread produttore P" + (i+1),valoriDaProdurre);
			produttori[i].start();
		}
		for(int i = 0; i < numeroConsumatori; i++){
			consumatori[i] = new Consumer(q, "Thread consumatore C" + (i+1),valoriDaProdurre);
			consumatori[i].start();
		}
		try{
			for(int i = 0; i < produttori.length; i++){
				produttori[i].join();
			}
			for(int i = 0; i < consumatori.length; i++){
				consumatori[i].join();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	
	}
}

}
