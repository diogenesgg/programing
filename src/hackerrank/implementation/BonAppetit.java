package hackerrank.implementation;

import java.util.Scanner;

public class BonAppetit {

	static String bonAppetit(int n, int k, int b, int[] ar) {
        int annasBill = 0;
        for (int i = 0; i < ar.length; i++) {
        		annasBill += ar[i];
        }
        annasBill = (annasBill - ar[k]) / 2;
        if (annasBill == b) {
        		return "Bon Appetit";
        } else {
        		return Integer.toString(b - annasBill);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int b = in.nextInt();
        System.out.println(bonAppetit(n, k, b, ar));
        in.close();
    }
}
