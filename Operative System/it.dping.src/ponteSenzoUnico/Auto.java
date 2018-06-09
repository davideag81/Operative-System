package ponteSenzoUnico;

public class Auto extends Thread {
	private Provenienza direzione; // NORD o SUD
	private int idAuto;
	Ponte ponte; //monitor da attraversare
		
	// costruttore set auto generico
	public Auto(Ponte ponte, Provenienza direzione, int idAuto) {
		//new Thread(this,"Auto").start();
		this.direzione = direzione;
		this.idAuto= idAuto;
		this.ponte = ponte;
	}

	
	@Override
	public void run() {
		while (true) {
		  ponte.attraversaPonte(idAuto, direzione);
          ponte.liberaPonte(direzione);
		}
	}

}
