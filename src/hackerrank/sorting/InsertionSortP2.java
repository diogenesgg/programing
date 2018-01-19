package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortP2 {

	static void insertionSort1(int n, int[] arr) {
        int lastNumber = arr[n - 1];
        
        int i = n - 2;
        for (; i >= 0; i--) {
        		if (arr[i] > lastNumber ) {
        			arr[i+1] = arr[i];
        		} else {
        			break;
        		}
        }
        arr[i+1] = lastNumber;
    }
	
	private static String toStringArray(int[] arr) {
		return Arrays.toString(arr).replace("[", "").replaceAll("]", "").replace(",", "");
	}
	
	static void insertionSort2(int n, int[] arr) {
		for (int i = 2; i <= n; i++) {
			insertionSort1(i, arr);
			System.out.println(toStringArray(arr));
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int arr_i = 0; arr_i < n; arr_i++){
			arr[arr_i] = in.nextInt();
		}
		insertionSort2(n, arr);
		in.close();
	}
}
