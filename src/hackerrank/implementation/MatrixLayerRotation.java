package hackerrank.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 * 
 * @author diogenes
 *
 */
public class MatrixLayerRotation {

	static void matrixRotation(int[][] matrix, int r) {
		
		int[][] newMatrix = new int[matrix.length][matrix[0].length];
		int cycles = Math.min(matrix.length, matrix[0].length) / 2;
		int cycleLength, height, width;
		for (int c = 0; c < cycles; c++) {
			height = matrix.length - 2*c;
			width = matrix[0].length - 2*c;
			cycleLength = 2 * height + 2 * width - 4;
			
			Pair[] pairArray = new Pair[cycleLength];
			int i = 0 + c, j = 0 + c;
			for (int k = 0; k < cycleLength; k++) {
				pairArray[k] = new Pair(i, j);
				if (k >= 0 && k < height - 1) {//going down
					i++;
				} else if (k >= (height -1) && k < (height + width - 2)) { //going left
					j++;
				} else if (k >= (height + width - 2) && k < (height + height + width - 3)) { //going up
					i--;
				} else {// going left
					j--;
				}
			}
			
			Pair current, newPosition;
			
			for (int k = 0; k < cycleLength; k++) {
				current = pairArray[k];
				newPosition = pairArray[(k + r) % cycleLength];
				newMatrix[newPosition.i][newPosition.j] = matrix[current.i][current.j];
			}
		}
		
		for (int k = 0; k < matrix.length; k++) { //coping back to matrix
			matrix[k] = newMatrix[k];
		}
    }
	
	static class Pair {
		int i;//line
		int j;//column
		
		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public String toString() { //for debugging
			return "("+i+","+j+")";
		}
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();
        int[][] matrix = new int[m][n];
        for(int matrix_i = 0; matrix_i < m; matrix_i++){
            for(int matrix_j = 0; matrix_j < n; matrix_j++){
                matrix[matrix_i][matrix_j] = in.nextInt();
            }
        }
        matrixRotation(matrix, r);
        print(matrix);
        in.close();
    }

	private static void print(int[][] matrix) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				out.append(matrix[i][j]);
				if (j < matrix[i].length - 1) {
					out.append(" ");
				}
			}
			if (i < matrix.length - 1) {
				out.append("\n");
			}
		}
		System.out.println(out.toString());
	}
}
