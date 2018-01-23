package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/making-anagrams/problem
 * 
 * @author diogenes
 *
 */
public class MakingAnagrams {
	
	static int makingAnagrams(String s1, String s2){
		int[] alph1 = new int[26];
        int[] alph2 = new int[26];
        
        for (int i = 0; i < s1.length(); i++) {
        		alph1[s1.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s2.length(); i++) {
	    		alph2[s2.charAt(i) - 'a']++;
	    }
        
        int total = 0;
        for (int i = 0; i < 26; i++) {
        		total += Math.abs(alph1[i] - alph2[i]);
        }
        
		return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
        in.close();
    }
}
