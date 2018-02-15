package hackerrank.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClimbingTheLeaderboard {
	
	static int[] climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> rank = new ArrayList<Integer>(scores.length);
        
        int[] alicesRank = new int[alice.length];
        
        int last = -1, current;
        for (int i = 0; i < scores.length; i++) {
        		current = scores[i];
        		if (current != last) {
        			rank.add(current);
        		}
        		last = current;
        }
        
        for (int i = 0; i < alice.length; i++) {
        		alicesRank[i] = binarySearch(rank, alice[i]) + 1;
		}
        
        return alicesRank;
    }
	
	static int binarySearch(List<Integer> rank, int score) {
		int i = 0, j = rank.size() - 1, middle = 0, midValue;
		while (i <= j) {
			middle = (i+j) / 2;
			midValue = rank.get(middle);

			if (i == j) {
				if (score < midValue) {
					return i + 1;
				} else {
					return i;
				}
			}
			
			if (score < midValue) {
				i = middle + 1;
			} else if (score > midValue) {
				j = middle;
				
			} else {
				return middle;
			}
		}
		return middle;
	}

    public static void main(String[] args) {
    		
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for(int scores_i = 0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i = 0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
