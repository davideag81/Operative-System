package gestioneBiglietti;

/***Testo*******************************
Si modelli il sistema informatico per la gestione della biglietteria di uno stadio.
Per ciascun evento, vengono messi in vendita un numero TOT di biglietti totali che 
possono essere acquistati presso N diverse rivendite.
Ciascun cliente può acquistare fino ad un massimo di MAX biglietti e può scegliere
se pagare in contanti o tramite carta di credito (si simuli un tempo per 
transazione più breve nel secondo caso rispetto al primo).
Alcune rivendite accettano solo il pagamento mediante carta di credito, mentre 
altre accettano entrambi i tipi di pagamento, ma daranno precedenza ai clienti che
pagano con carta di credito rispetto a quelli che pagano in contanti. A ciascuna
rivendita verrà assegnato inizialmente un lotto di L biglietti (L << TOT); se 
questi si esauriscono, la rivendita potrà rifornirsi, a patto che rimangano 
ancora biglietti disponibili.

***************************************/

public class Cliente extends Thread {

	private int tipoPagamento[];
	private int idCliente;
	private int nBiglietti;
	private Rivendita rivendita;
	
	// costruttore 
	public Cliente(int[] tipoPagamento, int idCliente, Rivendita rivendita) {
		super();
		this.tipoPagamento = tipoPagamento;
		this.idCliente = idCliente;
		this.rivendita = rivendita;
		this.nBiglietti=0;
	}
	
	public void acquista() {
		System.out.println("Il cliente " + idCliente + " è pronto per acquistare");
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e ){
			e.printStackTrace();
			}
		
		}
	
	public void procediAcquisto() {
		rivendita.acuistaBiglietto(idCliente);
	}
	
	public void pagaBiglietto() {
		
	}
	
	@Override
	public void run() {
		acquista();
		pagaBiglietto();
		
	}
	
}