package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 * 
 * @author diogenes
 *
 */
public class PalindromeIndex {

	static int palindromeIndex(String s) {
		for ( int i = 0, j = s.length() - 1; i <= (s.length()-1) / 2; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				if (isPalindrome(new StringBuilder(s).deleteCharAt(i))) {
					return i;
				}
				if (isPalindrome(new StringBuilder(s).deleteCharAt(j))) {
					return j;
				}
			}
		}
        return -1;
    }
	
	static boolean isPalindrome(StringBuilder b) {
		for (int i = 0; i < b.length() / 2; i++) {
			if (b.charAt(i) != b.charAt(b.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = palindromeIndex(s);
            System.out.println(result);
        }
        in.close();
    }
}
