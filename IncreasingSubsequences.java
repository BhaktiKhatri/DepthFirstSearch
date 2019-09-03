package DepthFirstSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 491. Increasing Subsequences
 * https://leetcode.com/problems/increasing-subsequences/description/
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
 * Example: Input: [4, 6, 7, 7] Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note: The length of the given array will not exceed 15. The range of integer in the given array is [-100,100]. 
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 * Explanation and Code from: @adarsh_kashyap https://leetcode.com/problems/increasing-subsequences/discuss/97130
 * @author NisuBhakti
 * Yahoo
 * Medium
 */

public class IncreasingSubsequences {

	public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> holder = new ArrayList<Integer>();
        findSequence(res, holder, 0, nums);
        List result = new ArrayList(res);
        return result;
    }

   public static void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
	   System.out.println("res: "+res+" holder: "+holder+" index: "+index+" nums: "+Arrays.toString(nums));
       if (holder.size() >= 2) {
           res.add(new ArrayList(holder));
       }
       
       for (int i = index; i < nums.length; i++) {
           if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
               holder.add(nums[i]);
               findSequence(res, holder, i + 1, nums);
               holder.remove(holder.size() - 1);
           }
       }
   }
	
	public static void main(String[] args) {
		int[] nums = {4, 6, 7, 7};
		System.out.println(findSubsequences(nums));
	}

}
