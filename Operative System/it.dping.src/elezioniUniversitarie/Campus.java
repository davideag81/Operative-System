package elezioniUniversitarie;

import java.util.Random;

public class Campus {

	public static void main(String[] args) throws InterruptedException{
		
		System.out.println("Programma Concorrente per la simulazione delle elezioni accademiche.\n");
		Campus unipa = new Campus();
		Random r = new Random(5);
		final int nCabineMAX = 5;
		final int nSeggi = 5;
		
		System.out.println("... sto generando 5 seggi.\n");
		Seggio seggio[] = new Seggio[nSeggi];
				for (int i = 0 ; i < nSeggi; i ++ ) {
					seggio[i] = new Seggio(1, r.nextInt(nCabineMAX), unipa);
				}
				
		System.out.println("... sto generando 10000 studenti.\n");
		int nStudenti = 10000;
		Votante studenti[] = new Votante[nStudenti];
		for (int i = 0 ; i < nStudenti; i ++ ) {
			studenti[i] = new Votante(i, Categoria.STUDENTE, seggio[r.nextInt(seggio.length)]);
			studenti[i].start();
			
		}
		
		System.out.println("... sto generando 100 docenti.\n");
		int nDocenti = 100;
		Votante docenti[] = new Votante[nDocenti];
		for (int i = 0 ; i < nDocenti; i ++ ) {
			docenti[i] = new Votante(i, Categoria.DOCENTE, seggio[r.nextInt(seggio.length)]);
			docenti[i].start();
			
		}
		
		System.out.println("... sto generando 200 personale Tab.\n");
		int nPersTab = 250;
		Votante personaleTab[] = new Votante[nPersTab];
		for (int i = 0 ; i < nPersTab; i ++ ) {
			personaleTab[i] = new Votante(i, Categoria.PERSONALE_TAB, seggio[r.nextInt(seggio.length)]);
			personaleTab[i].start();
			
		}

	}

}
