package filosofiACena;


public class Supervisor {

	private int[] priority;
	private boolean[] mustWait;
	
	private final int MAX_PRIORITY;
	
	public Supervisor(int dim, int maxPriority){
		
		priority = new int[dim];
		mustWait = new boolean[dim];
		MAX_PRIORITY = maxPriority;
		
	}
	
	public boolean cantEat(int id) {
		
		return mustWait[id];
	}
	
	public void incrementPriority(int id) {
		
		++priority[id];
		
		if(priority[id] >= MAX_PRIORITY){
			
		
			int next = (id + 1)%priority.length;
			int previous = (id - 1) >= 0 ? (id - 1) : priority.length - 1;
			
			mustWait[next] = mustWait[previous] = true;
		}
		
		
	}
	
	public void zeroPriority(int id){
		
		priority[id] = 0;
		
		int next = (id + 1)%priority.length;
		int previous = (id - 1) >= 0 ? (id - 1) : priority.length - 1;
		
		mustWait[next] = mustWait[previous] = false;
	}
	
	public void priorityState(){
		
		for(int i : priority){
			System.out.printf("%d ", i);
		}
		System.out.println();
	}
	
}

