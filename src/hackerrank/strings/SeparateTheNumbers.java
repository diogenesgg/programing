package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 * 
 * @author diogenes
 *
 */
public class SeparateTheNumbers {

	static void separateNumbers(String s) {
		if (s.length() == 1) {
			System.out.println("NO");
			return;
		}
		
        for (int l = 1; l <= (s.length() / 2); l++) {
        		String initial = s.substring(0, l);
        		if (l > 1 && initial.charAt(0) == '0') {
        			continue;
        		}
        		long nextInt = Long.parseLong(initial) + 1l;
        		int i = l;
        		String nextIntStr = String.valueOf(nextInt);
        		boolean found = true;
        		while (i + nextIntStr.length() <= s.length()) {
        			
        			if (s.substring(i, i + nextIntStr.length()).equals(nextIntStr)) {
        				i = i + nextIntStr.length();
        			} else {
        				found = false;
        				break;
        			}
        			
        			nextInt++;
        			nextIntStr = String.valueOf(nextInt);
        		}
        		if (found && i == s.length()) {
        			System.out.println("YES " + initial);
        			return;
        		}
        }
        
        System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            separateNumbers(s);
        }
        in.close();
    }
}
