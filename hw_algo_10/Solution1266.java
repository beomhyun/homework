package WS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1266  {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int [] prime = {2,3,5,7,11,13,17};
		int [] nCr = {153,816,8568,31824,31824,8568,18};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			double AA = 0.01*A;
			double BB = 0.01*B;
			
			double tmpA = 0f;
			double tmpB = 0f;
			for (int i = 0; i < nCr.length; i++) {
				tmpA += nCr[i]*power(AA,prime[i])*power((1-AA),(18-prime[i]));
				tmpB += nCr[i]*power(BB,prime[i])*power((1-BB),(18-prime[i]));
			}
			double res = 1-(1-tmpA)*(1-tmpB);
			System.out.printf("#%d %.6f\n",test,res);
		}
	}
	static double power(double x, int n) {
		if(n==0) {
			return 1;
		}else {
			return x*power(x,n-1);
		}
	}
}
