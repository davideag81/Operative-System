package biglietteriaStadio;

import java.util.LinkedList;

public class Rivendita{
	private Biglietteria biglietteria;
	public int id;
	private int bigliettiVendibili;
	private LinkedList<Integer> codaClienti = new LinkedList<Integer>();

	public Rivendita(Biglietteria b, int i){
		biglietteria=b;
		bigliettiVendibili = biglietteria.allocaLotto();
		id=i;
	}

	public synchronized void mettiInLista(int cliente){
		codaClienti.add(cliente);
		stampaCoda();
	}

	public void rifornisci(){
		bigliettiVendibili = biglietteria.allocaLotto();//+=
		System.out.println("#"+id + "Rivendita ha ottenuto un lotto");
	}

	public synchronized int serviCliente(int nRichiesta, int cliente){
		if(bigliettiVendibili==0){
			rifornisci();
		}
		while(cliente!=codaClienti.getFirst()){
			try{
				wait();

			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}	
		int bigliettiVenduti=nRichiesta;
		if(bigliettiVendibili-nRichiesta < 0){
			bigliettiVenduti=bigliettiVendibili;
		}
		bigliettiVendibili-=bigliettiVenduti;
		if(bigliettiVenduti==nRichiesta){
			codaClienti.removeFirst();
			stampaCoda();
		}
		pagamento();
		notifyAll();
		return bigliettiVenduti;
	}

	void stampaCoda(){
		System.out.print("Q" + id + " ");
		for(int tmp : codaClienti){
			System.out.print("C" +tmp +"==");
		}
		System.out.println();
	}

	void pagamento(){
		try{
			Thread.sleep((int)Math.round(Math.random()*1000));
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}