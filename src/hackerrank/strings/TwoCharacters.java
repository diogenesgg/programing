package hackerrank.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/two-characters/problem
 * 
 * @author diogenes
 *
 */
public class TwoCharacters {

	static int twoCharaters(String s) {
		if (s.length() == 1) return 0;
		int max = 0, counter;
		for (char i = 'a'; i < 'z'; i++) {
			for (char j = (char)(i + 1); j <= 'z'; j++) {
				
				counter = 0;
				char last = 0, current;
				boolean alternating = true;
				for (int s_i = 0; s_i < s.length(); s_i++) {
					current = s.charAt(s_i);
					if (current == i || current == j) {
						if (last == 0) {
							last = current;
							counter++;
						} else {
							if (current == last) {
								//error, i and j are not alternating!
								alternating = false;
								break;
							} else {
								counter++;
							}
							last = current;
						}
					}
				}
				
				if (alternating) {
					if (counter > max) {
						max = counter;
					}
				}
				
			}
		}
		return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        int result = twoCharaters(s);
        System.out.println(result);
        in.close();
    }
}
