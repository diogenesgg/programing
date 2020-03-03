package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backtracking(n*2, 0, 0, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtracking(int n, int i, int open, int closed, StringBuilder current, List<String> result) {
    		if (current.length() == n) {
    			result.add(current.toString());
    			return;
    		}
        
    		if (open < n/2) {
    			current.append('(');
        		backtracking(n, i+1, open+1, closed, current, result);
        		current.setLength(current.length() - 1);    			
    		}
        
    		if (closed < open) {
    			current.append(')');
    	        backtracking(n, i+1, open, closed + 1, current, result);
    	        current.setLength(current.length() - 1);    			
    		}
    }
    
    public static void main(String[] args) {
		for (String s: new GenerateParentheses().generateParenthesis(5)) {
			System.out.println(s);
		}
	}
}
