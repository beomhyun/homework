import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution1238 {
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			visit = new boolean[101];
			boolean[][] edge = new boolean[101][101];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			while(st2.hasMoreTokens()){
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
				edge[a][b] = true;
			}
			ArrayList<Integer> list = new ArrayList<>();
			list.add(start);
			contact(edge, list, start,test);
			
		}
	}//main
	static void contact(boolean[][]edge,ArrayList<Integer> list,int nowmax,int test) {
		int newmax = -1;
		ArrayList<Integer> newlist = new ArrayList<>();
		for(int i : list) {
			for (int j = 0; j < 101; j++) {
				if(!visit[j] && edge[i][j]) {
					visit[j] = true;
					newlist.add(j);
					if(newmax < j) {
						newmax= j;
					}
				}
			}
		}
		if(newmax == -1) {
			System.out.println("#"+test+" "+nowmax);
			return;
		}
		contact(edge, newlist, newmax, test);
		
	}
}
