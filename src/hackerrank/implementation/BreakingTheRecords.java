package hackerrank.implementation;

import java.util.Scanner;

public class BreakingTheRecords {
	static int[] breakingRecords(int[] score) {
        int min = score[0], max = score[0], brokeLow = 0, brokeHigh = 0;
        
        for (int i = 1; i < score.length; i++) {
        		if (score[i] > max) {
        			brokeHigh++;
        			max = score[i];
        		}
        		if (score[i] < min) {
        			brokeLow++;
        			min = score[i];
        		}
        }
        
        return new int[] {brokeHigh, brokeLow};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");

        in.close();
    }
}
