import java.util.Scanner;

public class Solution1547 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M  = sc.nextInt();
		int r = 1;
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(r==a) r=b;
			else if(r==b) r=a;
		}
		System.out.println(r);
	}
}
