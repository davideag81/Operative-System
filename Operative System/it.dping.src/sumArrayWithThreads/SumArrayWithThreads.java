package sumArrayWithThreads;

/* Calcolare la somma di un array utilizzando due thread.
 * Inoltre, provare a modificare il programma per fare in modo che il numero di thread 
 * possa essere un parametro di input*/
 
import java.util.Random;


public class SumArrayWithThreads extends Thread{
	private int[] array;
	private int primoElemento;
	private int ultimoElemento;
	private int somma;
	
	public SumArrayWithThreads(int[] array, int primoElemento, int ultimoElemento){
		this.array = array;
		this.primoElemento = primoElemento;
		this.ultimoElemento = ultimoElemento;
		this.somma = 0;
	}
	
	public int getSomma(){
		return this.somma;
	}
	
	@Override
	public void run(){
		for(int i=this.primoElemento; i<this.ultimoElemento; i++){
			this.somma+=this.array[i];
		}
	}
	
	public static void main(String args[]){
		int numeroThread;
		int maxval = 10;
		int dimensioneArray = 10;
		int[] array = generaArray(dimensioneArray,maxval);
		try{
			numeroThread = Integer.parseInt(args[0]);
		}
		catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
			System.out.println("Errore nella lettura del parametro di input. Verranno utilizzati due thread come da default");
			numeroThread = 2;
		}
		int somma = calcolaSomma(array,numeroThread);
		System.out.println("La somma degli elementi del vettore è " + somma);
	}
	
	static int[] generaArray(int dimensione, int maxval){
		int[] array = new int[dimensione];
		Random r = new Random();
		for(int i = 0; i<dimensione; i++){
			array[i] = r.nextInt(maxval + 1);
		}
		return array;
	}
	
	static void stampaArray(int[] array){
		System.out.print("[");
		for(int i = 0; i<array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.print("]\n");
	}
	
	static int calcolaSomma(int[] array, int numeroThread){
		int somma = 0;
		int dimensioneArray = array.length;
		//stampaArray(array);
		SumArrayWithThreads[] threads = new SumArrayWithThreads[numeroThread];
		for(int i=0; i<numeroThread; i++){
			threads[i] = new SumArrayWithThreads(array,(i*dimensioneArray)/numeroThread,((i+1)*dimensioneArray)/numeroThread);
			threads[i].start();
		}
		for(int i=0; i<numeroThread; i++){
			try{
				threads[i].join();
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			somma += threads[i].getSomma();
		}
		return somma;
	}
	
}