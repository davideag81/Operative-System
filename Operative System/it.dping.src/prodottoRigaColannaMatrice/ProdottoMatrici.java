package prodottoRigaColannaMatrice;
/*
calcolare il prodotto riga colonna tra due matrici e il risultato
metterlo nella prima matrice:
A=A*B
*/
public class ProdottoMatrici {

			public static void main (String []args)
				{
				 	Matrice mt=new Matrice();
					int riga=0,colonna=0;
					int [][]A=new int [3][3];
					int [][]B=new int[3][3];
					Casella []cs=new Casella[9];

					for(int i=0;i<3;i++)
						for(int j=0;j<3;j++)
							{
								A[i][j]=j+1;
								B[i][j]=j+1;
							}


					for(int i=0;i<9;i++)
						{
							cs[i]=new Casella(riga,colonna,mt,A,B);
							//System.out.println("valore colonna:"+colonna+"\nvalore riga:"+riga);
							colonna++;
							if(colonna==3)
								{
									colonna=0;
									riga++;
								}
						}

					
					for(int i=0;i<9;i++)
							cs[i].start();

					try
				  	{	
							for(int i=0;i<9;i++)
									cs[i].join();						
				  	}
				  catch(InterruptedException e)
				  	{
				       e.printStackTrace();
				  	}

					for(int i=0;i<3;i++)
						for(int j=0;j<3;j++)
							System.out.println("valori della tabella, riga "+i+" colonna "+j+": "+A[i][j]);
				}

				
		}