package hackerrank.implementation;

import java.util.Scanner;

public class AppendAndDelete {

	static String appendAndDelete(String s, String t, int k) {
		
		if (k >= s.length() + t.length()) {
			return "Yes";
		}
		
		int common = 0, toDelete, toAdd;
		
		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				common++;
			} else {
				break;
			}
		}
		
		toDelete = s.length() - common;
		
		if (toDelete > k) {
			return "No";
		}
		
		toAdd = t.length() - common;
		
		if (toDelete + toAdd > k) {
			return "No";
		}
		
		if (toDelete + toAdd == 0 && k <= 2*s.length() && (k % 2) == 1) {
			return "No";
		}
		
		if ( (k - toAdd + toDelete) % 2 == 1) {
			return "No";
		}
		
        return "Yes";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        in.close();
    }
}
