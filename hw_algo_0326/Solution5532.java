import java.util.Scanner;

public class Solution5532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int A = sc.nextInt();
		int B =sc.nextInt();
		int C =sc.nextInt();
		int D =sc.nextInt();
		
		if(A%C==0) A /=C;
		else A=A/C+1;
		if(B%D==0) B /=D;
		else B=B/D+1;
		
		System.out.println(L-Math.max(A, B));
	}
}
