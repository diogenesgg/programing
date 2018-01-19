package hackerrank.strings;

import java.util.Scanner;

public class CamelCase {

	static int camelcase(String s) {
		int counter = 0;
        for (int i = 0; i < s.length(); i++) {
        		if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
        			counter ++;
        		}
        }
        return counter + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int result = camelcase(s);
        System.out.println(result);
        in.close();
    }
}
