package hackerrank.implementation;

import java.util.Scanner;

public class RepeatedString {

	static long repeatedString(String s, long n) {
        int ainS = 0;
        for (int i = 0; i < s.length(); i++) {
        		if (s.charAt(i) == 'a') {
        			ainS++;
        		}
        }
        long total = (n/s.length()) * ainS;
        for (int i = 0; i < n % s.length(); i++) {
	    		if (s.charAt(i) == 'a') {
	    			total++;
	    		}
	    }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long result = repeatedString(s, n);
        System.out.println(result);
        in.close();
    }
}
