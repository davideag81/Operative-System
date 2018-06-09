package balloDiGala;


public class Table {
	
	private static final int NUM_SEATS = 10;
	
	private final boolean[] seats = new boolean[NUM_SEATS];
	private int numOccupiedSeats = 0;
	private int studentsWaitingToSeat = 0;
	private int studentsEating = 0;
	
	public synchronized void seat(int id) throws InterruptedException {
		
		++studentsWaitingToSeat;
		
		state(id, "Arriva al tavolo");
		
		//Lo studente attende se non c'è nessuno seduto o
		//se c'è solo uno studente in coda (Se stesso)
		while(numOccupiedSeats < 1 && studentsWaitingToSeat <= 1){
			
			state(id, "aspetta");
			wait();
		}
		
		//Lo studente può sedersi
		seats[id] = true;
		state(id, "si siede");
		++numOccupiedSeats;
		--studentsWaitingToSeat;
		
		notifyAll();		
	}
	
	public synchronized void eat(int id) {
		
		++studentsEating;
		state(id, "inizia a cenare");
	}
	
	public synchronized void finishEat(int id) {
		
		--studentsEating;
		state(id, "Termina di cenare");
		notifyAll();
	}
	
	public synchronized void stand(int id) throws InterruptedException {
		
		state(id, "vuole alzarsi");
		
		//Lo studente non si può alzare se lascia solo uno studente che
		//sta mangiando
		while(numOccupiedSeats == 2 && studentsEating > 0){
			
			state(id, "non può alzarsi. Aspetta.");
			wait();
		}
		
		//Lo studente può alzarsi
		seats[id] = false;
		state(id, "abbandona il tavolo.");
		--numOccupiedSeats;
	}
	
	private void state(int id, String operation){
		System.out.printf("Lo studente %d %s\n", id, operation);
		System.out.printf("Studenti in attesa di sedersi = %d\n"
				+ "Posti occupati = %d\n"
				+ "Studenti che stanno mangiando = %d\n\n",
				studentsWaitingToSeat, numOccupiedSeats, studentsEating);
	}

}
