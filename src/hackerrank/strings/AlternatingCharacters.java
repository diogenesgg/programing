package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/alternating-characters/problem
 * 
 * @author diogenes
 *
 */
public class AlternatingCharacters {

	static int alternatingCharacters(String s){
        // Complete this function
		
		char last = s.charAt(0), current;
		int deletions = 0;
		
		for (int i = 1; i < s.length(); i++) {
			current = s.charAt(i);
			
			if (current == last) {
				deletions++;
			}
			last = s.charAt(i);
		}
		
		return deletions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = alternatingCharacters(s);
            System.out.println(result);
        }
        in.close();
    }
}
