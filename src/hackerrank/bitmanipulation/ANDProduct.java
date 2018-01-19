package hackerrank.bitmanipulation;

import java.util.Collections;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/and-product/problem
 * 
 * @author diogenes
 *
 */
public class ANDProduct {

	static long andProduct(long a, long b) {
		// Complete this function
		String bitsA = Long.toBinaryString(a);
		String bitsB = Long.toBinaryString(b);
		if (bitsA.length() < 32) {
			bitsA = String.join("", Collections.nCopies(32 - bitsA.length(), "0")) + bitsA;
		}
		if (bitsB.length() < 32) {
			bitsB = String.join("", Collections.nCopies(32 - bitsB.length(), "0")) + bitsB;
		}

		byte a_i, b_i;
		long r = 0;
		boolean stopSuming = false;
		for (int i = 0; i < bitsA.length(); i++) {
			a_i = bitsA.charAt(i) == '1' ? (byte)1 : (byte)0;
			b_i = bitsB.charAt(i) == '1' ? (byte)1 : (byte)0;
			if (stopSuming) {
				r =  (r << 1);
			} else {
				r =  (r << 1) + (a_i & b_i);
			}
			
			if ((a_i ^ b_i) == 1) {
				stopSuming = true;
			}
		}

		return r;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for(int a0 = 0; a0 < n; a0++){
			long a = in.nextLong();
			long b = in.nextLong();
			long result = andProduct(a, b);
			System.out.println(result);
		}
		in.close();
	}
}
