import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class J1828 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] item = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			item[i][0] =a;
			item[i][1] =b;
		}//입력
		
		Arrays.sort(item,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]>o2[1] ? 1 : -1;
				//2>1 
			}
		});
//		for (int i = 0; i < item.length; i++) {
//			System.out.println(Arrays.toString(item[i]));
//		}
		
		
		int ref=-100000;
		int refcount = 0;
		for (int i = 0; i < item.length; i++) {
			if(item[i][0] > ref) {
				ref = item[i][1];
				refcount++;
			}
//			System.out.println(ref);
		}
		System.out.println(refcount);
		
	}
	
}
