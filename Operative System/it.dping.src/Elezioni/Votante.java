package Elezioni;

public class Votante extends Thread {
private Seggio seggio;
private boolean haVotato= false;


public Votante(String name, Seggio seggio) {
	super(name);
	this.seggio = seggio;
}

@Override
public void run() {
	while(this.haVotato != true) {
		try {
			sleep(Math.round(Math.random()*1000));
			System.out.println(getName()+" si sta recando al seggio.");
			sleep(Math.round(Math.random()*15000));
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(getName() + " entra nel seggio.");
		seggio.entra();
		try {
			sleep(Math.round(Math.random()*1000));
			System.out.println(getName()+" sta votando.");
			sleep(Math.round(Math.random()*10000));
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(getName() + " esce dal seggio.");
		this.haVotato = seggio.esce();	
	}
}
}
