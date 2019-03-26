import java.util.Scanner;

public class Solution {
   static int[] price;
   static int[] month;
   static int[] res;
   static boolean[] use;
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      
      for (int test = 1; test <= T; test++) {
         price = new int[4];
         month = new int[12];
         
         for (int i = 0; i < 4; i++) {
            price[i] = sc.nextInt();
         }
         for (int i = 0; i < 12; i++) {
            month[i] = sc.nextInt();
         }
         int[] arr = new int[12];
         res = new int[4];
         for (int i = 0; i < 12; i++) {
            arr[i] = month[i]*price[0];
            res[0]+=arr[i];
         }
         for (int i = 0; i < 12; i++) {
            if(arr[i] > price[1]) arr[i] =price[1];
            res[1] += arr[i];
         }
         res[2] = Integer.MAX_VALUE;
         use = new boolean[12];
         a(use,0,arr);
//         for (int i = 0; i < 12; i++) {
//            int tmp =0;
//            for (int j = i; j < i+3; j++) {
//               if(j<12) tmp += arr[j];
//            }
//            res[2] = Math.min(res[2], res[1]-tmp+price[2]);
//         }
         res[3] = price[3];
//         System.out.println(Arrays.toString(res));
         int result = Integer.MAX_VALUE;
         for (int i = 0; i < 4; i++) {
            result = Math.min(result, res[i]);
         }
         System.out.println("#"+test+" "+result);
      }
   }
   static void a(boolean[] use, int d,int[] arr) {
	   if(d>=12) {
		   int tmp =0;
		   int count =0;
		   for (int i = 0; i < use.length; i++) {
			   if(use[i]) {
				   for (int j = i; j < i+3; j++) {
					   if(j<12) tmp += arr[j];
				   }
				   count++;
			   }
		   }
		   res[2] = Math.min(res[2], res[1]-tmp+price[2]*count);
		   return;
	   }
	   use[d] = true;
	   a(use,d+3,arr);
	   use[d]=false;
	   a(use,d+1,arr);
   }
}