package DepthFirstSearch;

/**
 * Leetcode 494. Target Sum
 * https://leetcode.com/problems/target-sum/description/
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, 
 * you should choose one from + and - as its new symbol. Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Example 1: Input: nums is [1, 1, 1, 1, 1], S is 3; Output: 5
 * Explanation: 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3
 * Note: The length of the given array is positive and will not exceed 20. The sum of elements in the given array will not exceed 1000. Your output answer is guaranteed to be fitted in a 32-bit integer.
 * Explanation and Code from: https://leetcode.com/problems/target-sum/discuss/97334?page=1
 * Medium
 * Google, Facebook
 * @author NisuBhakti
 *
 */

public class TargetSum {
	
	/*
	 	return sum < Math.abs(s) || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
		If you have input like [1, 1, 1, 1, 1] and -7 then sum < Math.abs(s) is true and subsetSum is never called.
		If you have input like [1, 1, 1, 1, 1] and -3 then sum + s = 5 - 3 which is positive.
		So the point I want to make is that negative input will never be passed to subsetSum method
	 */

	 public static int findTargetSumWays(int[] nums, int s) {
	        int sum = 0;
	        for (int n : nums) {
	            sum = sum + n;
	        }
	        System.out.println("sum: "+sum);
	        return (sum < s || (s + sum) % 2 > 0) ? 0 : subsetSum(nums, (s + sum) / 2); 
	  }   

	  public static int subsetSum(int[] nums, int s) {
	        int[] dp = new int[s + 1]; 
	        dp[0] = 1;
	        
	        for (int n : nums) {
	            for (int i=s; i>=n; i--) {
	            	System.out.println("n: "+n+" i: "+i+" dp[i]: "+dp[i]+" dp[i-n]: "+dp[i-n]);
	                dp[i] = dp[i] + dp[i - n];
	            }
	        }
	        return dp[s];
	  } 
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		int s = 3;
		
		System.out.println(findTargetSumWays(nums, s));
	}

}
