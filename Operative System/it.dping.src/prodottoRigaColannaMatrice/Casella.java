package prodottoRigaColannaMatrice;

	class Casella extends Thread
	{
		private int indiceR, indiceC;
		private int [][]puntA=new int[3][3];
		private int [][]puntB=new int [3][3];
		private Matrice mt;


		public Casella(int riga,int colonna,Matrice mt,int[][] A,int[][] B)
			{
				this.indiceR=riga;
				this.indiceC=colonna;
				this.mt=mt;
				this.puntA=A;
				this.puntB=B;
			}


		public void run()
			{
				int valore=0;
				mt.get(indiceR);
				for(int i=0;i<3;i++)
					valore+=puntA[indiceR][i]*puntB[i][indiceC];
				mt.set(indiceR,indiceC,valore,puntA);
					
			}
	}