package hackerrank.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 * 
 * @author diogenes
 *
 */
public class DesignerPDFViewer {

	static int designerPdfViewer(int[] h, String word) {
        int max = 1, nextChar;
        for (int i = 0; i < word.length(); i++) {
			nextChar = word.charAt(i) - 'a';
			if (h[nextChar] > max) {
				max = h[nextChar];
			}
		}
        return word.length() * max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}
