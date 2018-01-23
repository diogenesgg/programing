package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/game-of-thrones/problem
 * 
 * @author diogenes
 *
 */
public class GameOfThronesI {

	static String gameOfThrones(String s){
		int[] alph = new int[26];
        
		int odds = 0;
		
        for (int i = 0; i < s.length(); i++) {
        		alph[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
        		if (alph[i] % 2 == 1) {
        			odds++;
        		}
        }
        if (s.length() % 2 == 1 && odds <= 1) {
        		return "YES";
        }
        if (s.length() % 2 == 0 && odds == 0) {
        		return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
        in.close();
    }
}
