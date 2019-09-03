package DepthFirstSearch;

import java.util.Arrays;

/**
 * Leetcode 213. House Robber II
 * https://leetcode.com/problems/house-robber-ii/description/
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * Explanation and Code from: @lx223 https://leetcode.com/problems/house-robber-ii/discuss/59934
 * @author NisuBhakti
 * Time Complexity: O(N)
 * Microsoft
 * Medium
 */

public class HouseRobber2 {

	/*  
	 	There are two cases here 1) 1st element is included and last is not included 2) 1st is not included and last is included.
	 	For nums[0…n-1], 0 and n-1 are neighboring to each other. Basically, there are only three possible cases: (1) rob 0, but leave n-1 untouched, 
	 	(2) leave 0 untouched, rob n-1, (3) leave both 0 and n-1 untouched. Obviously, case (3) can be covered by case(1) or case (2) in the simple 
	 	House Robber problem. Hence, the above solution covers all the possible cases.
	 */
	
	public static int robCircle(int[] nums) {
		if(nums.length == 0)
			return 0;
		
		if(nums.length == 1)
			return nums[0];
		
		System.out.println("nums: "+Arrays.toString(nums));
		
		return Math.max(robRow(nums, 0, nums.length-2), robRow(nums, 1, nums.length-1));
	}
	
	public static int robRow(int[] nums, int low, int high) {
		int prevMax = 0;
		int curMax = 0;
		
		System.out.println("low: "+low+" high: "+high);
		
		for(int i=low; i<=high; i++) {
			System.out.println("i: "+i+" nums[i]: "+nums[i]+" prevMax: "+prevMax+" curMax: "+curMax);
			
			int temp = curMax;
			System.out.println("temp: "+temp);
			
			curMax = Math.max(prevMax + nums[i], curMax);
			System.out.println("curMax: "+curMax);
			
			prevMax = temp;
			System.out.println("prevMax: "+prevMax);
		}
		return curMax;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,4,5,1};
		System.out.println(robCircle(num));
	}

}
