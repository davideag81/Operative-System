package filosofi;

public class Forchette {
		private int numForchette;
		int [] statoForchette;

		//costruttore
		public Forchette(int n){
			numForchette=n;
			statoForchette = new int[numForchette];
			for(int i=0;i<numForchette;i++){
				statoForchette[i]=-1;
			}

		}

		public synchronized void prendiForchette(int numFilosofo){
			int forchettaSinistra, forchettaDestra;
			forchettaSinistra=numFilosofo;
			forchettaDestra=(numFilosofo+1)%5;

			System.out.println(Thread.currentThread().getName() + " sta cercando di prendere le forchette" + forchettaSinistra + " e " + forchettaDestra);

			while(statoForchette[forchettaSinistra]!=numFilosofo && statoForchette[forchettaSinistra]!=numFilosofo){
				if(statoForchette[forchettaSinistra]!=-1){//se è occupata
					try{
						System.out.println(Thread.currentThread().getName() + " sta aspettando il filosofo " + statoForchette[forchettaSinistra]);
						wait();
					} catch(InterruptedException ex){
						ex.printStackTrace();
					}
				}
				statoForchette[forchettaSinistra]=numFilosofo;
				System.out.println(Thread.currentThread().getName() + " ha preso la forchetta " + forchettaSinistra);
				//se sono arrivato qui vuol dire che ho la prima forchetta

				if(statoForchette[forchettaDestra]!=-1){
					//non ho motivo di trattenere la prima quindi la rilascio
					statoForchette[forchettaSinistra]=-1;
					try{
						System.out.println(Thread.currentThread().getName() + " sta aspettando il filosofo " + statoForchette[forchettaDestra] + " ***ricomincio tutto da capo***");
						wait();
					} catch(InterruptedException ex){
						ex.printStackTrace();
					}
				} else {
					statoForchette[forchettaDestra]=numFilosofo;
					System.out.println(Thread.currentThread().getName() + " ha preso la forchetta " + forchettaDestra);
				}
			}
			System.out.println(Thread.currentThread().getName() + " ha ottenuto ambedue le forchette.");
		}

		public synchronized void rilasciaForchette(int numFilosofo){
			int forchettaSinistra, forchettaDestra;
			forchettaSinistra=numFilosofo;
			forchettaDestra=(numFilosofo+1)%5;
		}
}
