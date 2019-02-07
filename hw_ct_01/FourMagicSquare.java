import java.util.Arrays;
import java.util.Scanner;

public class FourMagicSquare {
	private static int[][] magic;
	private int n;
	
	public  FourMagicSquare(int n) {
		this.n = n;
		magic = new int[n][n];
		
//		for (int i = 0; i < magic.length; i++) {
//			Arrays.fill(magic[i], 0);
//		}
	}
	public FourMagicSquare() {
		this(4);
	}
	public int[][] getMagic() {
		return magic;
	}

	public void make() {
		makeA();
		makeR();
	}
	private void makeR() {
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				if((i>=0 && i<n/4)||(i>=n/4*3 && i<n)) {
					if(j>=n/4 && j<n/4*3) {
						magic[i][j] = n*n-(i*n+j);
					}
				}else {
					if((j>=0 && j<n/4)||(j>=n/4*3 && j<n)) {
						magic[i][j] = n*n-(i*n+j);
					}
				}
			}
		}
	}
	private void makeA() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] = i*n+j+1;
			}
		}
	}
	public boolean isCheck() {
		boolean isS= true;
		int [] mm = new int[2*n+2];
		for (int i = 0; i < n; i++) {
			mm[i] = sumRow(i);
			mm[i+n] = sumCol(i);
		}
		mm[2*n] =sumDia();
		mm[2*n+1]=sumAntDia();
		for (int i = 1; i < mm.length; i++) {
			if(mm[0]!=mm[i]) {
				isS =false;
				break;
			}
		}
		return isS;
	}
	private static int sumRow(int row) {
		int tot =0;
		for (int i = 0; i < magic.length; i++) {
			tot +=magic[row][i];
		}
		return tot;
	}
	private int sumCol(int col) {
		int tot = 0;
		for (int i = 0; i < magic.length; i++) {
			tot += magic[i][col];
		}
		return tot;
	}
	private int sumDia() {
		// row == col
		int tot = 0;
		for (int i = 0; i < magic.length; i++) {
			tot += magic[i][i];
		}
		return tot;
	}
	private int sumAntDia() {
		// row + col == n-1
		int tot = 0;
		for (int i = 0; i < magic.length; i++) {
			tot += magic[i][n-1-i];
		}
		return tot;
	}
	public void print() {
		System.out.printf("%d is magic? %b\n",n,isCheck());
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic[i].length; j++) {
				System.out.printf("%d\t",magic[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		FourMagicSquare odd = new FourMagicSquare(n);
		odd.make();
		odd.print();
		System.out.println("몇행의 합을 볼래 (-1이면 총합) : ");
		int k = sc.nextInt();
		if(k==-1) {
			int sum=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum += magic[i][j];
				}
			}
			System.out.println("마방진의 총합은 : "+sum);
		}else {
			System.out.printf("%d행의 합은 : %d\n",k,sumRow(k));
		}
	}
}
