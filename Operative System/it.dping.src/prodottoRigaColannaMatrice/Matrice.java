package prodottoRigaColannaMatrice;

//monitor
class Matrice
	{

		private int []riga={0,0,0};
		private boolean []entra={false,false,false};

		public synchronized void get(int ind)
			{
				riga[ind]++;
 				for(int i=0;i<3;i++)
					if(riga[i]==3)entra[i]=true;
			}


		public synchronized void set(int riga,int colonna,int valore,int [][]A)
			{
				try
					{
						if(entra[riga]==false)wait();
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				A[riga][colonna]=valore;
				notify();
			}

}

