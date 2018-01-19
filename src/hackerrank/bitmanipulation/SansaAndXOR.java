package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/sansa-and-xor/problem
 * 
 * @author diogenes
 *
 */
public class SansaAndXOR {
	
	static int sansaXor(int[] arr) {
		if (arr.length % 2 == 0) {
			return 0;
		} else {
			int xors = arr[0];
			for (int i = 2; i < arr.length; i+= 2) { 
				xors = xors ^arr[i];
			}
	        return xors;
		}
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = sansaXor(arr);
            System.out.println(result);
        }
        in.close();
    }
}
