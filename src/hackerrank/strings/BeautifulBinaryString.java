package hackerrank.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-binary-string
 * 
 * @author diogenes
 *
 */
public class BeautifulBinaryString {

	static int beautifulBinaryString(String b) {
		int index = 0;
		int total = 0;
		while( (index = b.indexOf("010", index)) != -1 ) {
			total++;
			index += 3;
		}

        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String b = in.next();
        int result = beautifulBinaryString(b);
        System.out.println(result);
        in.close();
    }
}
