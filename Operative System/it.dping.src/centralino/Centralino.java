package centralino;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class Centralino{
	
	private int inLines;
	private int outLines;
	private int occupiedInLines;
	private int occupiedOutLines;
	private Queue<String> outQueue;
	private Queue<String> outQueueP; 
	
	public static final int dim = 1500;
	
	public static void main(String[] args){
		Centralino c = new Centralino(5,50);
		CallingPerson[] p = new CallingPerson[dim];
		
		for (int i = 0; i < dim; i++){
			p[i] = new CallingPerson(c, "P" + i, i%5 != 0, (i%5 == 0) || i%2 == 0);
			p[i].start();
		}
		
		try{
			for (int i = 0; i < dim; i++){
				p[i].join();
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
	}
	
	public Centralino(int inLines, int outLines){
		this.inLines = inLines;
		this.outLines = outLines;
		outQueue = new LinkedList<>();
		outQueueP = new LinkedList<>();
	}
	
	public synchronized boolean startCallFromOut(){
		if (occupiedInLines >= inLines){
			return false;
		}
		else{
			occupiedInLines++;
			return true;
		}
	}
	
	public synchronized void closeCallFromOut(){
		occupiedInLines--;
	}
	
	public synchronized void startCallFromIn(String name, boolean dir) throws InterruptedException{
		if(dir){
			outQueueP.add(name);
		}
		else{
			outQueue.add(name);
		}
		
		while(occupiedOutLines >= outLines || ((dir) ? !name.equals(outQueueP.peek()) : outQueueP.size() > 0 || !name.equals(outQueue.peek()))){
			wait();
		}
		
		if(dir){
			outQueueP.remove();
		}
		else{
			outQueue.remove();
		}
		
		occupiedOutLines++;
		notifyAll();
		
	}
	
	public synchronized void closeCallFromIn(){
		occupiedOutLines--;
		notifyAll();
	}
	
}

class CallingPerson extends Thread{
	
	private String name;
	private boolean dir;
	private boolean origin;
	private Centralino c;
	
	public CallingPerson(Centralino c, String name, boolean origin){
		this.c = c;
		this.name = name;
		this.origin = origin;
		this.dir = dir;
	}
	
	public CallingPerson(Centralino c, String name, boolean origin, boolean dir){
		this.c = c;
		this.name = name;
		this.origin = origin;
		this.dir = dir;
	}
	
	@Override
	public void run(){
		Random r = new Random();
		
		try{
			if (origin){
				c.startCallFromIn(name, dir);
				//System.out.println("---" + origin + " " + name + " started call in direction " + dir);
				Thread.sleep(r.nextInt(200));
				c.closeCallFromIn();
				System.out.println("+++" + origin + " " + name + " finished call in direction " + dir);
				
			}
			else{
				boolean successfullCall = c.startCallFromOut();
				if (successfullCall){
					//System.out.println("---" + origin + " " + name + " started call in direction " + dir);
					Thread.sleep(r.nextInt(200));
					c.closeCallFromOut();
					//System.out.println("+++" + origin + " " + name + " finished call in direction " + dir);
				}
				else{
					//System.out.println("+++" + origin + " " + name + " is leaving unsitisfied");
				}
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
}