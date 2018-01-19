package hackerrank.crakingthecode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.xml.transform.stream.StreamSource; 

public class RansomNote {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String word = in.next();
            if (!map.containsKey(word)) {
            		map.put(word, 1);
            } else {
            		Integer count = map.get(word);
            		map.put(word, count + 1);
            }
        }
        
        boolean failed = false;
        for (int ransom_i=0; ransom_i < n; ransom_i++){
            String word = in.next();
            
            if (map.containsKey(word)) {
            		Integer count = map.get(word);
            		if (count <= 1) {
            			map.remove(word);
            		} else {
            			map.put(word, count - 1);
            		}
            } else {
            		System.out.println("No");
            		failed = true;
            		break;
            }
        }
        if (!failed) {
        		System.out.println("Yes");
        }
	}
}
