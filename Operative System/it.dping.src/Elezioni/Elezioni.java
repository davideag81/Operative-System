package Elezioni;

import java.util.Random;

public class Elezioni {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		int nCabine = 3;
		int nVotanti = 10;
		Seggio seggio = new Seggio(nCabine);
		Votante votanti[] = new Votante[nVotanti];
		for (int i = 0; i < nVotanti; i++) {
			votanti[i] = new Votante("Studente " + i, seggio);
			votanti[i].start();
		}
	}
}