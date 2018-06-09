package ascensore;

import java.util.LinkedList;
public class Piano {
    private boolean inUse;
    private final int f; //Floor
    private LinkedList<Integer> q;
    
    public Piano(int _f) {
        inUse = false;
        f = _f;
        q = new LinkedList<Integer>();
    }//End of constructor

    public synchronized void mettitiInCoda( int _id ){
        while ( inUse ) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        inUse = true;

        q.add(_id);

        System.out.println("La persona " + _id + " si mette in fila al piano " + f );

        inUse = false;
        notifyAll();

    }  //End of mettitiInCoda

    public synchronized void lasciaLaCoda(int _id){
        while ( inUse ) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        inUse = true;

        q.removeFirst();
        //System.out.println("La persona " + _id + " lascia la coda al piano " + f );

        inUse = false;
        notifyAll();

    }  //End of lasciaLaCoda


    public synchronized int first( ){
        while ( inUse ) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        inUse = true;

        int f = q.getFirst();

        inUse = false;
        notifyAll();

        return f;
    }  //End of mettitiInCoda

    public int getPiano() {
        return f;
    }//End of getPiano

}//End of class