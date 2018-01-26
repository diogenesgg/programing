package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/common-child/problem
 * 
 * Longest common subsequence Problem
 * 
 * @author diogenes
 *
 */
public class CommonChild {

	static int commonChild(String s1, String s2){
		int[][] lcc = new int[s1.length()][s1.length()]; //longest common child
		
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					lcc[i][j] = getSafely(lcc, i-1, j-1) + 1;
				} else {
					lcc[i][j] = Math.max(getSafely(lcc, i-1, j), getSafely(lcc, i, j-1));
				}
			}
		}
		
		return lcc[s1.length() - 1][s1.length() - 1];
    }
	
	static int getSafely(int[][] lcc, int i, int j) {
		if (i < 0 || i >= lcc.length || j < 0 || j >= lcc.length) {
			return 0;
		}
		return lcc[i][j];
	}
	
	static boolean isAllMinusOne(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				return false;
			}
		}
		return true;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = commonChild(s1, s2);
        System.out.println(result);
        in.close();
    }
}
