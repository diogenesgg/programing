package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/anagram/problem
 * 
 * @author diogenes
 *
 */
public class Anagram {

	static int anagram(String s){
        int[] alph1 = new int[26];
        int[] alph2 = new int[26];
        
        if (s.length() % 2 == 1) return -1;
        
        for (int i = 0; i < s.length()/2; i++) {
        		alph1[s.charAt(i) - 'a']++;
        }
        
        for (int i = (s.length()/2); i < s.length(); i++) {
	    		alph2[s.charAt(i) - 'a']++;
	    }
        
        int total = 0;
        for (int i = 0; i < 26; i++) {
        		total += Math.abs(alph1[i] - alph2[i]);
        }
        
		return total/2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagram(s);
            System.out.println(result);
        }
        in.close();
    }
}
