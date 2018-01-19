package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-great-xor/problem
 * 
 * @author diogenes
 *
 */
public class TheGreatXOR {

	static int getLeftmostBit(long n) {
	    int m = 0;
	    while (n > 1 || n == -1l) {
	        n = n >>> 1;
	        m++;
	    }
	    return m;
	}
	
	static long theGreatXor(long x){
		int m = getLeftmostBit(x);
		long allOne =  1l;
		for (int i = 0; i < m; i++) {
			allOne = (allOne << 1) + 1;
		}
		return allOne - x;
    }

    public static void main(String[] args) {;
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            long result = theGreatXor(x);
            System.out.println(result);
        }
        in.close();
    }
}
