package filosofi;

public class Main {

	public static void main(String[] args) {
		int numFilosofi=5;
		Filosofo filosofi[] = new Filosofo[numFilosofi];
		Forchette forchette = new Forchette(numFilosofi);

		for(int i=0; i<numFilosofi; i++){
			filosofi[i] = new Filosofo(i, forchette);
			filosofi[i].start();
		}
	}
}