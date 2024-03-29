package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 364. Nested List Weight Sum II
 * https://leetcode.com/problems/nested-list-weight-sum-ii/description/
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 * Example 1: Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
 * Example 2: Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 * Explanation and Code from: https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/
 * @author NisuBhakti
 * LinkedIn
 * Medium
 */

abstract interface NestedInteger {
	
	// @return true if this NestedInteger holds a single integer, rather than a nested list
	public boolean isInteger();
	
	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();
	
	// Set this NestedInteger to hold a single integer
	public void setInteger(int value);
	
	// Set this NestedInteger to hold a nested list and adds a nested integer to it
	public void add(NestedInteger ni);
	
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}


public class NestedListWeightSum2 {

	// Instead of multiplying by depth, add integers multiple times (by going level by level and adding the unweighted sum to the weighted sum after each level)
	public static int depthSumInverse(List<NestedInteger> nestedList) {
	    int unweighted = 0, weighted = 0;
	    while (!nestedList.isEmpty()) {
	        List<NestedInteger> nextLevel = new ArrayList<>();
	        for(NestedInteger ni: nestedList) {					//[[1,1],2,[1,1]] [1,[4,[6]]]
	            if (ni.isInteger())
	                unweighted = unweighted + ni.getInteger();
	            else
	                nextLevel.addAll(ni.getList());
	        }
	        weighted = weighted + unweighted;
	        nestedList = nextLevel;
	    }
	    return weighted;
	}
	
	
	public static void main(String[] args) {

	}

}
