package hackerrank.implementation;

import java.util.Scanner;

public class PickingNumbers {

	static int pickingNumbers(int[] a) {
        int[] counter = new int[100];
        for (int i = 0; i < a.length; i++) {
			counter[a[i]]++;
		}
        int max = 0;
        for (int i = 1; i < counter.length; i++) {
			if (counter[i] + counter[i-1] > max) {
				max = counter[i] + counter[i-1];
			}
		}
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
