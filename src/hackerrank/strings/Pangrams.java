package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/pangrams/problem
 * 
 * @author diogenes
 *
 */
public class Pangrams {

	static boolean isPangram(String s) {
		s = s.toLowerCase();
		boolean[] alphabet = new boolean[26];
		char next;
		for (int i = 0; i < s.length(); i++) {
			next = s.charAt(i);
			if (next >= 'a' && next <= 'z') {
				alphabet[s.charAt(i) - 'a'] = true;
			}
			
		}
		int sum = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i]) {
				sum++;
			}
		}
		return sum == 26;
	}
	
	public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        String s = in.nextLine();
        if (isPangram(s)) {
        		System.out.println("pangram");
        } else {
        		System.out.println("not pangram");
        }
        
        in.close();
    }
}
