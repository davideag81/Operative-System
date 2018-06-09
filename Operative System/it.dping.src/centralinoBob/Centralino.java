package centralinoBob;


import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


public class Centralino{
	
	private List<Integer> idUtentiInterni;
	private int lineeInIngresso;
	private int lineeInUscita;
	private int ingressiLiberi;
	private int usciteLibere;
	private LinkedList<Integer> codaChiamateInterne;
	private LinkedList<Integer> codaChiamateEsterne;
	
	public Centralino(int lineeInIngresso, int lineeInUscita){
		this.lineeInIngresso = lineeInIngresso;
		this.lineeInUscita = lineeInUscita;
		this.ingressiLiberi = lineeInIngresso;
		this.usciteLibere = lineeInUscita;
		this.idUtentiInterni = new ArrayList<>();
		this.codaChiamateEsterne = new LinkedList<>();
		this.codaChiamateInterne = new LinkedList<>();
	}
	
	public synchronized boolean avviaChiamata(int idChiamante, boolean riceventeEsterno){
		if(!this.idUtentiInterni.contains(idChiamante)){
			// Gestione chiamata dall'esterno verso il centralino
			if(this.ingressiLiberi > 0){
				// chiamata riuscita
				this.ingressiLiberi--;
				return true;
			}
			else return false; // linee occupate, chiamata fallita
		}
		else{
			// Gestione chiamata dal centralino
			if(this.usciteLibere > 0){
				// chiamata riuscita
				this.usciteLibere--;
				return true;
			}else{
				System.out.println("L'utente del centralino " + idChiamante + " viene messo in attesa.");
				// Uscite occupate, l'utente viene messo in attesa nella coda opportuna
				if(riceventeEsterno) codaChiamateEsterne.add(idChiamante);
				else codaChiamateInterne.add(idChiamante);
				
				while(usciteLibere == 0 || (riceventeEsterno && !codaChiamateInterne.isEmpty() && codaChiamateEsterne.getFirst() != idChiamante) ||
				 (!riceventeEsterno && codaChiamateInterne.getFirst() != idChiamante)){
					try{
						wait();
					}
					catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				// Si e' liberata una linea ed e' il turno del chiamante
				this.usciteLibere--;
				if(riceventeEsterno) codaChiamateEsterne.removeFirst();
				else codaChiamateInterne.removeFirst();
				return true;
			}
		}
	}
	
	public synchronized void terminaChiamata(int idChiamante){
		if(this.idUtentiInterni.contains(idChiamante)){
			// la chiamata da terminare era partita dal centralino
			this.usciteLibere++;
			notifyAll();
		} else this.ingressiLiberi++;
	}
	
	public void aggiungiCentralinista(int idUtente){
		this.idUtentiInterni.add(idUtente);
	}
	
}
