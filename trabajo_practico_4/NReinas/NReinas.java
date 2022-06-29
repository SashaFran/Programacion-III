package NReinas;

public class NReinas {

	int n;
	public NReinas(int n){
		this.n = n;
	}
	
	public boolean noSeAtacan(int tablero[][], int fila, int col){
		for(int i = 0; i < col; i++)
			if (tablero[fila][i] == 1)
				return false;
		for(int i = fila, j = col; i >= 0 && j >= 0; i--, j--)
			if (tablero[i][j] == 1)
				return false;
		for(int i = fila, j = col; j >= 0 && i < n; i++, j--)
			if (tablero[i][j] == 1)
				return false;
		return true;
	}

	public boolean resolucionBacktracking(int tablero[][], int col){
		if(col >= n)
			return true;
		for(int i = 0; i < n; i++){ 
			if(noSeAtacan(tablero, i, col))
			{
				tablero[i][col] = 1; // Intentamos poner la reina estamos bajando una rama en el arbol
				if(resolucionBacktracking(tablero, col + 1) == true)
					return true;
				tablero[i][col] = 0; // Backtracking estamos volviendo a poner en 0
			}
		}
		return false;
	}

	public int[][] resolver(){
		int[][] tablero = new int[n][n];
		if (resolucionBacktracking(tablero, 0) == false){
			System.out.print("Lo sentimos no lo podemos resolver por Backtraking");
			return tablero;
		}
		return tablero;
	}
}
