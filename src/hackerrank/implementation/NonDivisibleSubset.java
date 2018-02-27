package hackerrank.implementation;

import java.util.Scanner;

public class NonDivisibleSubset {

	static int nonDivisibleSubset(int k, int[] arr) {
		int[] modules = new int[100];
		
		for (int i = 0; i < arr.length; i++) {
			modules[arr[i] % k]++;
		}
		
		int count = 0;
		if (modules[0] > 0) {
			count++;
		}
		
		int max;
		if ( k % 2 == 0) {
			max = (k/2) - 1;
			if (modules[k/2] > 0) {
				count++;
			}
		} else {
			max = (k/2);
		}
		
		for (int i = 1; i <= max; i++) {
			count += Math.max(modules[i], modules[k-i]);
		}
		
		return count;
	}


	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = nonDivisibleSubset(k, arr);
        System.out.println(result);
        in.close();
    }
}
