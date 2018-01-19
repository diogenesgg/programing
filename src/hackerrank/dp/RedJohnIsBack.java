package hackerrank.dp;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/red-john-is-back/problem
 * 
 * @author diogenes
 *
 */
public class RedJohnIsBack {

	public static void main(String[] args) {
		
		long[][] matrix = new long[10+1][40+1]; //long[G][N]
		
		fillMatrix(matrix);
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			int next = scanner.nextInt();
			int m = arrangements(matrix, next);
			System.out.println(countPrimes(m));
		}
		
		scanner.close();
	}
	
	private static void fillMatrix(long[][] matrix) {
		for (int g_i = 1; g_i <= 10; g_i++) {//G means the amount of groups of 4
			for (int n_i = g_i * 4; n_i <= 40; n_i++) {
				matrix[g_i][n_i] = binomial( g_i + (n_i - 4*g_i) , g_i);
			}
		}
	}
	
	private static int [] generatePrimes(int max) {
	    boolean[] isComposite = new boolean[max + 1];
	    for (int i = 2; i * i <= max; i++) {
	        if (!isComposite [i]) {
	            for (int j = i; i * j <= max; j++) {
	                isComposite [i*j] = true;
	            }
	        }
	    }
	    int numPrimes = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) numPrimes++;
	    }
	    int [] primes = new int [numPrimes];
	    int index = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) primes [index++] = i;
	    }
	    return primes;
	}
	
	private static int countPrimes(int max) {
	    boolean[] isComposite = new boolean[max + 1];
	    for (int i = 2; i * i <= max; i++) {
	        if (!isComposite [i]) {
	            for (int j = i; i * j <= max; j++) {
	                isComposite [i*j] = true;
	            }
	        }
	    }
	    int numPrimes = 0;
	    for (int i = 2; i <= max; i++) {
	        if (!isComposite [i]) numPrimes++;
	    }
	    return numPrimes;
	}
	
	private static int arrangements(long[][] matrix, int n) {
		int total = 1;
		for (int i = 1; i <= 10; i++) {
			total += matrix[i][n];
		}
		return total;
	}

	private static long binomial(int n, int k) {
		if (k > n-k) {
			k=n-k;
		}
		long b=1;
		for (int i=1, m=n; i<=k; i++, m--) {
			b = b * m/i;
		}
		return b;
	}
}
