package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 * 
 * @author diogenes
 *
 */
public class BigSorting {
	
	static String[] bigSorting(String[] arr) {
		MyNumber[] bigArr = new MyNumber[arr.length];
        for (int i = 0; i < arr.length; i++) {
			bigArr[i] = new MyNumber(arr[i]);
		}
        Arrays.sort(bigArr);
        for (int i = 0; i < arr.length; i++) {
			arr[i] = bigArr[i].value;
		}
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.next();
        }
        String[] result = bigSorting(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
    
    static class MyNumber implements Comparable<MyNumber>{
    		public String value;

    		public MyNumber(String v) {
    			value = v;
    		}
    		
		@Override
		public int compareTo(MyNumber o) {
			if (this.value.length() > o.value.length()) {
				return 1;
			} else if (this.value.length() < o.value.length()) {
				return -1;
			} else {
				for (int i = 0; i < value.length(); i++) {
					if (this.value.charAt(i) > o.value.charAt(i)) {
						return 1;
					} else if (this.value.charAt(i) < o.value.charAt(i)) {
						return -1;
					}
				}
			}
			return 0;
		}
    }
}
