package hackerrank.implementation;

import java.util.Scanner;

public class FindDigits {

	static int findDigits(int n) {
		String nStr = Integer.toString(n);
		int count = 0, digit;
		
		for (int i = 0; i < nStr.length(); i++) {
			digit = nStr.charAt(i) - '0';
			if (digit > 0 && n % digit == 0) {
				count++;
			}
		}
		
		return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        in.close();
    }
}
