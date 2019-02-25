import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution1257 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			
			StringBuilder str = new StringBuilder(br.readLine());
			TreeSet<String> arr = new TreeSet<>();
			for (int i = 0; i <=str.length();  i++) {
				for (int j = 0; j <= str.length()-i; j++) {
					arr.add(str.substring(i,j+i));
				}
//				arr[i] = str.substring(i);
			}
			int count=0;
			boolean check=false;
			for(String tmp : arr) {
				count++;
				if(count==n+1) {
					System.out.println("#"+test+" "+tmp);
					check=true;
				}
			}
			if(!check) {
				System.out.println("#"+test+" "+"none");
			}
		}
	}

}
