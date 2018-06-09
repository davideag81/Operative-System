package balloDiGala;


public class GalaDiningMonitor {

	private static final int NUM_STUDENTS = 10;
	
	public static void main(String[] args){
		
		Student students[] = new Student[NUM_STUDENTS];
		Table table = new Table();
		
		for(int i = 0; i < NUM_STUDENTS; ++i)
			students[i] = new Student(i, table);
	}
}
