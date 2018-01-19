package hackerrank.bitmanipulation;

import java.util.Arrays;
import java.util.Scanner;

/***
 * https://www.hackerrank.com/challenges/yet-another-minimax-problem/problem
 * 
 * @author diogenes
 * 
 * Shit! I received timeout for input with all 0's.
 *  
 */
public class YetAnotherMinimaxProblem {

	static int anotherMinimaxProblem(int[] a) {
		
		while (hasSameHighestBit(a)) {
			removeHighestBit(a);
		}
		
		Arrays.sort(a);
		
		int max = maxHighestBit(a);
		
		int division = 0;
		for (int i = 1; i < a.length; i++) {
			if (Integer.highestOneBit(a[i]) == max) {
				division = i;
				break;
			}
		}
		
		// [0, division-1] left side
		// [division, n - 1] right side
		
		//combine all left side with Right side?
		int minXor = Integer.MAX_VALUE, curXor = 0;
		
		for (int i = 0; i < division; i++) {
			for (int j = division; j < a.length; j++) {
				curXor = a[i] ^ a[j];
				if (curXor < minXor) {
					minXor = curXor;
				}
			}
		}
		
		return minXor;
	}
	
	static boolean hasSameHighestBit(int[] a) {
		int h_a, h_b;
		for (int i = 1; i < a.length; i++) {
			h_a = Integer.highestOneBit(a[i]);
			h_b = Integer.highestOneBit(a[i-1]);
			if (h_a != h_b || h_a == 0 || h_b == 0) {
				return false;
			}
		}
		return true;
	}
	
	static void removeHighestBit(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] ^ Integer.highestOneBit(a[i]);
		}
	}
	
	static int maxHighestBit(int[] a) {
		int max = Integer.highestOneBit(a[0]);
		for (int i = 1; i < a.length; i++) {
			if (Integer.highestOneBit(a[i]) > max) {
				max = Integer.highestOneBit(a[i]);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for(int a_i = 0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int result = anotherMinimaxProblem(a);
		System.out.println(result);
		in.close();
	}
}
