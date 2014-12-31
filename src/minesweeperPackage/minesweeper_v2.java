package minesweeperPackage;
import java.io.*;
import java.util.Scanner;

public class minesweeper_v2 {
/**
 * funkcija koja pravi dvodimenzionalni niz(matrica) tipa int i vraca ga
 * @param n velicina matrice(broj redova/kolona)
 * @return vraca dvodimenzionalni int niz
 */
	public static int[][] napraviTablu(int n){
		int[][] tabla=new int[n][n];
		return tabla;
	}
	/**
	 * funkcija koja prima matricu(tipa int) i ispisuje je
	 * @param m matrica koju treba ispisati
	 */
	public static void ispisiTablu(int[][] m){
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m.length;j++){
			System.out.printf("%2d |",m[i][j]);
		}
		System.out.println();
		}
		System.out.println("\n");
	}
	/**
	 * funkcija koja prima dvodimenzonalni niz tipa string i ispisuje ga
	 * (ako element ima vrijednost null ispisuje [], a ako element ima vrijednost 0
	 * ispisuje prazno mjesto
	 * @param m dvodimenzionalni string niz
	 */
	public static void ispisiTablu2(String[][] m){
		for(int i=0;i<m.length;i++){
			for(int j=0;j<m.length;j++){
				if(m[i][j]==null)
				m[i][j]="[]";
				else if(m[i][j].equals("0"))
					m[i][j]=" ";

			System.out.printf(" %2s |",m[i][j]);
		}
		System.out.println();
		}
		System.out.println("\n");
	}
	/**
	 * funkcija koja prima matricu i puni je na odgovarajucim random mjestima vrjednoscu -1
	 * @param m matrica
	 * @return izmjenjenu matricu
	 */
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
	/**
	 * funkcija koja prima matricu, te je popunjava odgovarajucim vrjednostima
	 * (uvecava svaki element za 1 ako se on nalazi u susjedstvu elementa vrjednosti -1
	 * @param matrica
	 * @return izmjenjena matrica
	 */
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
							m[i][j+1]+=1;
						}
				}
			}
		}
		return m;
	}
		/**
		 * funkcija koja prima matricu i int broj(broj mina),te omogucava igranje igre
		 * (od korisnika trazi koordinate polja(red\kolona matrice) koje zeli otvoriti, 
		 * provjerava da li to polje sadrzi vrjednost -1(mina), ako da, zavrsava igru, ako ne,
		 * nastavlja se sve dok korisnik ne otvori sva polja bez mina odnosno dok ne otvori polje sa minom
		 * @param m matrica
		 * @param brM int broj mina
		 */
	public static void igrajIgru(int[][] m, int brM){
		Scanner in=new Scanner(System.in);
		int x,y,x2,y2;
		String[][] sm2=new String[m.length][m.length];
		ispisiTablu2(sm2);
		int brPoteza=m.length*m.length-brM;
		while(brPoteza>0){
			System.out.println("\n");
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
			sm2[x][y]=Integer.toString(m[x][y]);
			ispisiTablu2(sm2);

			

			brPoteza--;

		}
		if(brPoteza==0)
		System.out.println("Cestitam, otkrili ste sva polja bez da stanete na minu!");
		in.close();
	}
	
	public static void main(String[] args) {
		System.out.println("Navedi velicinu matrice:");
		int n = TextIO.getInt();
		napraviTablu(n);
		int[][] matrica = new int[n][n];
		int brMina = (int) (matrica.length * matrica.length * 0.3);
		//ispisiTablu(matrica);
		matrica = staviMine(matrica);
		//ispisiTablu(matrica);
		matrica = staviBrojMina(matrica);
		//ispisiTablu(matrica);
		igrajIgru(matrica, brMina);
	}
}
