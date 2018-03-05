package hackerrank.implementation;

import java.util.Scanner;

public class TaumAndBDay {

	static long taumBday(long b, long w, long x, long y, long z) {
        x = Math.min(x, y+z);
        y = Math.min(y, x+z);
        return (b * x) + (w * y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int b = in.nextInt();
            int w = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            long result = taumBday(b, w, x, y, z);
            System.out.println(result);
        }
        in.close();
    }
}
