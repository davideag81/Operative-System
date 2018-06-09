package ascensore;

public class Motorino extends Thread {
    private Ascensore a;
    boolean direction; //true == up, false == down
    private final int numPiani;

    public Motorino( Ascensore _a, int _numPiani ) {
        a = _a;
        direction = true;
        numPiani = _numPiani;
    }//End of constructor

    public void run() {
        while( true ) {
            if ( a.getPiano() == numPiani ) {
                direction = false;
                a.setDir(direction);
            }
            if ( a.getPiano() == 0 ) {
                direction = true;
                a.setDir(direction);
            }
            a.muovi(direction);

            try {
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }//End of while
    }//End of run

}//End of class Motorino