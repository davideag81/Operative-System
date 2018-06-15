package elezioniSemplificato;

public class Campus {

	public static void main(String[] args) {
		System.out.println("ELEZIONI ACCADEMICHE\n\n");
		Seggio seggio = new Seggio();
		Votante votante = new Votante (seggio, 1);
		
		votante.start();
		

	}

}
