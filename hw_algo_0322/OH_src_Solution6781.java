import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution6781 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			String sb1 = br.readLine();
			String sb2 = br.readLine();
			
			card[] arr = new card[9];
			for (int i = 0; i < 9; i++) {
				arr[i] = new card(sb1.charAt(i)-'0', sb2.charAt(i));
			}
			Arrays.sort(arr,new Comparator<card>() {

				@Override
				public int compare(card o1, card o2) {
					if(o1.color==o2.color) {
						return o1.num>o2.num?1:-1;
					}else {
						return o1.color>o2.color?1:-1;
					}
				}
			});
			
		}
	}
	static void perm(ArrayList<card> list, int d) {
		if(list.size()==d) {
			return;
		}
		
	}
	static class card{
		int num;
		char color;
		public card(int num, char color) {
			super();
			this.num = num;
			this.color = color;
		}
		
	}
}
