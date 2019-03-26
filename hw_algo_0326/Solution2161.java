import java.util.ArrayList;
import java.util.Scanner;

public class Solution2161 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		if(n==1) {
			System.out.println(1);
		}
		for (int i = 1; i <= n; i++) {
			if(i%2==0) {
				list.add(i);
			}
		}
//		System.out.println(list.get(list.size()));
		while(list.size()>0) {
			
			if(list.size()>1) list.remove(0);
			if(list.size()==0) break;
			if(list.size()==1) {
				System.out.println(list.get(0));
				break;
			}
			int tmp = list.get(0);
			list.remove(0);
			list.add(tmp);
		}
	}
}
