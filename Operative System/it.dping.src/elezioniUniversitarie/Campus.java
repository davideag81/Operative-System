package elezioniUniversitarie;

import java.util.Random;

public class Campus {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

		System.out.println("Programma Concorrente per la simulazione delle elezioni accademiche.\n");
		Random r = new Random(5);
		final int nCabineMAX = 5;
		final int nSeggi = 5;

		System.out.println("... sto generando 5 seggi.\n");
		Seggio seggio[] = new Seggio[nSeggi];
		for (int i = 0; i < nSeggi; i++) {
			seggio[i] = new Seggio("Seggio #" + i, r.nextInt(nCabineMAX));
		}

		System.out.println("... sto generando 100 studenti.\n");
		int nStudenti = 100;
		Votante studenti[] = new Votante[nStudenti];
		for (int i = 0; i < nStudenti; i++) {
			studenti[i] = new Votante("STUDENTE #" + i, i, seggio[r.nextInt(seggio.length)]);
			studenti[i].start();

		}

		System.out.println("... sto generando 10 docenti.\n");
		int nDocenti = 10;
		Votante docenti[] = new Votante[nDocenti];
		for (int i = 0; i < nDocenti; i++) {
			docenti[i] = new Votante("DOCENTE #" + i, i, seggio[r.nextInt(seggio.length)]);
			docenti[i].start();

		}

		System.out.println("... sto generando 10 personale Tab.\n");
		int nPersTab = 10;
		Votante personaleTab[] = new Votante[nPersTab];
		for (int i = 0; i < nPersTab; i++) {
			personaleTab[i] = new Votante("FPERSONALE_TAB #" + i, i, seggio[r.nextInt(seggio.length)]);
			personaleTab[i].start();

		}

	}

}
