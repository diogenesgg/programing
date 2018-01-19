package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 * 
 * @author diogenes
 *
 */
public class CaesarCipher {

	static String caesarCipher(String s, int k) {
        char[] out = new char[s.length()];
        
        char next;
        for (int i = 0; i < s.length(); i++) {
        		next = s.charAt(i);
        		if (next >= 'A' && next <= 'Z') {
        			out[i] = (char)((((next - 'A') + k) % 26) + 'A');
        		} else if (next >= 'a' && next <= 'z') {
        			out[i] = (char)((((next - 'a') + k) % 26) + 'a');
        		} else {
        			out[i] = next;
        		}
        }
        
        return String.valueOf(out);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        String result = caesarCipher(s, k);
        System.out.println(result);
        in.close();
    }
}
