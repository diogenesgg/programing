package hackerrank.implementation;

import java.util.Scanner;

public class BetweenTwoSets {

	static int getTotalX(int[] a, int[] b) {
        int total = 0;
        
        boolean satisfies;
        for (int x = 1; x <= 100; x++) {
        		satisfies = true;
        		for (int i = 0; i < a.length && satisfies; i++) {
        			if (x % a[i] != 0) {
        				satisfies = false;
        			}
        		}
        		for (int i = 0; i < b.length && satisfies; i++) {
        			if (b[i] % x != 0) {
        				satisfies = false;
        			}
        		}
        		if (satisfies) {
        			total++;
        		}
        }
        
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}
