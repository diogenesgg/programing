package hackerrank.strings;

import java.util.Scanner;

public class SuperReducedString {

	static String super_reduced_string(String s){
        StringBuilder out = new StringBuilder();
        char current;
        for (int i = 0; i < s.length(); i++) {
        		current = s.charAt(i);
        		if (out.length() > 0 && current == out.charAt(out.length() - 1)) {
        			out.deleteCharAt(out.length() - 1);
        		} else {
        			out.append(current);
        		}
        }
		return out.length() > 0 ? out.toString() : "Empty String";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
        in.close();
    }
}
