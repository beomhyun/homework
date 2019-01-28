package hwalgo7_대전_3반_김범현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hwalgo07 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Integer> list = new ArrayList<>();
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int NN =Integer.parseInt(br.readLine());
			String str2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(str2);
			for (int i = 0; i < NN; i++) {
				st2.nextToken();
				int x = Integer.parseInt(st2.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				ArrayList<Integer> tmp = new ArrayList<>();
				for (int j = 0; j < y; j++) {
					int aa = Integer.parseInt(st2.nextToken());
					tmp.add(aa);
				}
				list.addAll(x,tmp);
			}
			System.out.print("#"+test);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+list.get(i));
			}System.out.println();
		}
	}
}
