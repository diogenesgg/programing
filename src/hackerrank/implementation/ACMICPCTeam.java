package hackerrank.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class ACMICPCTeam {

	static int[] acmTeam(String[] topic) {
        // Complete this function
		int maxTopics = 0, maxTeams = 0, currentOr;
		BigInteger[] persons = new BigInteger[topic.length];
		for (int i = 0; i < topic.length; i++) {
			persons[i] = new BigInteger(topic[i], 2);
		}
		
		for (int i = 0; i < persons.length - 1; i++) {
			for (int j = i+1; j < persons.length; j++) {
				currentOr = persons[i].or(persons[j]).bitCount();
				if (currentOr > maxTopics) {
					maxTopics = currentOr;
					maxTeams = 1;
				} else if (currentOr == maxTopics) {
					maxTeams++;
				}
			}
		}
		
		return new int[] {maxTopics, maxTeams};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] topic = new String[n];
        for(int topic_i = 0; topic_i < n; topic_i++){
            topic[topic_i] = in.next();
        }
        int[] result = acmTeam(topic);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
