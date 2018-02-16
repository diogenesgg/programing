package hackerrank.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CutTheSticks {

	static Integer[] cutTheSticks(int[] arr) {
		List<Integer> allCuts = new ArrayList<>(arr.length);
		int min, currentCuts;

		do {
			min = Integer.MAX_VALUE;
			currentCuts = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					currentCuts++;
					if (arr[i] < min) {
						min = arr[i];
					}
				}
			}
			if (currentCuts != 0) {
				allCuts.add(currentCuts);
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 0) {
					arr[i] -= min;
				}
			}
		} while (currentCuts > 0);

		return allCuts.toArray(new Integer[allCuts.size()]);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		Integer[] result = cutTheSticks(arr);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");
		in.close();
	}
}
