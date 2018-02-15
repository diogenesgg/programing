package hackerrank.implementation;

import java.util.Scanner;

public class ViralAdvertising {

	static int viralAdvertising(int n) {
		int totalLikes = 2, currentLikes = 2;
		
		for (int i = 1; i < n; i++) {
			totalLikes += (currentLikes * 3) / 2;
			currentLikes = (currentLikes * 3) / 2;
		}
		
		return totalLikes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = viralAdvertising(n);
        System.out.println(result);
        in.close();
    }
}
