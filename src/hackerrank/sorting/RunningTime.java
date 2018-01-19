package hackerrank.sorting;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/runningtime/problem
 * @author diogenes
 *
 */
public class RunningTime {
	public static int insertionSort(int[] A){
		int shifts = 0;
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
                shifts++;
            }
            A[j + 1] = value;
        }
        return shifts;
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        System.out.println(insertionSort(ar));
        in.close();
    }
}
