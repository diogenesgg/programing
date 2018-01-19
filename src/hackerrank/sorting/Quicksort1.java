package hackerrank.sorting;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Quicksort1 {

	static int[] quickSort(int[] arr) {
        List<Integer> left = new LinkedList<Integer>();
        List<Integer> right = new LinkedList<Integer>();
        List<Integer> equal = new LinkedList<Integer>();
        int[] arr2 = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
        		if (arr[i] < arr[0]) {
        			left.add(arr[i]);
        		} else if (arr[i] > arr[0]) {
        			right.add(arr[i]);
        		} else {
        			equal.add(arr[i]);
        		}
        }
        
        int i = 0;
        for (Iterator<Integer> iterator = left.iterator(); iterator.hasNext();) {
			arr2[i++] = (Integer) iterator.next();
		}
        for (Iterator<Integer> iterator = equal.iterator(); iterator.hasNext();) {
			arr2[i++] = (Integer) iterator.next();
		}
        for (Iterator<Integer> iterator = right.iterator(); iterator.hasNext();) {
			arr2[i++] = (Integer) iterator.next();
		}
        
        return arr2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int[] result = quickSort(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
