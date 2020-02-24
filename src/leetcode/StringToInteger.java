package leetcode;

public class StringToInteger {

	public int myAtoi(String str) {
        final int READING_SPACES = 1;
        final int READING_TRAILING_ZERO = 6;
        final int READING_SIGN = 2;
        final int READING_DIGIT = 3;
        final int SUCCESS = 4;
        final int ERROR = 5;
        
        //mind max overflow
        //mind min overflow
        
        int state = READING_SPACES;
        
        char next;
        int i = 0;
        StringBuilder number = new StringBuilder();
        int sign = 1;
        
        while (state != SUCCESS && state != ERROR && i < str.length()) {
            next = str.charAt(i++);
            if (state == READING_SPACES) {
                if (next == ' ') {
                    //do nothing.
                } else if (next >= '1' && next <= '9') {
                    state = READING_DIGIT;
                    number.append(next);
                } else if (next == '-' || next == '+') {
                    state = READING_TRAILING_ZERO;
                    if (next == '-') sign = -1;
                } else if (next == '0') {
                    state = READING_TRAILING_ZERO;  
                } else {
                    state = ERROR;
                }
            } else if (state == READING_DIGIT) {
                if (next >= '0' && next <= '9') {
                    number.append(next);
                } else {
                    state = SUCCESS;
                }
            } else if (state == READING_TRAILING_ZERO) {
                if (next >= '1' && next <= '9') {
                    state = READING_DIGIT;
                    number.append(next);
                } else if (next == '0'){
                    //ignore
                } else {
                    state = ERROR;
                }
            }
        }
        
        if (state == ERROR) {
            return 0;
        }
        
        String strNumber = number.toString();
        long returnValue = 0;
        long curentBase = 1;
        long toAdd;
        for (int j = strNumber.length() - 1; j >= 0; j--) {
            toAdd = (strNumber.charAt(j) - '0') * curentBase * sign;
            returnValue += toAdd;
            if (returnValue < Integer.MIN_VALUE) {
            		return Integer.MIN_VALUE;
            }
            if (returnValue > Integer.MAX_VALUE) {
            		return Integer.MAX_VALUE;
            }
            curentBase *= 10;
        }
        
        return (int)returnValue;
    }
	
	public static void main(String[] args) {
		//System.out.println(100000000*100);
		//int x = "2147483646";
		//nt x = 2000000000 + 147483646;
		//System.out.println(x);
		//System.out.println(Integer.MAX_VALUE - 147483646);
		System.out.println(new StringToInteger().myAtoi("-6147483648"));
	}
}
