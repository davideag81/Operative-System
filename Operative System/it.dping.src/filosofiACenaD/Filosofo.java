package filosofiACenaD;

import java.util.Random;

class Filosofo extends Thread{
    private int aging =0;
    private int forchettaSX = 0;
    private Forchette f;
    private Random rand = new Random();
    
    public int get_Aging(){
        return aging;
    }

    public Filosofo(int n, Forchette f1){ //costruttore
        super(Integer.toString(n));
        forchettaSX = n;
        f = f1;
    }
    
    public void pensa(){
        try{
            int num=rand.nextInt(3001);
            sleep(num);
            System.err.println(getName() + " ha pensato per " + num + " millisecondi.");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void mangia(){
        try{
            int num=rand.nextInt(3001);
            sleep(num);
            aging++;
            System.err.println(getName() + " ha mangiato per la " + aging + " volta per " + num + " millisecondi.");
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    //il filosofo prima pensa e poi mangia
    public void run(){ //qui sono contenute tutte le azioni
        /* 
        Appunto: Ogni filosofo aspetta che tutti gli altri finiscano prima di
         passare alla seconda portata.
        */
        try{
            boolean vuoleMangiare = true;
            boolean vuolePensare = true;
            while(vuolePensare){
                pensa();
                vuolePensare = false;
                while(vuoleMangiare){
                    if( (f.prendiForchette(forchettaSX) == true ) && (vuolePensare == false) ){ //se non riesce a prendere le forchette   
                    }
                    else{
                        mangia();
                        f.rilasciaForchette(forchettaSX);
                        vuoleMangiare = false;
                        vuolePensare = true;
                    }
                }
                vuoleMangiare=true;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}    

