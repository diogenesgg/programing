package hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeightedUniformString {

	static Map<Integer, Boolean> buildMap(String s) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		
		char last = s.charAt(0), current;
		int lastSum = last - 'a' + 1;
		map.put(lastSum, true);
		
		for (int i = 1; i < s.length(); i++) {
			current = s.charAt(i);
			
			if (current == last) {
				lastSum += current - 'a' + 1;
			} else {
				lastSum = current - 'a' + 1;
			}
			map.put(lastSum, true);
			last = s.charAt(i);
		}
		
		return map;
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        Map<Integer, Boolean> map = buildMap(s);
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if (map.containsKey(x)) {
            		System.out.println("Yes");
            } else {
            		System.out.println("No");
            }
        }
        in.close();
    }
}
