package hackerrank.implementation;

import java.util.Scanner;

public class JumpingOnTheCloudsRevisited {

	static int jumpingOnClouds(int[] c, int k) {
        int jumps = c.length/k, E = 100, currentCloud = 0;
        
        for (int i = 0; i < jumps; i++) {
        		currentCloud += k;
        		if (c[currentCloud % c.length] == 1) {
        			E -= 3;
        		} else {
        			E -= 1;
        		}
        }
        return E;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
        in.close();
    }
}
