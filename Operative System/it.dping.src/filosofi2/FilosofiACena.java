package filosofi2;

public class FilosofiACena {

	public static void main(String[] args) {


		Forchette forchette = new Forchette();
		Filosofo filosofo1 = new Filosofo(forchette, "Aristotele");
		Filosofo filosofo2 = new Filosofo(forchette, "Socreate");
		Filosofo filosofo3 = new Filosofo(forchette, "Platone");
		Filosofo filosofo4 = new Filosofo(forchette, "Democrate");
		Filosofo filosofo5 = new Filosofo(forchette, "Talete");
		
		filosofo1.start();
		filosofo2.start();
		filosofo3.start();
		filosofo4.start();
		filosofo5.start();

	}

}
