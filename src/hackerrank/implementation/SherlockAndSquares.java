package hackerrank.implementation;

import java.util.Scanner;

public class SherlockAndSquares {

	static int squares(int a, int b) {
        int init = (int) Math.floor(Math.sqrt(a));
        
        int squares = 0;
        for (int i = init; ((i*i) <= b); i++) {
        		if (i*i >= a) {
        			squares++;
        		}
        }
        return squares;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int result = squares(a, b);
            System.out.println(result);
        }
        in.close();
    }
}
