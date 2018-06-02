/* Pesca due carte dal mazzo ciascuna con un thread. Confuta il risultato e proclama il vincitore*/
package threadCreate;

public class Main {

	public static void main(String[] args) {

		ThreadCreate t1= new ThreadCreate("t1");
		ThreadCreate t2= new ThreadCreate("t2");
		
		t1.start();
		t2.start();
	}

}
