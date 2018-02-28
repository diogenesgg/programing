package hackerrank.implementation;

import java.util.Scanner;

public class EqualizeTheArray {

	static int equalizeArray(int[] arr) {
        int[] freq = new int[101];
        for (int i = 0; i < arr.length; i++) {
        		freq[arr[i]]++;
        }
        int max = 0;
        for (int i = 0; i < freq.length; i++) {
        		if (freq[i] > max) {
        			max = freq[i];
        		}
        }
        return arr.length - max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = equalizeArray(arr);
        System.out.println(result);
        in.close();
    }
}
