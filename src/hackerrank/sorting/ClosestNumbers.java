package hackerrank.sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

	static List<Integer> closestNumbers(int[] arr) {
        Arrays.sort(arr);
        List<Integer> pairs = new LinkedList<>();
        int max = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
        		int diff = arr[i] - arr[i-1];
			if (diff < max) {
				pairs.clear();
				max = diff;
				pairs.add(arr[i-1]);
				pairs.add(arr[i]);
			} else if (diff == max) {
				pairs.add(arr[i-1]);
				pairs.add(arr[i]);
			}
		}
        return pairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        in.close();
        List<Integer> result = closestNumbers(arr);
        StringBuilder output = new StringBuilder();
        int i = 0;
        for (Iterator<Integer> it = result.iterator(); it.hasNext(); ) {
        		Integer next = it.next();
        		output.append(next + (i != result.size() - 1 ? " " : ""));
        		i++;
        }
        output.append("");
        System.out.println(output.toString());
    }
}
