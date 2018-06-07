package ponteSenzoUnico;
import java.util.Random;
public class Main {

	public static void main(String[] args) throws Exception{
        Random r = new Random();
        Provenienza[] direzione = new Provenienza[2];
        direzione[0] = Provenienza.NORD;
        direzione[1] = Provenienza.SUD;
         
        Ponte ponte = new Ponte();
        int numeroAuto = 10;
        Auto[] auto = new Auto[numeroAuto];

        for(int i = 0; i < numeroAuto; i++){
            auto[i] = new Auto(direzione[r.nextInt(2)], ponte, i);
        }
        for(int i = 0; i < auto.length; i++){
        	auto[i].start();
        }
        for(int i = 0; i < auto.length; i++){
        	auto[i].join();
        }
    //    System.out.println("Sul ponte sono passate " + ponte.getAutoPassate() + " auto.");
   

	}

}
