package hackerrank.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SherlockAndTheValidString {

	static String isValid(String s) {
		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i)-'a']++;
		}
		List<Integer> freqGT0 = new ArrayList<>(26);
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0) {
				freqGT0.add(freq[i]);
			}
		}
		
		if (freqGT0.size() == 1) {
			return "YES";
		}
		
		if (allEqual(freqGT0, 0 , freqGT0.size()-1)) {
			return "YES";
		}
		
		Collections.sort(freqGT0);
		System.out.println(freqGT0);
		if (freqGT0.get(freqGT0.size()-1) - freqGT0.get(freqGT0.size()-2) == 1
				&& allEqual(freqGT0, 0, freqGT0.size()-2)) {
			return "YES";
		}
		if (freqGT0.get(0) == 1 && allEqual(freqGT0, 1, freqGT0.size()-1)) {
			return "YES";
		}
		
        return "NO";
    }

	static boolean allEqual(List<Integer> freqGT0, int b, int e) {
		for (int i = b+1; i <= e; i++) {
			if (!freqGT0.get(i).equals(freqGT0.get(i-1))) {
				return false;
			}
		}
		return true;
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
        in.close();
    }
}
