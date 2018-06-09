package funivia;

import java.util.LinkedList;

public class Cabina {
	private int idCabina;
	private boolean cabinaSale = false; 
	private int nPassegeri = 0;
	private int postiDisponibili;
	private final int postiMAXCabina = 50;
	private final int postiMINCabina = 20;
	private LinkedList <Integer> coda = new LinkedList<>();
	
	public Cabina (int idCabina, boolean cabinaSale ) {
		this.idCabina = idCabina;
		this.cabinaSale = cabinaSale;
	}
		// aggiunge un passeggero alla lista per la cabina che è condivisa
	public synchronized void mettiInLista(int idPassegero){
		coda.add(idPassegero);
		stampaCoda();
	}
	
	public void capolinea(){
		nPassegeri = 0;
		System.out.println("La Cabina #"+idCabina + " è arrivata a Monte e i Passegeri sono scesi.");
	}
	
	public synchronized int saliABordo(int nRichiesta, int idPassegero){
		if(nPassegeri <= postiMAXCabina && nPassegeri >= postiMINCabina /*
			&& e non ci sono altri passegeri in coda */){
			parti();
		}
		while(idPassegero!=coda.getFirst()){
			try{
				wait();

			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}	
		int postiDisponibili=nPassegeri; // assegna variabile di controllo
		if(postiMAXCabina-nPassegeri < 0){
			postiDisponibili=postiDisponibili;
		}
		bigliettiVendibili-=bigliettiVenduti;
		if(bigliettiVenduti==nRichiesta){
			codaClienti.removeFirst();
			stampaCoda();
		}
		
		notifyAll();
		return nPassegeri;
	}
	
	void stampaCoda(){
		System.out.print("Q" + idCabina + " ");
		for(int tmp : coda){
			System.out.print("C" +tmp +"==");
		}
		System.out.println();
	}
}