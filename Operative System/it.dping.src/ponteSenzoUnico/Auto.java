package ponteSenzoUnico;

public class Auto extends Thread {
	private Provenienza direzione; // NORD o SUD
	//private int codaAuto[]; //numero auto che devono attraversare il ponte
	Ponte ponte;
		
	// costruttore set auto generico
	public Auto(Ponte ponte, Provenienza direzione, int auto) {
		new Thread(this,"Auto").start();
		this.direzione = direzione;
		//this.codaAuto= new int[auto];
		this.ponte = ponte;
	}

	// costruttore set auto generico
	public Auto( Provenienza direzione, Ponte ponte, int auto) {
		new Thread(this,"Auto").start();
		this.direzione = direzione;
		//this.codaAuto= new int[auto];
		this.ponte = ponte;
	}


	@Override
	public void run() {
		  ponte.attraversaPonte(direzione);
		  try {
		  this.sleep(Math.round(Math.random()*1000));
		  }catch(InterruptedException exc) {
			  exc.printStackTrace();
		  }
          ponte.liberaPonte();

	}

}
