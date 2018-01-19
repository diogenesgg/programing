package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/funny-string/problem
 * 
 * @author diogenes
 *
 */
public class FunnyString {

	static String funnyString(String s) {
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 1; i < s.length(); i++) {
        		if (Math.abs(s.charAt(i) - s.charAt(i-1)) !=
        				Math.abs(r.charAt(i) - r.charAt(i-1)) ) {
        			return "Not Funny";
        		}
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
        in.close();
    }
}
