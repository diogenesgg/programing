package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/richie-rich/problem
 * 
 * Very difficult one.
 * 
 * @author diogenes
 *
 */
public class RichieRich {

	static String richieRich(String s, int n, int k) {
		StringBuilder out = new StringBuilder(s);

		int wrongPairs = 0;
		for (int i = 0; i < n/2; i++) {
			if (out.charAt(i) != out.charAt(n - 1 - i)) {
				wrongPairs++;
			}
		}

		int i = 0;
		while (k > 0 && (i < n/2)) {
			if (out.charAt(i) == out.charAt(n - 1 - i) && out.charAt(i) != '9') {
				if (k-2 >= wrongPairs && k >= 2) {
					out.setCharAt(i, '9');
					out.setCharAt(n - 1 - i, '9');
					k -= 2;
					i++;
					continue;
				}
			}
			if (out.charAt(i) != out.charAt(n - 1 - i) && (out.charAt(i) == '9' || out.charAt(n - 1 - i) == '9')) {
				out.setCharAt(i, '9');
				out.setCharAt(n - 1 - i, '9');
				wrongPairs--;
				k--;
				i++;
				continue;
			}
			if (out.charAt(i) != out.charAt(n - 1 - i) && out.charAt(i) != '9' && out.charAt(n - 1 - i) != '9') {
				if ( k - 1 >= wrongPairs && k >= 2) {
					out.setCharAt(i, '9');
					out.setCharAt(n - 1 - i, '9');
					wrongPairs--;
					k -= 2;
					i++;
					continue;
				}
				if (k >= wrongPairs) {
					if (out.charAt(i) > out.charAt(n - 1 - i)) {
						out.setCharAt(n - 1 - i, out.charAt(i));
					} else {
						out.setCharAt(i, out.charAt(n - 1 - i));
					}
					wrongPairs--;
					k--;
					i++;
					continue;
				}
			}
			i++;
		}

		if (n%2 == 1 && k > 0) {
			out.setCharAt(n/2, '9');
		}

		if (isPalindrome(out)) {
			return out.toString();
		} else {
			return "-1";
		}
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
		int n = in.nextInt();
		int k = in.nextInt();
		String s = in.next();
		String result = richieRich(s, n, k);
		System.out.println(result);
		in.close();
	}
}
