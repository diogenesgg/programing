package hackerrank.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lilys-homework/problem
 * 
 * This uses the counting cycles strategy;
 * 
 * @author diogenes
 *
 */
public class LilysHomework {
	
	static long lilysHomework(int[] array) {
		int[] unsorted = array.clone();
		int[] sorted = unsorted.clone();
		Arrays.sort(sorted);
		
		Map<Integer, Integer> sortedMap = new HashMap<>();
		Map<Integer, Integer> graph = new HashMap<>();
		
		for (int i = 0; i < sorted.length; i++) {
			sortedMap.put(sorted[i], i);
		}
		int swaps = 0;
		int sortedIdx;
		for (int i = 0; i < unsorted.length; i++) {
			if (sorted[i] != unsorted[i]) {
				sortedIdx = sortedMap.get(unsorted[i]);
				graph.put(i, sortedIdx);
			}
		}
		
		boolean[] visited = new boolean[array.length];
		Map<Integer, Boolean> cicle = new HashMap<>();
		
		for (int i = 0; i < array.length; i++) {
			if (visited[i]) continue;
			int next_i = i;
			if (graph.containsKey(i)) {
				while (!cicle.containsKey(next_i)) {
					cicle.put(next_i, true);
					next_i = graph.get(next_i);
					visited[next_i] = true;
				}
				if (cicle.size() > 0) {
					swaps += cicle.size() - 1;
				}
				cicle.clear();
			}
		}
		
		return swaps;
	}
	
	public static void reverse(int[] data) {
	    for (int left = 0, right = data.length - 1; left < right; left++, right--) {
	        // swap the values at the left and right indices
	        int temp = data[left];
	        data[left]  = data[right];
	        data[right] = temp;
	    }
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        in.close();
        long result1 = lilysHomework(arr);
        reverse(arr);
        long result2 = lilysHomework(arr);
        System.out.println(Math.min(result1, result2));
    }
}
