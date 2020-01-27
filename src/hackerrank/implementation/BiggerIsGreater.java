package hackerrank.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BiggerIsGreater {
	static String biggerIsGreater(String w) {
		char[] word = w.toCharArray();
        
        char aux = 0;
        for (int i = word.length - 2; i >= 0; i--) {
        		if (word[i] < word[i+1]) {
        			for (int j = word.length - 1; j > i; j--) {
        				if (word[j] > word[i]) {
        					aux = word[j];
        					word[j] = word[i];
        					word[i] = aux;
        					break;
        				}
        			}
        			Arrays.sort(word, i+1, word.length);
        			break;
        		}
        }
        if (aux == 0) {
        		return "no answer";
        }
        
        return String.copyValueOf(word);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            String w = in.next();
            String result = biggerIsGreater(w);
            System.out.println(result);
        }
        in.close();
    }
}
