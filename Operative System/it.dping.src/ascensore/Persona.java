package ascensore;

import java.util.Random;
public class Persona extends Thread {
    private int id;
    private int destinazione;
    Piano p;
    Ascensore a;
    boolean onBoard;
    boolean dir; //true se deve andare su, false se deve andare giù


    public Persona( int _id, Piano _p, Ascensore _a, int maxPiani){
        id = _id;
        p = _p;
        a = _a;
        Random r = new Random();
        do {
            destinazione = r.nextInt(maxPiani);
        }
        while ( destinazione == p.getPiano() );

        if ( destinazione > p.getPiano() ) {
            dir = true;
        }
        else {
            dir = false;
        }

        onBoard = false;
    }//end of constructor

    public void run() {
        p.mettitiInCoda(id);

        while ( true ) {
            if ( onBoard ) { //La persone è già sull'ascensore
                if ( a.scendi(id, destinazione) ) {
                    Thread.currentThread().stop();
                }
            }
            else { //La persona non è sull'ascensore
                if( id == p.first() ) {
                    if ( a.prendi(id, p.getPiano(), dir ) ) {
                        p.lasciaLaCoda(id);
                        onBoard = true;
                    }
                }
            }
        }
    }//End of run

}//End of class Persona