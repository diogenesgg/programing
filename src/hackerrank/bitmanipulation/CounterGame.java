package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * Great Problem!
 * 
 * https://www.hackerrank.com/challenges/counter-game/problem
 * 
 * @author diogenes
 *
 */
public class CounterGame {
	
	static String counterGame(long n) {
        if ( n == 1) return "Richard";
        long counter = 0;
        while (n > 1) {
        		long c = closestPowerOfTwo(n);
        		if (n == c) {
        			n = n >>> 1;
        		} else {
        			n = n - c;
        		}
        		counter++;
        }
        return counter % 2 == 0 ? "Richard" : "Louise";
    }
	
	static long closestPowerOfTwo(long n) {
		int m = getLeftmostBit(n);
		return 1l << m;
	}
	
	static int getLeftmostBit(long n) {
	    int m = 0;
	    while (n > 1 || n == -1l) {
	        n = n >>> 1;
	        m++;
	    }
	    return m;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            long n = Long.parseUnsignedLong(in.next());
            String result = counterGame(n);
            System.out.println(result);
        }
        in.close();
    }
}
