import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1213 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			int T = Integer.parseInt(br.readLine());
			StringBuilder str1 = new StringBuilder();
			str1.append(br.readLine());
			StringBuilder str2 = new StringBuilder();
			str2.append(br.readLine());
			int count = 0;
			
			int size = str1.length();
			
			for (int i = 0; i <= str2.length()-size; i++) {
				if(str1.toString().equals(str2.substring(i, i+size))) {
					count++;
				}
			}
			System.out.println("#"+test + " "+count);
			
		}
	}
}
