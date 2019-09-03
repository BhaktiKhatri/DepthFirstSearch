package DepthFirstSearch;

import java.util.Stack;

/**
 * Leetcode 394. Decode String
 * https://leetcode.com/problems/decode-string/description/
 * Given an encoded string, return it's decoded string.The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef"
 * Explanation and Code from: @bryanbocao-0 https://leetcode.com/problems/decode-string/discuss/87543/
 * @author NisuBhakti
 * Google, Yelp, Coupang
 * Medium
 */

public class DecodeString {
	
	public static int  i=0;
	public static String decodeString(String s) {
		System.out.println("s: "+s);
		int n = 0;
		StringBuilder resultSB = new StringBuilder();
		
		while (i < s.length()) {
			System.out.println("i: "+i+" s.charAt(i): "+s.charAt(i)+" n: "+n);
		
			if (Character.isDigit(s.charAt(i))) {
				while (Character.isDigit(s.charAt(i))) { 
					n = n * 10 + s.charAt(i++) - '0';
				}
				i++;	// '['
				System.out.println("i: "+i+" n: "+n);
				
				String nestedS = decodeString(s);
				System.out.println("nestedS: "+nestedS+" resultSB: "+resultSB);
				
				while (n > 0) {
				    resultSB.append(nestedS);
				    n--;
				}
				System.out.println("resultSB: "+resultSB);
			} 
			else if (Character.isLetter(s.charAt(i))) {
				resultSB.append(s.charAt(i++));
			}
			else if (s.charAt(i++) == ']') { 
				return resultSB.toString();
			}
		}
		return resultSB.toString();
	}
	
	public static String decodeString1(String s) {
		System.out.println("s: "+s);
		
		Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String cur = new String();
        int k = 0;
        
        for(char ch : s.toCharArray()) {
            System.out.println("ch: "+ch+" k: "+k+" intStack: "+intStack+" strStack: "+strStack+" cur: "+cur);
        	
        	if(Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } 
            else if (ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = "";			//empty because it will become aaabc
                k = 0;
            } 
            else if (ch == ']') {
                String tmp = cur;
                cur = strStack.pop();
                System.out.println("tmp: "+tmp+" cur: "+cur);
                
                for(k = intStack.pop(); k > 0; --k) { 
                	System.out.println("k: "+k+" cur: "+cur);
                	cur = cur + tmp;
                }
            } 
            else {
            	cur = cur + ch;
            }
        }
        return cur;
	}
	
	public static void main(String[] args) {
		String s = "10[a]"; //"3[a2[c]]";
		System.out.println(decodeString1(s));
	}

}
