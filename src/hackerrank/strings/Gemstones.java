package hackerrank.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/gem-stones/problem
 * 
 * @author diogenes
 *
 */
public class Gemstones {

	static int gemstones(String[] arr){
        // Complete this function
		int[] counter = new int[26];
		boolean[] foundForK = new boolean[26];
		
		for (int k = 0; k < arr.length; k++) {
			Arrays.fill(foundForK, false);
			for (int i = 0; i < arr[k].length(); i++) {
				if (!foundForK[arr[k].charAt(i) - 'a']) {
					foundForK[arr[k].charAt(i) - 'a'] = true;
					counter[arr[k].charAt(i) - 'a']++;
				}
			}
		}
		
		int total = 0;
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] == arr.length) {
				total++;
			}
		}
		
		return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        int result = gemstones(arr);
        System.out.println(result);
        in.close();
    }
}
