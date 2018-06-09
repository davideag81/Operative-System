package ascensore;

import java.util.Random;
public class Palazzo {
   
    public static void main( String[] args ) {
        int numPiani = 8;
        Ascensore a = new Ascensore(numPiani);
        Motorino m = new Motorino( a, numPiani );
        Random r = new Random();
        Piano[] piani = new Piano[numPiani];

        for( int i = 0; i < numPiani; i++ ) {
            piani[i] = new Piano(i);    
        }

        m.start();


        int i = 0;

        while ( true ) {

            Persona p = new Persona( i, piani[ r.nextInt( numPiani ) ], a, numPiani );
            p.start();
            i++;

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//End of while
    }//End of main

}//End of class Palazzo