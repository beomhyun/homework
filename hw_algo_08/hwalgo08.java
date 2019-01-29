package hwalgo08_3반_김범현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class hwalgo08 {
	public static Node nn = null;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test = 1; test <= 10; test++) {
			int N = Integer.parseInt(br.readLine());
			boolean check = true;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				int a = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
								
				if((c <48 || c > 57)) {
					if(!st.hasMoreTokens()) {
						check = false;
					}
				}else {
					if(st.hasMoreTokens()) {
						check = false;
					}
				}
			}
			if(check == true) {
				System.out.println("#"+test+" 1");
			}else {
				System.out.println("#"+test+" 0");
			}
		}
	}
	public static void addNode(Node node,int d,Node son) {
		if(node.data == d){
			if(node.left ==null) {
				node.left = son;
				return;
			}else if(node.right == null) {
				node.right = son;
				return;
			}
		}else {
			if(node.left!=null) {
				addNode(node.left,d,son);
			}
			if(node.right!=null) {
				addNode(node.right,d,son);
			}
		}
	}
	public static void find(Node node, int index) {
		if(node.index == index) {
			nn= node;
			return;
		}else {
			if(node.left!= null) {
				find(node.left, index);
			}
			if(node.right!= null) {
				find(node.right,index);
			}
		}
	}
}
class Node {
	int index;
	char data;
	Node left;
	Node right;
	public Node(int index, char data) {
		this.data = data;
	}
}