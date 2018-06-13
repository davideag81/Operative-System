package biglietteriaStadio;

public class Cliente extends Thread {
	private int id;	//contatore cliente
	Rivendita rivendita; // monitor 
	private int bigliettiDesiderati;	// variabile
	private int bigliettiComprati;	// contatore accessi

	public Cliente(int i, Rivendita r, int desiderati){	//costruttore a cui passo il monitor
		id = i;
		rivendita = r;
		bigliettiDesiderati = desiderati;
		bigliettiComprati=0;
	}

	public void acquista(int n, int cliente){	// metodo di accesso al buffer condiviso
		bigliettiComprati += rivendita.serviCliente(n,cliente);
	}

	public void run() {		// comportamento
		rivendita.mettiInLista(id);
		while(bigliettiDesiderati!=bigliettiComprati){
			acquista(bigliettiDesiderati-bigliettiComprati,id);
			System.out.println("Il cliente " +id + " ha acquistato " + bigliettiComprati + " di " + bigliettiDesiderati + "biglietti in rivendita " + rivendita.id);
			//System.out.println("R"+rivendita.id +" C"+id+ "-->"+bigliettiComprati+ " di " + bigliettiDesiderati);
		}
	}
}