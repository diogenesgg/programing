package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/xor-se/problem
 * Very difficult one.
 * 
 * @author diogenes
 *
 */
public class XorSequence {
	
	static long calc(long a) {
	    long res[] = {a, a, 2, 2, a+2, a+2, 0, 0};    
	    return res[(int) (a%8)];
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            long L = in.nextLong();
            long R = in.nextLong();
            System.out.println(calc(R) ^ calc(L-1));
        }
        in.close();
    }
}
