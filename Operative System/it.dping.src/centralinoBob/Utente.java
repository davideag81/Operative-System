package centralinoBob;

import java.util.Random;

public class Utente extends Thread{
	
	private final boolean interno;
	private int id;
	private Centralino centralino;
	
	public Utente(boolean interno, int id, Centralino centralino){
		this.interno = interno;
		this.id = id;
		this.centralino = centralino;
	}
	
	public String getNome(){
		return ((this.interno)? "interno " : "esterno ") + this.id;
	}
	
	@Override
	public void run(){
		Random r = new Random();
		// Se il cliente e' esterno, puo' solo chiamare il centralino
		boolean riceventeEsterno = (this.interno)? r.nextBoolean() : false;
		String ricevente = (riceventeEsterno)? " utente esterno " : " utente del centralino";
		
		System.out.println("L'utente " + this.getNome() + " sta cercando di chiamare un " + ricevente + ".");
		boolean chiamataEffettuata = centralino.avviaChiamata(this.id, riceventeEsterno);
		
		if(chiamataEffettuata){
			
			System.out.println("L'utente " + this.getNome() + " e' attualmente al telefono con un " + ricevente + ".");
			// Simula una durata casuale per la chiamata
			try{	
				this.sleep(r.nextInt(5000));
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			centralino.terminaChiamata(this.id);
			System.out.println("L'utente " + this.getNome() + " ha terminato la chiamata.");
		}
		else{
			System.out.println("L'utente " + this.getNome() + " ha trovato il centralino occupato.");
		}
	}
}
