package hackerrank.implementation;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 * 
 * @author diogenes
 *
 */
public class FormingAMagicSquare {

	static int formingMagicSquare(int[][] s) {
        int[][] magic1 = {{4, 9, 2},
        					 {3, 5, 7},
        					 {8, 1, 6}};
        
        int[][] magic11 = {{2, 9, 4},
						 {7, 5, 3}, //vertical mirror
						 {6, 1, 8}};
        
        int[][] magic12 = {{8, 1, 6},
						 {3, 5, 7}, //horizontal mirror
						 {4, 9, 2}};
        
        int[][] magic2 = {{8, 3, 4},
						 {1, 5, 9},
						 {6, 7, 2}};
        
        int[][] magic21 = {{4, 3, 8}, 
						  {9, 5, 1}, //vertical mirror
						  {2, 7, 6}};
        
        int[][] magic22 = {{8, 3, 4},
						 {1, 5, 9}, //horizontal mirror
						 {6, 7, 2}};
        
        int[][] magic3 = {{6, 1, 8},
						 {7, 5, 3},
						 {2, 9, 4}};
        
        int[][] magic31 = {{8, 1, 6},
						  {3, 5, 7}, //vertical
						  {4, 9, 2}};
        
        int[][] magic32 = {{2, 9, 4},
						  {7, 5, 3},//horizontal
						  {6, 1, 8}};
        
        int[][] magic4 = {{2, 7, 6},
						 {9, 5, 1},
						 {4, 3, 8}};
        
        int[][] magic41 = {{6, 7, 2},
						  {1, 5, 9}, //vertical
						  {8, 3, 4}};
        
        int[][] magic42 = {{4, 3, 8},
						  {9, 5, 1}, //horizontal
						  {2, 7, 6}};
        
        int [][][] all = {magic1, magic11, magic12, magic2, magic21, magic22, magic3, magic31, magic32, magic4, magic41, magic42};
        
        int minCount = Integer.MAX_VALUE, count;
        
        for (int i = 0; i < all.length ; i++) {
        		count = 0;
        		for(int s_i = 0; s_i < 3; s_i++){
                for(int s_j = 0; s_j < 3; s_j++){
                    count += Math.abs(s[s_i][s_j] - all[i][s_i][s_j]);
                }
            }
        		if (count < minCount) {
        			minCount = count;
        		}
        }
        
        return minCount;
    }

    public static void main(String[] args) {    		
        Scanner in = new Scanner(System.in);
        int[][] s = new int[3][3];
        for(int s_i = 0; s_i < 3; s_i++){
            for(int s_j = 0; s_j < 3; s_j++){
                s[s_i][s_j] = in.nextInt();
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
