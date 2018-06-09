package centralinoBob;


/*
 * Un centralino telefonico � dotato di N linee in ingresso ed M linee in uscita,
 * con M >> N. Un utente esterno che intende effettuare una chiamata verso l'ufficio,
 * dovr� comporre il numero interno desiderato e potr� usufruire del servizio se una
 * delle N linee sar� libera, altrimenti ricever� il segnale di occupato.
 * 
 * Un utente interno che intende effettuare una chiamata (verso l'esterno o
 * verso l'interno), dovr� comporre il numero desiderato e potr� usufruire del
 * servizio se una delle M linee sar� libera, altrimenti verr� messo in attesa.
 * Alle richieste di chiamate tra coppie di utenti interni sar� assegnata una priorit�
 * maggiore nella coda di attesa. Ottenuto l'accesso alla linea di uscita, verr� 
 * effettuata una chiamata di durata variabile.
 * 
 * Si modelli lo scenario descritto mediante thread in linguaggio Java usando il
 * costrutto monitor e si descriva la sincronizzazione tra thread, discutendo
 * anche se la soluzione proposta pu� presentare rinvio indefinito o deadlock.
 * In tal caso, si propongano delle soluzioni implementative per evitare i due 
 * fenomeni.*/

import java.util.Random;

public class Esercizio{
	
	public static void main(String[] args){
		int numeroUtenti = 10;
		int numeroLineeIngresso = 1;
		int numeroLineeUscita = 3;
		Centralino centralino = new Centralino(numeroLineeIngresso, numeroLineeUscita);
		Utente[] utenti = new Utente[numeroUtenti];
		Random r = new Random();
		boolean interno;
		
		for(int i = 0; i < utenti.length; i++){
			interno = r.nextBoolean();
			utenti[i] = new Utente(interno, i, centralino);
			if(interno) centralino.aggiungiCentralinista(i);
		}
		for(int i = 0; i < utenti.length; i++){
			// il doppio ciclo for serve per assicurare che tutti i centralinisti siano stati aggiunti prima di avviare i thread
			try{
				utenti[i].start();
				Thread.currentThread().sleep(r.nextInt(2000));
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
