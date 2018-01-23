package hackerrank.strings;

import java.util.Scanner;

public class StringConstruction {

	static int stringConstruction(String s) {
		int counter = 0;
		boolean found;
		for (int i = s.length() - 1; i >= 1; i--) {
			found = false;
			for (int j = i - 1; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j)) {
					found = true;
					break;
				}
			}
			if(!found) {
				counter++;
			}
		}
        return counter + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
}
