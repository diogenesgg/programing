package leetcode;

//https://leetcode.com/problems/divide-two-integers
public class DivideTwoIntegers {

	public int divide(int dividend_, int divisor_) {
		long dividend = dividend_;
		long divisor = divisor_;
		boolean isNegative = isNevativeQuociente(dividend, divisor);
		
		if (dividend < 0) {
			dividend -= dividend + dividend;
		}
		if (divisor < 0) {
			divisor -= divisor + divisor;
		}
		
		long quo = 0, inc = divisor, inc_counter = 1, acc = 0;
        boolean incremented;
		
        do {
        		incremented = false;
        		inc = divisor;
        		inc_counter = 1;
	        	while (acc + inc <= dividend) {
	        		incremented = true;
	        		acc += inc;
	        		quo += inc_counter;
	        		
	        		inc += inc;
	        		inc_counter += inc_counter;
	        }
        } while(incremented);
        
        if (isNegative) {
        		quo -= quo + quo;
        }
        
        if (quo > Integer.MAX_VALUE) {
        		quo = Integer.MAX_VALUE;
        }
        
		return (int)quo;
    }
	
	private boolean isNevativeQuociente(long a, long b) {
		return (a < 0 && b > 0) || (a > 0 && b < 0); 
	}
	
	public static void main(String[] args) {
		DivideTwoIntegers sol = new DivideTwoIntegers();
		assertEquals(sol.divide(1, 1), 1);
		assertEquals(sol.divide(10, 3), 3);
		assertEquals(sol.divide(10, 1), 10);
		assertEquals(sol.divide(1, 10), 0);
		assertEquals(sol.divide(Integer.MAX_VALUE, 1), Integer.MAX_VALUE);
		assertEquals(sol.divide(Integer.MAX_VALUE, 2), Integer.MAX_VALUE/2);
		assertEquals(sol.divide(7, -3), -2);
		assertEquals(sol.divide(-64, -64), 1);
		assertEquals(sol.divide(Integer.MIN_VALUE, Integer.MIN_VALUE), 1);
		assertEquals(sol.divide(Integer.MIN_VALUE, Integer.MAX_VALUE), Integer.MIN_VALUE/Integer.MAX_VALUE);
		assertEquals(sol.divide(123456, 31), 123456/31);
		
		//I forgot bout this OVERFLOW test case
		assertEquals(sol.divide(-2147483648, -1), Integer.MAX_VALUE);
	}
	
	private static void assertEquals(int result, int expected) {
		if (result != expected) throw new RuntimeException("Expected " + expected + ", but got " + result);
		System.out.println("Test passed!");
	}
	
}
