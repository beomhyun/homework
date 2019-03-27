import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<nod> list = new ArrayList<>();
			int max = 0;
			for (int i = 0; i < n; i++) {
				int tmp = sc.nextInt();
				list.add(new nod(i, tmp));
				if(tmp > max ) max = tmp;
			}
			for (int i = 0; i < list.size() ; i++) {
				while(true) {
					boolean c = false;
					for (int j = i; j < list.size(); j++) {
						if(list.get(i).prio < list.get(j).prio) {
							nod tmp = list.get(i);
							list.remove(i);
							list.add(tmp);
							c=true;
							break;
						}
					}
					if(!c) break;
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).index==m) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
	static class nod{
		int index;
		int prio;
		public nod(int index, int prio) {
			super();
			this.index = index;
			this.prio = prio;
		}
		@Override
		public String toString() {
			return ""+index;
		}
		
	}
}
