package hackerrank.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ExtraLongFactorials {

	static void extraLongFactorials(int n) {
        BigInteger bigN = new BigInteger(Integer.toString(n));
        while (--n >= 1) {
        		bigN = bigN.multiply(new BigInteger(Integer.toString(n)));
        }
        System.out.println(bigN);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
