package hackerrank.bitmanipulation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cipher/problem
 * Seems nice!
 * 
 * @author diogenes
 *
 */
public class Cipher {

	static String cipher(int k, String s) {
		char[] b = new char[s.length() - k + 1];
		
		b[0] = s.charAt(0);
		Latest latest = new Latest(k - 1);
		
		for (int i = 1; i < b.length; i++) {
			b[i] = (char) (((s.charAt(i) - '0') ^ latest.add(b[i-1])) + '0');
		}
		
		return String.valueOf(b);
    }
	
	static class Latest {
		int xor = 0;
		Deque<Character> queue = new LinkedList<>();
		int maxSize;
		
		Latest(int maxSize) {
			this.maxSize = maxSize;
		}
		
		int add(char bit) {
			queue.add(bit);
			xor = xor ^ (bit - '0');
			if (queue.size() > maxSize) {
				char first = queue.pop();
				xor = xor ^ (first - '0');
			}
			return xor;
		}
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        String result = cipher(k, s);
        System.out.println(result);
        in.close();
    }
}
