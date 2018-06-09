package filosofiACenaD;
import java.util.Random;

/*
Problema dei filosofi di Dijkstra.

Possibile implementazione di buffer circolare.

Problemi possibili:
- Deadlock -> il filosofo è costretto a posare la forchetta sinistra nel caso ne abbia una sola.
- Posticipazione indefinita -> meccanica invecchiamento dentro filosofi.

Filosofo -> Thread:
costruttore
pensa()
prendiForchettaSX()
prendiForchettaDX()
mangia() [incrementa indice invecchiamento] -> RUN
rilasciaForchettaSX() 
rilasciaForchette()
getAging()


Forchetta -> Monitor
risorsa condivisa -> forchetta[5]
costruttore
booleano inUso
getStatus()
setStatus()

*/

public class FilosofiACena {
    public static void main(String [] args){
        Filosofo[] filo = new Filosofo[5];
        Forchette forch = new Forchette();
        for(int i=0; i<5; i++){
            filo[i] = new Filosofo(i, forch);
            filo[i].start();
        }
        System.err.println("Main terminato...");
    } 
}

