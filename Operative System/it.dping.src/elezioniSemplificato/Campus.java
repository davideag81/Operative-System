package elezioniSemplificato;

import java.util.LinkedList;

public class Campus {
LinkedList<Votante> popolazione = new LinkedList<>();
Seggio seggio;


	
	
	public Campus() {
	for (int i =0; i<100; i++) {
		popolazione.push(new Votante (seggio, i));
		popolazione.getFirst().start();
	}
}




	public static void main(String[] args) {
		System.out.println("ELEZIONI ACCADEMICHE\n\n");
		Seggio seggio = new Seggio();
		//Votante votante = new Votante (seggio, 1);
		
		Campus unipa = new Campus();
		
	}
	}