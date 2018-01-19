package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 * @author diogenes
 *
 */
public class MarsExploration {
	
	static int marsExploration(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i+= 3) {
        		if (s.charAt(i) != 'S') counter++;
        		if (s.charAt(i+1) != 'O') counter++;
        		if (s.charAt(i+2) != 'S') counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = marsExploration(s);
        System.out.println(result);
        in.close();
    }
}
