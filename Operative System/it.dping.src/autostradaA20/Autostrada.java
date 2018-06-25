package autostradaA20;

/*@@ $$ --> Davide Proietto <----> dping.it <--	$$ @@*/
import java.util.Random;

public class Autostrada {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
		Random r = new Random();
		int nCIn = 6;
		int nCOut = 4;
		Casello caselliIn[] = new Casello[nCIn];
		Casello caselliOut[] = new Casello[nCOut];
		int nAuto = 100;
		int nPesanti = 50;
		int nSoccorso = 10;
		Veicolo auto[] = new Veicolo[nAuto];
		Veicolo pesanti[] = new Veicolo[nPesanti];
		Veicolo soccorso[] = new Veicolo[nSoccorso];
		int nCorsie = 2;

		// creo N caselli in Ingresso
		for (int i = 0; i < nCIn; i++) {
			caselliIn[i] = new Casello(1, nCorsie, "Casello IN #" + i);
		}

		// creo M caselli in Uscita
		for (int i = 0; i < nCOut; i++) {
			caselliOut[i] = new Casello(0, nCorsie, "Casello OUT #" + i);
		}

		// Thread inizializzati nel costruttore
		for (int i = 1; i <= nAuto; i++) {
			auto[i] = new Veicolo("AUTO", caselliIn[r.nextInt(nCIn)], caselliOut[r.nextInt(nCIn)], " #" + i,
					r.nextBoolean());
		}
		for (int i = 1; i <= nPesanti; i++) {
			pesanti[i] = new Veicolo("PESANTE", caselliIn[r.nextInt(nCIn)], caselliOut[r.nextInt(nCIn)],
					" #" + i, r.nextBoolean());
		}
		for (int i = 1; i <= nSoccorso; i++) {
			soccorso[i] = new Veicolo("SOCCORSO", caselliIn[r.nextInt(nCIn)], caselliOut[r.nextInt(nCIn)],
					" #" + i, r.nextBoolean());
		}

	}

}
