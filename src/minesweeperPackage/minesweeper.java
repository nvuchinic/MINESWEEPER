package minesweeperPackage;

import java.util.Scanner;

public class minesweeper {
	
	public static int[][] napraviTablu(int n){
		int[][] tabla=new int[n][n];
		return tabla;
	}
	
	public static void ispisiTablu(int[][] m){
		for(int i=0;i<m.length;i++){
		for(int j=0;j<m.length;j++){
			System.out.printf("%2d |",m[i][j]);
		}
		System.out.println();
		}
		System.out.println("\n");
	}
	
	public static int[][] staviMine(int[][] m){
		int min=0;
		int max=4;
		int x,y,brMina=7;
		
		while(brMina>0){
		x=min + (int)(Math.random() * ((max - min) + 1));
		y=min + (int)(Math.random() * ((max - min) + 1));
		if(m[x][y]!=-1){
			m[x][y]=-1;
			brMina--;
		}
		}
		return m;
	}
	
	public static int[][] staviBrojMina(int[][] m){
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m.length;j++){
				if(m[i][j]==-1){
					if((i-1>-1)&&(j-1>-1)){
						if	(m[i-1][j-1]!=-1)
							m[i-1][j-1]+=1;}
					
					if(i-1>-1){
						if(m[i-1][j]!=-1)
							m[i-1][j]+=1;}
					
					if((i-1>-1)&&(j+1<m.length)){
						if(m[i-1][j+1]!=-1)
							m[i-1][j+1]+=1;}
					
					if((i+1<m.length)&&(j-1>-1)){
					if(m[i+1][j-1]!=-1)
					m[i+1][j-1]+=1;}
					
					if(i+1<m.length){
					if(m[i+1][j]!=-1)
					m[i+1][j]+=1;}
					
					if((i+1<m.length)&&(j+1<m.length)){
					if(m[i+1][j+1]!=-1)
					m[i+1][j+1]+=1;}
					
					if(j-1>-1){
					if(m[i][j-1]!=-1)
					m[i][j-1]+=1;}
					
					if(j+1<m.length){
					if(m[i][j+1]!=-1)
					m[i][j+1]+=1;}
					//}
				}
			}
		}
		
		return m;
	}
	
	//public static void sakrijNule(int[][] m)
	
	public static void igrajIgru(int[][] m,int brM){
		Scanner in=new Scanner(System.in);
		int x,y;
		int[][] m2=new int[m.length][m.length];
		ispisiTablu(m2);
		int brPoteza=m.length*m.length-brM;
		while(brPoteza>0){
			System.out.println("Koje polje zelite otvoriti(unesite koordinate x i y(broj izmedju 0 i "+(m.length-1)+"):");
			x=in.nextInt();
			y=in.nextInt();
			while((x>m.length-1)&&(y>m.length-1)){
				System.out.println("Unijeli ste nedozvoljene koordinate.Pokusajte ponovo:");
				x=in.nextInt();
				y=in.nextInt();
			}
			if(m[x][y]==-1){
				System.out.println("Buuuuuuuuuum!!!\nNa tom polju je bila mina.\nKraj igre");
				break;}
			m2[x][y]=m[x][y];
			ispisiTablu(m2);
			brPoteza--;

		}
		System.out.println("Cestitam, otkrili ste sva polja bez da stanete na minu!");
		in.close();
	}
	
	public static void main(String[] args) {
		int n = 5;
		napraviTablu(n);
		int[][] matrica = new int[n][n];
		int brMina = (int) (matrica.length * matrica.length * 0.3);
		ispisiTablu(matrica);
		matrica = staviMine(matrica);
		ispisiTablu(matrica);
		matrica = staviBrojMina(matrica);
		ispisiTablu(matrica);
		igrajIgru(matrica, brMina);
	}
}




