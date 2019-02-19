import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution1251 {
	static int N,E;
	static int[] parent;	//disjoint set 에서 각 정점의 부모(대표자) 정보를 저장하는 배열
	static boolean[] visit;
	static ArrayList<Edge> mst;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			
			N = Integer.parseInt(br.readLine());
			parent = new int[N+1];
			mst = new ArrayList<>();
			pq = new PriorityQueue<>(new EdgeComparator());
			
			StringTokenizer x = new StringTokenizer(br.readLine());
			StringTokenizer y = new StringTokenizer(br.readLine());
			long [][]arr = new long[N+1][2];
			for (int i = 1; i <= N; i++) {
				arr[i][0] = Long.parseLong(x.nextToken());
				arr[i][1] = Long.parseLong(y.nextToken());
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <=N; j++) {
					if(i==j) continue;
					long value = (long) (Math.pow((arr[i][0]-arr[j][0]),2)+Math.pow((arr[i][1]-arr[j][1]),2));
					Edge e1 = new Edge(i, j, value);
					pq.add(e1);
				}
			}
			E = pq.size();
			double EE = Double.parseDouble(br.readLine());
			
			kruskal();
			//System.out.println(mst);
			long result = 0;
			for (Edge e : mst) {
				result += e.value;
			}
			
			System.out.printf("#%d %d\n",test,Math.round(result*EE));
//			System.out.println("#"+test+" "+ result*EE);
		}
	}
	static void kruskal() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for(int i=0; i<E; i++) {
			Edge edge = pq.poll();
			if(find(edge.start) == find(edge.end)){
				continue;
			}
			union(edge.start,edge.end);
			mst.add(edge);
		}
	}
	static int find(int n) {
		if(n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}
	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1!=p2) {
			parent[p1] = p2;
		}
	}
	static class EdgeComparator implements Comparator<Edge>{
		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value>o2.value?1:-1;
		}
	}
	static class Edge{
		int start;
		int end;
		long value;
		public Edge(int start, int end, long value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value + "]";
		}
	}
}