package philosofiLife;

public class Main {

	public static void main(String[] args) {
		int numFilosofi=5;
		Filosofo a [] = new Filosofo[numFilosofi];
		Forchette forks = new Forchette(5);
		for(int i = 0; i<a.length; i++) {
			a[i] = new Filosofo(i, forks);	
		}
			a[0].setName("Aristotele");
			a[1].setName("Platone");
			a[2].setName("Socrate");
			a[3].setName("Talete");
			a[4].setName("Aristofane");
			
			for(int i = 0; i<a.length; i++) {	
			a[i].start();
			
		}

	}

}
