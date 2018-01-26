package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 * 
 * Easy
 * 
 * @author diogenes
 *
 */
public class SherlockAndAnagrams {

	static long sherlockAndAnagrams(String s) {
        long total = 0;
        
        for (int l = 1; l <= s.length() - 1; l++) { //l == length of anagram
        		for (int i = 0; i + l <= s.length(); i++) {
        			for (int j = i+1; j + l <= s.length(); j++) {
            			if (isAnagram(s, i,i+l, j, j+l)) {
            				total++;
            			}
            		}
        		}
        }
        
        return total;
    }

    private static boolean isAnagram(String s, int i0, int i1, int j0, int j1) {
    		int[] freq1 = new int[26];
    		int[] freq2 = new int[26];
    		
    		for (int i = i0; i < i1; i++) {
    			freq1[s.charAt(i)-'a']++;
    		}
    		for (int i = j0; i < j1; i++) {
    			freq2[s.charAt(i)-'a']++;
    		}
    		
    		for (int i = 0; i < 26; i++) {
    			if (freq1[i] != freq2[i]) {
    				return false;
    			}
    		}
    		
		return true;
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            long result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
        in.close();
    }
}
