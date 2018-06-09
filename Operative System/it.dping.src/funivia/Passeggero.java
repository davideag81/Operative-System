package funivia;

public class Passeggero extends Thread {

	private int idPasseggero;
	private boolean aBordo = false; //significa che è a terra
	private boolean sale;
	private int nViaggio;
	Cabina cabina;
	
	public Passeggero(Cabina cabina, int idPasseggero) {
		this.idPasseggero = idPasseggero;
		this.cabina = cabina;
		this.nViaggio = 0;
	}
	
	public void sali() {
		
	}
	
	public void prendFunivia() {
		
	}
	
	public void scendi() {
		
	}
	
	public void scendFunivia() {
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while(true) {
			sali();
			prendFunivia();
			scendi();
			scendFunivia();
		}
	}

}
