package hackerrank.implementation;

import java.util.Scanner;

public class SockMerchant {

	static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        int[] colors  = new int[101];
        for (int i = 0; i < ar.length; i++) {
			colors[ar[i]]++;
		}
        for (int i = 0; i < colors.length; i++) {
        		pairs += colors[i] / 2;
		}
        return pairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
        in.close();
    }
}
