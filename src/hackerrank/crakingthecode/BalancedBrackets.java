package hackerrank.crakingthecode;

import java.util.LinkedList;
import java.util.Scanner;

public class BalancedBrackets {

	public static boolean isBalanced(String expression) {
        LinkedList<Node> stack = new LinkedList<>();
        
        for (int i = 0; i < expression.length(); i++) {
        		char next = expression.charAt(i);
        		
        		if (isOpenChar(next)) {
        			Node newTop = new Node();
        			newTop.open = next;
        			stack.push(newTop);
        		} else if (isCloseChar(next)) {
        			Node top = stack.peek();
        			if (top == null) {
        				return false;
        			}
        			if (top.open == '{' && next != '}') {
        				return false;
        			}
        			if (top.open == '[' && next != ']') {
        				return false;
        			}
        			if (top.open == '(' && next != ')') {
        				return false;
        			}
        			stack.pop();
        		}
        }
        return stack.isEmpty();
    }
	
	private static boolean isOpenChar(char c) {
		return c == '[' || c == '{' || c == '(';
	}
	
	private static boolean isCloseChar(char c) {
		return c == ']' || c == '}' || c == ')';
	}
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
        in.close();
    }
    
    static class Node {
    		char open = 0;
    		char close = 0;
    }
}
