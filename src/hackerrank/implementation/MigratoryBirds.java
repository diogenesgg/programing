package hackerrank.implementation;

import java.util.Scanner;

public class MigratoryBirds {

	static int migratoryBirds(int n, int[] ar) {
        int[] freq = new int[] {0, 0, 0, 0, 0, 0};
        
        for (int i = 0; i < ar.length; i++) {
			freq[ar[i]]++;
		}
        
        int max = 0;
        for (int i = 0; i < freq.length; i++) {
        		if (freq[i] > max) {
        			max = freq[i];
        		}
        }
        
        int result = 1;
        for (int i = 0; i < freq.length; i++) {
        		if (freq[i] == max) {
        			result = i;
        			break;
        		}
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
        in.close();
    }
}
