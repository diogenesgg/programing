package hackerrank.implementation;

import java.util.Scanner;

public class Encryption {

	static String encryption(String s) {
        int rows = (int)Math.floor(Math.sqrt(s.length()));
        int columns = (int)Math.ceil(Math.sqrt(s.length()));
        
        if (rows * columns < s.length()) {
        		rows++;
        }
        char[][] matrix = new char[rows][columns];
        
        int k = 0;
        for (int i = 0; i < rows; i++) {
        		for (int j = 0; j < columns; j++) {
        			if (k < s.length()) {
        				matrix[i][j] = s.charAt(k++);
        			}
        		}
        }
        
        StringBuilder out = new StringBuilder();
        
        k = 0;
        for (int j = 0; j < columns; j++) {
        		for (int i = 0; i < rows; i++) {
        			if (matrix[i][j] != 0) {
        				out.append(matrix[i][j]);
        				k++;
        			}
	    		}
        		if (j < columns - 1) {
        			out.append(" ");
        		}
	    } 
        
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = encryption(s);
        System.out.print(result);
        in.close();
    }
}
