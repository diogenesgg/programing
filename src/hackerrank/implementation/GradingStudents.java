package hackerrank.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grading/problem
 * 
 * @author diogenes
 *
 */
public class GradingStudents {

	static int solve(int grade) {
		if (grade < 38) {
			return grade;
		} else {
			int next5 = ((grade/5) * 5) + 5;
			if (next5 - grade < 3) {
				return next5;
			} else {
				return grade;
			}
		}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), next;
        
        for(int grades_i=0; grades_i < n; grades_i++){
            next = in.nextInt();
            System.out.println(solve(next));
        }
        in.close();
    }
}
