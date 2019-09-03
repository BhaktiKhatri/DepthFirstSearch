package DepthFirstSearch;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/description/
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example: Given the below binary tree and sum = 22,
 *             5
 *             / \
 *            4   8
 *           /   / \
 *          11  13  4
 *         /  \    / \
 *        7    2  5   1
 * return [[5,4,11,2], [5,8,4,5]]
 * Explanation and Code from: https://leetcode.com/problems/path-sum-ii/discuss/
 * Bloomberg
 * Medium
 */

public class PathSum2 {

	public TreeNode root;
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> result  = new LinkedList<List<Integer>>();
		List<Integer> currentResult  = new LinkedList<Integer>();
		pathSum(root,sum,currentResult,result);
		return result;
	}

	public static void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
		if (root == null)
			return;
		
		System.out.println("root: "+root.val+" currentResult: "+currentResult+" result: "+result+" sum: "+sum);
		currentResult.add(new Integer(root.val));
		
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new LinkedList<Integer>(currentResult));
			currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
			return;
		} 
		else {
			pathSum(root.left, sum - root.val, currentResult, result);
			pathSum(root.right, sum - root.val, currentResult, result);
		}
		currentResult.remove(currentResult.size() - 1);
	}
	
	public static void main(String[] args) {
		/*
			 	  5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
		  
		 */
		
		PathSum2 tree = new PathSum2();
		
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(4);
		tree.root.left.left = new TreeNode(11);
		tree.root.left.left.left = new TreeNode(7);
		tree.root.left.left.right = new TreeNode(2);
		tree.root.right = new TreeNode(8);
		tree.root.right.left = new TreeNode(13);
		tree.root.right.right = new TreeNode(4);
		tree.root.right.right.left = new TreeNode(5);
		tree.root.right.right.right = new TreeNode(1);
		
		System.out.println(pathSum(tree.root, 22));
	}
}