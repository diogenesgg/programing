package hackerrank.implementation;

import java.util.Scanner;

public class SequenceEquation {

	static int[] permutationEquation(int[] p) {
		int[] inverse = new int[p.length];
		
        for (int x = 1; x < p.length; x++) {
        		inverse[p[x]] = x;
        }
        
        int[] result = new int[p.length];
        
        for (int x = 1; x < p.length; x++) {
	    		result[x] = inverse[inverse[x]];
	    }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n + 1];
        for(int p_i = 1; p_i <= n; p_i++){
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 1; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        in.close();
    }
}
