package autostradaA20Bis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Casello {
	int tipoCasello; // Casello ingersso = 1 Casello Uscita = 0
	int tipoCorsia; // Corsia ingersso A = 1 Corsia ingersso B = 0 Corsia uscita X = 3 Corsia uscita
					// Y = 2
	int priorita[] = {0,0};
	int nCorsie=2;
	int corsieLibere = nCorsie;
	String name;
		private int nCorsie;		//numero di imbarcazioni che possono entrare contemporaneamente nella chiusa
		private int ingresso;	// 1 ingresso 0 uscita
		
		public Casello(){
			this.nCorsie =5;			//Possono entrare ancora 5 imbarcazioni
			this. ingresso =1;
		}
	
	public synchronized void entraCasello(int id, String tipoVeicolo, String name) 	{
		System.err.println();
		if(tipoCasello != 1 ){	//se è un casello cOut
			System.out.println("Errore Casello");
					
		}
		else
		{
			switch(tipoVeicolo)
			{
				case "SOCCORSO":
					while (corsieLibere == 0) {
						try {
							System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					corsieLibere--;
					break;
					
				case "AUTO" || "PESANTE":
					if(tipoCasello == 1 && tipoCorsia == 1) {	// qualunque mezzo
						while (corsieLibere == 0) {
							try {
								System.out.println(Thread.currentThread().getName() + " non ci sono corsie libere, aspetta!");
								wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						corsieLibere--;
						break;
				case default:
					}
					
			}
}}}