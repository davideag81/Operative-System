package postaPneumatica;

public class MainSemaphore {

	public static void main(String[] args) {
		PostaP posta = new PostaP();
		Produttore mittente = new Produttore(posta);
		Consumatore destinatario = new Consumatore(posta);

	}

}
