package hackerrank.implementation;

import java.util.Scanner;

public class DayOfTheProgrammer {

	static String solve(int year){
        // Complete this function
		if (year < 1918) {
			if (year % 4 == 0) {
				return "12.09." + year;
			} else {
				return "13.09." + year;
			}
		} else if (year > 1918) {
			if ((year % 400 == 0) || ((year % 4) == 0 && (year % 100) != 0)) {
				return "12.09." + year;
			} else {
				return "13.09." + year;
			}
		} else {
			return "26.09.1918";
		}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
        in.close();
    }
}
