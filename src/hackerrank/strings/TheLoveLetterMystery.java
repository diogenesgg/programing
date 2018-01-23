package hackerrank.strings;

import java.util.Scanner;

public class TheLoveLetterMystery {

	static int theLoveLetterMystery(String s){
		int total = 0;
		for (int i = 0; i < s.length()/2; i++) {
			total += Math.abs(s.charAt(i) - s.charAt(s.length() -i - 1));
		}
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            System.out.println(result);
        }
        in.close();
    }
}
