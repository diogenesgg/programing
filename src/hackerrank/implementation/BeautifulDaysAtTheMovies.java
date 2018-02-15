package hackerrank.implementation;

import java.util.Scanner;

public class BeautifulDaysAtTheMovies {
	
	static int beautifulDays(int i, int j, int k) {
		int beautiful = 0;
        for (int x = i; x <= j; x++) {
        		int subtraction = Math.abs(x - Integer.parseInt(new StringBuilder(Integer.toString(x)).reverse().toString()));
        		if (subtraction % k == 0) {
        			beautiful++;
        		}
        }
        return beautiful;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
