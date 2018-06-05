package magazzino;

public class Main {

	public static void main(String[] args) {
		WareHouse wareHouse = new WareHouse(); // crea monitor
		new Producer(wareHouse);
		new Consumer(wareHouse);

	}

}
