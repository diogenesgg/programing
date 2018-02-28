package hackerrank.implementation;

import java.util.Scanner;

public class JumpingOnTheClouds {

	static int jumpingOnClouds(int[] c) {
        int i = 0, jumps = 0;
        while (i < c.length - 1) {
        		if (i+2 < c.length && c[i+2] == 0) {
        			i+=2;
        			jumps++;
        		} else if (i+1 < c.length && c[i+1] == 0) {
        			i+=1;
        			jumps++;
        		}
        }
        return jumps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }
}
