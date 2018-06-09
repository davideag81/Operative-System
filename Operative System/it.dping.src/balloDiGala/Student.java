package balloDiGala;


import java.util.Random;

public class Student extends Thread {

	private static final int MAX_SLEEP = 3000;
	private static final int EATING_TIME = 5000;
	
	private final int sId;
	private final Table table;
	
	private static final Random rand = new Random();
	
	public Student(int id, Table table){
		sId = id;
		this.table = table;
		
		start();
	}
	
	public void run(){
		
		try{
			
			//Tempo di arrivo
			sleep(rand.nextInt(MAX_SLEEP));
			
			table.seat(sId);
			
			table.eat(sId);
			
			//Tempo per cenare
			sleep(EATING_TIME);
			
			table.finishEat(sId);
			
			//Tempo di abbandono
			sleep(rand.nextInt(MAX_SLEEP));
			
			table.stand(sId);		
			
		}
		catch(InterruptedException e){
			System.err.println("Student " + sId + " interrupted.");
			e.printStackTrace();
		}
	}
}
