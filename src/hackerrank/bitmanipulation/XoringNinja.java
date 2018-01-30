package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/xoring-ninja/problem
 * 
 * Crazy problem. I had to implement the naive solution and then search for a pattern.
 * 
 * @author diogenes
 *
 */
public class XoringNinja {

	static int allCombs(int[] arr, int level, int chosen)  {
		if (level == arr.length) {
			return chosen;
		}
		return allCombs(arr, level + 1, chosen ^ arr[level]) + allCombs(arr, level + 1, chosen);
	}
	
	static int xoringNinja(int[] arr) {
		int or = 0;
		for (int i = 0; i < arr.length; i++) {
			or = or | arr[i];
		}
		for (int i = 0; i < arr.length - 1; i++) {//n-1 loop
			or = or << 1;
			or = or % 1000000007;
		}
		return or;
	}
	
	public static void main(String[] args) {
		int T, n;
		
		Scanner in = new Scanner(System.in);
		
		T = in.nextInt();
		for (int t = 0; t < T; t++) {
			n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			System.out.println(xoringNinja(arr));
		}
		in.close();
    }
}
