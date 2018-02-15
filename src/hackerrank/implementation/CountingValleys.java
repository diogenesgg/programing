package hackerrank.implementation;

import java.util.Scanner;

public class CountingValleys {

	static int countingValleys(int n, String s) {
        int curLevel = 0, valleys = 0;
        
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'U') {
				curLevel++;
			} else {
				curLevel--;
				if (curLevel == -1) {
					valleys++;
				}
			}
		}
        
        return valleys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }	
}
