package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insertionsort1/problem
 * 
 * @author diogenes
 *
 */
public class InsertionSortP1 {
	//2 4 6 8 3
	static void insertionSort1(int n, int[] arr) {
        int lastNumber = arr[arr.length - 1];
        
        int i = arr.length - 2;
        for (; i >= 0; i--) {
        		if (arr[i] > lastNumber ) {
        			arr[i+1] = arr[i];
        			System.out.println(toStringArray(arr));
        		} else {
        			break;
        		}
        }
        arr[i+1] = lastNumber;
        System.out.println(toStringArray(arr));
    }
	
	private static String toStringArray(int[] arr) {
		return Arrays.toString(arr).replace("[", "").replaceAll("]", "").replace(",", "");
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}
