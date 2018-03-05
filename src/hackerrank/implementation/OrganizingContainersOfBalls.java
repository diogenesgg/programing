package hackerrank.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

	static String organizingContainers(int[][] container) {
        int[] countPerContainer = new int[container.length];
        int[] countPerType = new int[container.length];
        
        for (int i = 0; i < container.length; i++) {
        		for (int j = 0; j < container.length; j++) {
        			countPerContainer[i]+= container[i][j];
        			countPerType[j]+= container[i][j];
        		}
        }
        
        Arrays.sort(countPerContainer);
        Arrays.sort(countPerType);
        
        for (int i = 0; i < container.length; i++) {
        		if (countPerContainer[i] != countPerType[i]) {
        			return "Impossible";
        		}
        }
        return "Possible";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] container = new int[n][n];
            for(int container_i = 0; container_i < n; container_i++){
                for(int container_j = 0; container_j < n; container_j++){
                    container[container_i][container_j] = in.nextInt();
                }
            }
            String result = organizingContainers(container);
            System.out.println(result);
        }
        in.close();
    }
}
