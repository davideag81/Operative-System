package Elezioni;

import java.util.Random;

public class Elezioni {

	public static void main(String[] args) {
		Seggio seggio = new Seggio(1);
		Votante votanti[] = new Votante[10];
		for (int i =1; i<=votanti.length; i++) {
			votanti[i] = new Votante(i, seggio);
			votanti[i].start();
		}
	/*	int numSeggi = 5;
		int votanti = 10;
		int votantiMAX=50;
	
		Seggio seggi[] = new Seggio[numSeggi];
	/*	for(int i=0; i<numSeggi; i++){
			seggi[i] = new Seggio(i);
		}
		Votante listVotanti[] = new Votante[votanti];
		int votantiGenerati=0;
		Random r = new Random();
		for(votantiGenerati=0; votantiGenerati<votanti; votantiGenerati++){
			votantiGenerati++;
			int index = r.nextInt(numSeggi);
			//int biglietti=r.nextInt(votantiMAX)+1;
			//int index = (int) Math.round(Math.random()*(numRivendite-1));
			listVotanti[votantiGenerati] = new Votante(votantiGenerati, 1, seggi[index]);
			listVotanti[votantiGenerati].start();
			System.out.println("R"+index +" nuovo C"+votantiGenerati+ "-->B");
			try{
				Thread.sleep(r.nextInt(100));
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}



		/*Random s = new Random();
		Seggio seggi[] ;
		for(int i = 0; i < s.nextInt(5); i++) {
			seggi[i] = new Seggio(i);
		}
		Votante votanti[] = new Votante[10000];
			for (int i =1; i<=votanti.length; i++) {
				votanti[i] = new Votante(i, i, seggi[s.nextInt(5)]);
				votanti[i].start();
			}

	}
*/
}
}