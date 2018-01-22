package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem
 * 
 * @author diogenes
 *
 */
public class TwoStrings {
	
	static String twoStrings(String s1, String s2){
		boolean[] a1 = new boolean[26];
		boolean[] a2 = new boolean[26];
		
		for (int i = 0; i < s1.length(); i++) {
			a1[s1.charAt(i)-'a'] = true;
		}
		for (int i = 0; i < s2.length(); i++) {
			a2[s2.charAt(i)-'a'] = true;
		}
		
		for (int i = 0; i < 26; i++) {
			if (a1[i] && a2[i]) {
				return "YES";
			}
		}
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
        in.close();
    }
}
