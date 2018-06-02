package biglietteriaStadio;

public class Cliente extends Thread {
	private int id;
	Rivendita rivendita;
	private int bigliettiDesiderati;
	private int bigliettiComprati;

	public Cliente(int i, Rivendita r, int desiderati){
		id = i;
		rivendita = r;
		bigliettiDesiderati = desiderati;
		bigliettiComprati=0;
	}

	public void acquista(int n, int cliente){
		bigliettiComprati += rivendita.serviCliente(n,cliente);
	}

	public void run() {
		rivendita.mettiInLista(id);
		while(bigliettiDesiderati!=bigliettiComprati){
			acquista(bigliettiDesiderati-bigliettiComprati,id);
			//System.out.println(id + " ha acquistato " + bigliettiComprati + " di " + bigliettiDesiderati + " in rivendita " + rivendita.id);
			System.out.println("R"+rivendita.id +" C"+id+ "-->"+bigliettiComprati+ " di " + bigliettiDesiderati);
		}
	}
}