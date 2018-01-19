package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/sum-vs-xor/problem
 * 
 * @author diogenes
 *
 */
public class SumVsXOR {

	static int getLeftmostBit(long n) {
	    int m = 0;
	    while (n > 1 || n == -1l) {
	        n = n >>> 1;
	        m++;
	    }
	    return m;
	}
	
	static long solve(long n) {
		int m = getLeftmostBit(n);
		int counter = 0;
		for (int i = 0; i < m; i++) {
			if ( n % 2 == 0) {
				counter++;
			}
			n = n >>> 1;
		}
		if (counter == 0) return 1;
		
		long result = 2;
		for ( int i = 1; i < counter; i++) {
			result *= 2;
		}
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long result = solve(n);
        System.out.println(result);
        in.close();
    }
}
