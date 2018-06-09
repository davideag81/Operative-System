package filosofiACenaD;


public class Forchette{ //monitor
    private boolean[] forchette = new boolean[5];
    private int readSX = 0;
    
    public Forchette(){
        for(int i=0; i<5; i++){
            forchette[i] = false;
        }
    }
    public synchronized boolean prendiForchette(int mano){
        try{
            if(forchette[mano]){
                wait();
                System.err.println("Il filosofo " + Thread.currentThread().getName() + " ha trovato occupata una delle due forchette e aspetta");
                return true;
            }
            else{
                if(forchette[ (mano+1)%5 ] ){
                    wait();
                    System.err.println("Il filosofo " + Thread.currentThread().getName() + " ha trovato occupata una delle due forchette e aspetta");
                    return true;
                }
                else{
                    forchette[mano] = true;
                    forchette[ (mano+1)%5 ] = true;
                    return false;
                }
            }
        } 
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public synchronized void rilasciaForchette(int mano){
        forchette[mano] = false;
        forchette[(mano+1)%5] = false;
        System.err.println("Il filosofo " + Thread.currentThread().getName() + " posa le forchette");
        notifyAll();
    }
}