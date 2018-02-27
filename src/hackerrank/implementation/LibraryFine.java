package hackerrank.implementation;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class LibraryFine {

	static int libraryFine(int dRet, int mRet, int yRet, int dExp, int mExp, int yExp) {
		
		GregorianCalendar ret = new GregorianCalendar(yRet, mRet - 1, dRet);
		GregorianCalendar exp = new GregorianCalendar(yExp, mExp - 1, dExp);
		
		if (ret.before(exp) || ret.equals(exp)) {
			return 0;
		}
		
        if (yRet > yExp) {
        	    return 10000;
        }
        if (mRet > mExp) {
        	    return (mRet - mExp) * 500; 
        }
        if (dRet > dExp) {
        	    return (dRet - dExp) * 15;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        in.close();
    }
}
