import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution2819 {
	static HashSet<String> result;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <=T; test++) {
			int [][]arr = new int[4][4];
			result = new HashSet<>();
			stack = new Stack<>();
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					backtraking(arr,0,i,j);
				}
				//System.out.println(result);
			}
			System.out.println("#"+test+" "+result.size());
			
		}
	}
	static void backtraking(int[][] arr, int deapth, int i, int j) {
		if(deapth == 7) {
			String str = "";
			for (int k = 0; k < stack.size(); k++) {
				str = str+stack.get(k);
			}
			result.add(str);
			return;
		}
//		if(!stack.isEmpty() && stack.peek() == arr[i][j]) {
//			return;
//		}
			if(i>0) {
//				System.out.println("test1");
				stack.push(arr[i][j]);
				backtraking(arr, deapth+1, i-1, j);
				stack.pop();
			}
			if(i<3) {
//				System.out.println("test2");
				stack.push(arr[i][j]);
				backtraking(arr, deapth+1, i+1, j);
				stack.pop();
			}
			if(j>0) {
//				System.out.println("test3");
				stack.push(arr[i][j]);
				backtraking(arr, deapth+1, i, j-1);
				stack.pop();
			}
			if(j<3) {
//				System.out.println("test4");
				stack.push(arr[i][j]);
				backtraking(arr, deapth+1, i, j+1);
				stack.pop();
			}
			
	}
}
