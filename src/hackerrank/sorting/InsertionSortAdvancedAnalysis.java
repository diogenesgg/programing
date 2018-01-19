package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/counting-inversions/
 * 
 * TODO https://stackoverflow.com/questions/11497502/counting-inversions-using-bit
 * 
 * @author diogenes
 *
 */
public class InsertionSortAdvancedAnalysis {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int t_i = 0; t_i < t; t_i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int arr_i = 0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}
			Mergesort mergeSort = new Mergesort();
			mergeSort.sort(arr);
			System.out.println(mergeSort.shifts);
			
		}
		in.close();
	}
	
	public static class Mergesort {
	    private int[] numbers;
	    private int[] helper;
	    private long shifts = 0;

	    private int number;

	    public void sort(int[] values) {
	        this.numbers = values;
	        number = values.length;
	        this.helper = new int[number];
	        mergesort(0, number - 1);
	    }

	    private void mergesort(int low, int high) {
	        // check if low is smaller than high, if not then the array is sorted
	        if (low < high) {
	            // Get the index of the element which is in the middle
	            int middle = low + (high - low) / 2;
	            // Sort the left side of the array
	            mergesort(low, middle);
	            // Sort the right side of the array
	            mergesort(middle + 1, high);
	            // Combine them both
	            merge(low, middle, high);
	        }
	    }

	    private void merge(int low, int middle, int high) {

	        // Copy both parts into the helper array
	        for (int i = low; i <= high; i++) {
	            helper[i] = numbers[i];
	        }

	        int i = low;
	        int j = middle + 1;
	        int k = low;
	        // Copy the smallest values from either the left or the right side back
	        // to the original array
	        while (i <= middle && j <= high) {
	            if (helper[i] <= helper[j]) {
	                numbers[k] = helper[i];
	                i++;
	            } else {
	                numbers[k] = helper[j];
	                shifts += middle - i + 1;
	                j++;
	            }
	            k++;
	        }
	        
	        // Copy the rest of the left side of the array into the target array
	        while (i <= middle) {
	            numbers[k] = helper[i];
	            k++;
	            i++;
	        }
	        // Since we are sorting in-place any leftover elements from the right side
	        // are already at the right position.

	    }
	}
}
