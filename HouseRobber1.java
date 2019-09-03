package DepthFirstSearch;

import java.util.Arrays;

/**
 * Leetcode 198. House Robber
 * https://leetcode.com/problems/house-robber/description/
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Explanation and code from: Approach #1 (Dynamic Programming) https://leetcode.com/problems/house-robber/solution/
 * @author NisuBhakti
 * Time complexity : O(n), Assume that n is the number of houses, the time complexity is O(n)
 * Space complexity : O(1)
 * Easy
 * LinkedIn, Airbnb
 */

public class HouseRobber1 {

	/*
	 	For n = 3, you have basically the following two options:
		Rob the third house, and add its amount to the first house's amount.
		Do not rob the third house, and stick with the maximum amount of the first two houses.
	 */
	public static int rob(int[] num) {
		if(num.length == 1)
			return num[0];
		
		System.out.println("num: "+Arrays.toString(num));
		
	    int prevMax = 0;
	    int currMax = 0;
	    
	    for(int x: num) {
	    	System.out.println("x: "+x+" prevMax: "+prevMax+" prevMax + x: "+(prevMax + x)+" curMax: "+currMax);
	        
	    	int temp = currMax;
	    	System.out.println("temp: "+temp);
	        
	    	currMax = Math.max(prevMax + x, currMax);
	        System.out.println("currMax: "+currMax);
	    	
	        prevMax = temp;
	        System.out.println("prevMax: "+prevMax);
	    }
	    return currMax;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		System.out.println(rob(num));
	}

}
