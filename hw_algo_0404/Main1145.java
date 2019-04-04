import java.util.Scanner;

public class Main1145 {
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	//04 15 26 37
	
	static char[][] map;
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		map = new char[20][20];
		
		for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(i%2==0) {
					if(x>=0 && x<20 && y>=0 && y < 20 && (map[x][y]!='A'||map[x][y]!='B')) {
						map[x][y] = 'B';
						for (int j = 0; j < 4; j++) {
							num=0;
							check(x,y,j,'B');
							check(x,y,j+4,'B');
							if(num==4) {
								System.out.println("Black win");
								return;
							}
						}
					}else {
						i--;
					}
				}else {
					if(x>=0 && x<20 && y>=0 && y < 20 && (map[x][y]!='A'||map[x][y]!='B')) {
						map[x][y] = 'A';
						for (int j = 0; j < 4; j++) {
							num=0;
							check(x,y,j,'A');
							check(x,y,j+4,'A');
							if(num==4) {
								System.out.println("White win");
								return;
							}
						}
					}else {
						i--;
					}
				}


		}
		System.out.println("Save");
	}
	static void check(int x,int y, int dic, char bh) {
		if(x+dx[dic]>=0 && x+dx[dic] < 20 && y+dy[dic]>=0 && y+dy[dic]<20 && map[x+dx[dic]][y+dy[dic]]==bh ) {
			num++;
			check(x+dx[dic],y+dy[dic],dic,bh);
		}
	}
}
