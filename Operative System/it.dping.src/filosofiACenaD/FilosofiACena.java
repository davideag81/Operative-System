package filosofiACenaD;

import java.util.Random;

/*
Problema dei filosofi di Dijkstra.

Possibile implementazione di buffer circolare.

Problemi possibili:
- Deadlock -> il filosofo è costretto a posare la forchetta sinistra nel caso ne abbia una sola.
- Posticipazione indefinita -> meccanica invecchiamento dentro filosofi.

Filosofo -> Thread:

pensa()
prendiForchette()
mangia()
posaForchette()

Tavolo -> Monitor


*/

public class FilosofiACena {
	public static void main(String[] args) {
		Tavolo tavolo = new Tavolo();
		Filosofo socrate = new Filosofo(tavolo, 0, "Socrate");
		Filosofo platone = new Filosofo(tavolo, 1, "Platone");
		Filosofo aristotele = new Filosofo(tavolo, 2, "Aristotele");
		Filosofo democrate = new Filosofo(tavolo, 3, "Democrate");
		Filosofo anassagora = new Filosofo(tavolo, 4, "Anassagora");
	}
}
