package hackerrank.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 * 
 * @author diogenes
 *
 */
public class AppleAndOrange {
	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int larryScore = 0;
        int robScore = 0;
        
        int dist;
        for (int i = 0; i < apples.length; i++) {
        		dist = apples[i] + a;
        		if (dist >= s && dist <= t) {
        			larryScore++;
        		}
        }
        
        for (int i = 0; i < oranges.length; i++) {
	    		dist = oranges[i] + b;
	    		if (dist >= s && dist <= t) {
	    			robScore++;
	    		}
	    }
        
        System.out.println(larryScore);
        System.out.println(robScore);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i = 0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i = 0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        countApplesAndOranges(s, t, a, b, apple, orange);
        in.close();
    }
}
