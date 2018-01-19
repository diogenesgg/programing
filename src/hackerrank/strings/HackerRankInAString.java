package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 * 
 * @author diogenes
 *
 */
public class HackerRankInAString {

	static String hackerrankInString(String s) {
        char[] hackerrank = {'h','a','c','k','e','r','r','a','n','k'};
        int k = 0;
        for (int i = 0; i < s.length() && k < hackerrank.length; i++) {
        		if (s.charAt(i) == hackerrank[k]) {
        			k++;
        		}
        }
        if (k < hackerrank.length) {
        		return "NO";
        } else {
        		return "YES";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = hackerrankInString(s);
            System.out.println(result);
        }
        in.close();
    }
}
