package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {

	public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    
    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
	    
    	for (int stack = 0, i = last_i; i < s.length(); ++i) {
	        if (s.charAt(i) == par[0]) {
	        	stack++;
	        }
	        else if (s.charAt(i) == par[1]) {
	        	stack--;
	        }
	        if (stack >= 0) continue;
	        for (int j = last_j; j <= i; ++j) {
	            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
	            	System.out.println("substr1: "+s.substring(0, j)+" substr2: "+s.substring(j + 1, s.length()));
	                remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
	            }
	        }
	        return;
	    }
	    
	    String reversed = new StringBuilder(s).reverse().toString();
	    System.out.println("reversed: "+reversed);
	    if (par[0] == '(') {// finished left to right
	        remove(reversed, ans, 0, 0, new char[]{')', '('});
	    }
	    else { // finished right to left
	        ans.add(reversed);
	    }
    }

    public static void main(String args[]) {
    	RemoveInvalidParenthesis remove = new RemoveInvalidParenthesis();
    	String expression = "()())()";
    	System.out.println(expression);
        System.out.println(remove.removeInvalidParentheses(expression));
    }
}
