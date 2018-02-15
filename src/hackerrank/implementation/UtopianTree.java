package hackerrank.implementation;

import java.util.Scanner;

public class UtopianTree {

	static int[] growth = new int[61];

    public static void main(String[] args) {
    		calculateGrowth();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(growth[n]);
        }
        in.close();
    }

	private static void calculateGrowth() {
		growth[0] = 1;
		for (int i = 1; i <= 60; i++) {
			if (i % 2 == 0) {
				growth[i] = growth[i-1] + 1;
			} else {
				growth[i] = growth[i-1] * 2;
			}
		}
	}
}
