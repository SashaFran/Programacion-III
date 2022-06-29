package NReinas;

public class Tablero {

	int tam;
	String reina[] = new String[7];
	String vacio[] = new String[7];
	String tablero[];
    int matriz[][];

	public Tablero()
	{
		reina[0] = "---0-0-0---";
		reina[1] = "|  0 0 0  |";
		reina[2] = "|   0 0   |";
		reina[3] = "|   0 0   |";
		reina[4] = "|   0 0   |";
		reina[5] = "|  0 0 0  |";
		reina[6] = "--0000000--";
		
		vacio[0] = "-----------";
		vacio[1] = "|         |";
		vacio[2] = "|         |";
		vacio[3] = "|         |";
		vacio[4] = "|         |";
		vacio[5] = "|         |";
		vacio[6] = "-----------";
	}
	
	public void setMatriz(int[][] matriz)
	{
		this.matriz = matriz;
		this.tam = matriz.length;
		tablero = new String[tam * 7];
	}

	public void construye()
	{
		int h = 0;
		for(int i = 0; i < tam * 7; i++)
			tablero[i] = "";
		for(int i = 0 ; i < tam; i++)
		{
			for(int j = 0; j < 7; j++)
			{
				for(int k = 0; k < tam; k++)
					if(matriz[i][k] == 1)
						tablero[h] += reina[j]; 
					else
						tablero[h] += vacio[j];
				h++;
			}			
		}
	}
	
	public void mostrar()
	{
		System.out.println("|===================================== Tablero =============================================|");
		for(int i = 0; i < tablero.length; i++)
			System.out.println(tablero[i]);
	}
}
