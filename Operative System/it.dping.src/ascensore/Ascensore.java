package ascensore;


public class Ascensore {
    boolean inUse;

    private final int capienza = 5;
    private final int numPiani;
    private boolean[] postiOccupati = new boolean[capienza];
    private int[] idPersone = new int[capienza];
    private int pianoCorrente;
    boolean dir;


    public Ascensore( int pianiPalazzo ) {
        numPiani = pianiPalazzo;

        for ( int i = 0; i < capienza; i++ ) {
            postiOccupati[i] = false;
            idPersone[i] = 0;
        }
    }//End of constructor


    public synchronized void muovi( boolean dir ){
        while ( inUse ) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        inUse = true;

        if ( dir ) { //Se l'ascensore sale
            pianoCorrente++;
            System.out.println("L'ascensore è salito al piano " + pianoCorrente );
        }
        else { //Se l'ascensore scende
            pianoCorrente--;
            System.out.println("L'ascensore è sceso al piano " + pianoCorrente );
        }

        inUse = false;
        notifyAll();

    }

    public synchronized int getPiano() {
        while ( inUse ) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        inUse = true;
        int n = pianoCorrente;
        inUse = false;
        
        notifyAll();
        

        return n;        
    }//End of getPiano

    public synchronized boolean prendi( int _id, int _f, boolean _dir ) {

        while ( inUse ) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        inUse = true;
        boolean full = true;

        for ( int i = 0; i < capienza && full; i++ ) {
            
            if ( postiOccupati[i] == false && _f == pianoCorrente && dir == _dir ) {
                postiOccupati[i] = true;
                idPersone[i] = _id;
                full = false;
                System.out.println("La persona " + _id + " è salita sull'ascensore al piano " + pianoCorrente );
            }
        }
        inUse = false;
        notifyAll();

        return (!full); //Ritorna true se siamo riusciti a salire, false se invece abbiamo trovato pieno
    }//End of prendi

    public synchronized boolean scendi(int _id, int _dest) {
        while(inUse) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        inUse = true;

        for ( int i = 0; i < capienza; i++ ) {

            if ( idPersone[i] == _id && _dest == pianoCorrente ) {

                postiOccupati[i] = false;

                System.out.println("La persona " + _id + " è scesa al piano " + _dest );
                
                inUse = false; 
                notifyAll();
                
                return true;
            }
        }
    

        inUse = false;
        notifyAll();

        return false;

    }//End of scendi

    public synchronized void setDir(boolean _dir){
       
        while ( inUse ) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        inUse = true;
        
        dir = _dir;
        
        inUse = false;
        notifyAll();

    }//End of setDir

}//End of class