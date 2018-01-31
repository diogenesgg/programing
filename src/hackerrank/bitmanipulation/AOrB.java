package hackerrank.bitmanipulation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/aorb/problem
 * 
 * Pain in the neck question.
 * 
 * Since the inputs are very large, (200,000 bits),
 * using BigInteger was giving timeout and I coudn't use 
 * any Java feature to facilitate.
 * 
 * @author diogenes
 *
 */
public class AOrB {

	static boolean[][] hexToBitMatrix = {
			{false, false, false, false},//0
			{false, false, false, true},//1
			{false, false, true, false},//2
			{false, false, true, true},//3
			{false, true, false, false},//4
			{false, true, false, true},//5
			{false, true, true, false},//6
			{false, true, true, true},//7
			{true, false, false, false},//8
			{true, false, false, true},//9
			{true, false, true, false},//A
			{true, false, true, true},//B
			{true, true, false, false},//C
			{true, true, false, true},//D
			{true, true, true, false},//E
			{true, true, true, true},//F
	};
	
	static char[] intToHexArr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	static void fill(String s, boolean[] arr) {
		int arr_i = arr.length - 1;
		char nextChar;
		boolean[] nextBoolean;
		for (int s_i = s.length() - 1; s_i >= 0; s_i--) {
			nextChar = s.charAt(s_i);
			nextBoolean = charHexToBit(nextChar);
			for (int j = 3; j >= 0; j--) {
				arr[arr_i--] = nextBoolean[j];
			}
		}
	}
	
	static String toString(boolean[] b) {
		StringBuilder out = new StringBuilder();
		int intValue;
		boolean foundValid = false;
		for (int i = 0; i < b.length; i+= 4) {
			if (!b[i] && !b[i+1] & !b[i+2] && !b[i+3] && !foundValid) {
				continue;
			} else {
				foundValid = true;
			}
			
			intValue = 0;
			if (b[i]) {
				intValue = intValue | 8;
			}
			if (b[i+1]) {
				intValue = intValue | 4;
			}
			if (b[i+2]) {
				intValue = intValue | 2;
			}
			if (b[i+3]) {
				intValue = intValue | 1;
			}
			out.append(intToHexArr[intValue]);
		}
		if (!foundValid) {
			return "0";
		}
		return out.toString();
	}
	
	static boolean[] charHexToBit(char c) {
		if (c >= '0' && c <= '9') {
			return hexToBitMatrix[c-'0'];
		}
		return hexToBitMatrix[c-'A'+10];
	}
	
	static void printSolution(int k, String strA, String strB, String strC) {

		int maxBit = Math.max(Math.max(strA.length()*4, strB.length()*4), strC.length()*4);
		
		boolean[] a = new boolean[maxBit];
		boolean[] b = new boolean[maxBit];
		boolean[] c = new boolean[maxBit];
		fill(strA, a);
		fill(strB, b);
		fill(strC, c);
		
		int changes = 0;
		for (int i = 0; i < maxBit; i++) {
			if (c[i] == false) {
				if (a[i] == b[i]) {
					if (a[i]) {
						changes += 2;
						a[i] = false;
						b[i] = false;
					}
				} else {
					changes += 1;
					if (a[i]) {
						a[i] = false;
					} else if (b[i]) {
						b[i] = false;
					}
				}
			} else {
				if (a[i] == b[i]) {
					if (b[i] == false) { //0,0
						changes += 1;
						b[i] = true;
					} else {//1,1
						//do nothing right now
					}
				} else { //0,1 or 1,0
					//do nothing right now
				}
			}
			if (changes > k) {
				System.out.println(-1);
				return;
			}
		}
		
		for (int i = 0; i < maxBit; i++) {
			if (changes + 1 <= k) {
				if (a[i] && b[i] && c[i]) {
					changes++;
					a[i] = false;
					continue;
				}
			} 
			if (changes + 2 <= k) {
				if (a[i] && !b[i] && c[i]) {
					changes+=2;
					a[i] = false;
					b[i] = true;
				}
			}
		}

		System.out.println(toString(a));
		System.out.println(toString(b));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int q = in.nextInt(), k;
		for (int i = 0; i < q; i++) {
			k = in.nextInt();
			printSolution(k, in.next(), in.next(), in.next());
		}
		
		in.close();
	}
}
