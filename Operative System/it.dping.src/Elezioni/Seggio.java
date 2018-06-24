package Elezioni;

import java.util.LinkedList;
import java.util.Random;
public class Seggio {
	
	private final static int MAX = 50;

	public int id;
	private boolean commissione = true;
	
	private Random r ;
	private int nCabine ;
	private boolean cabine[];
	private int cabineOccupate = 0;
	
	//private LinkedList<Integer> codaVotanti = new LinkedList<Integer>();
	
	
	
	public Seggio(int id) {
		super();
		this.id = id;
		this.r = new Random();
		this.nCabine = r.nextInt(5);
		this.cabine = new boolean[nCabine];
	}

	public synchronized boolean vota(int n, int votante) {
		if(cabineOccupate == cabine.length){
			System.out.println("Tutte le cabine sono occupate, attendi");
			//liberaCabine();
			//this.wait();
			return false;
		}
		else if(cabineOccupate < cabine.length) {
		while(votante!=codaVotanti.getFirst()){
			try{
				Thread.currentThread().wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}
			cabineOccupate++;
			codaVotanti.removeFirst();
			return true;
			
		}
		}else {
			System.out.println("Attenzione broglio elettorale!");
			return false;
		}
		return false;
	}

	public synchronized void mettiInLista(int idVotante) {
		codaVotanti.add(idVotante);
		
	}

}
