package matriztestluis;

public class Main {
	public static void cambiaMatriz(char[][] m,int c){
        if(m!=null && c<=m[0].length){
             int col = c, fil = 0;
             while(col<m[0].length-1 && fil<m.length-1){
                       col++;
                       fil++;
                       if(m[0][c] == m[fil][col]) m[fil][col] = '-';
              }
              col = c ;
              fil = 0;
             while(col>0 && fil<m.length-1){
                       col--;
                       fil++;
                       if(m[0][c] == m[fil][col]) m[fil][col] = '-';
              }
       }
	}
	public static void showMatriz(char[][] m) {
		if(m!=null) {
			for(int i = 0; i<m.length; i++) {
				for(int j = 0; j<m[0].length; j++) {
					System.out.print(m[i][j]+" ");
				}
				System.out.print("\n");
			}
		}
	}
	public static void main(String[] args) {
		char[][] m = {{'y','g','g','b','g','r'},
				       {'b','g','b','b','b','y'},
				       {'g','g','y','y','r','b'},
				       {'b','b','r','y','y','y'}};
		showMatriz(m);
		System.out.print("\n");
		cambiaMatriz(m,3);
		showMatriz(m);
	}

}
