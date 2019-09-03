package DepthFirstSearch;

import Tree.MaximumDepthOfBinaryTree;

/**
 * 100. SameTree
 * https://leetcode.com/problems/same-tree/description/
 * Given two binary trees, write a function to check if they are the same or not. 
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * Example 1: Input:
 * 		       1         1
 * 	          / \       / \
 * 	         2   3     2   3
 *         [1,2,3],   [1,2,3]
 * 
 * Output: true
 * Example 2:
 * Input:
 *         	  1         1
 *           /           \
 *          2             2
 *      [1,2],     [1,null,2]
 * Output: false
 * Example 3:
 * Input:
 *         	  1         1
 *           / \       / \
 *          2   1     1   2
 *         [1,2,1],   [1,1,2]
 * Output: false
 * Explanation and Code from: @micheal.zhou https://leetcode.com/problems/same-tree/discuss/32687/Five-line-Java-solution-with-recursion
 * Bloomberg
 * Easy
 */


public class SameTree {

	TreeNode root;

	public static boolean isSameTree(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 ==  null) {
			return true;
		}
		
		if(root1 ==  null || root2 == null) {
			return false;
		}
		
		System.out.println("root1: "+root1.val+" root2: "+root2.val);
		
		if(root1.val == root2.val) {

			//System.out.println("root1.left: "+root1.left.val+" root2.left: "+root2.left.val);
			
			boolean left = isSameTree(root1.left, root2.left);
			System.out.println("left: "+left);
			
			//System.out.println("root1.right: "+root1.right.val+" root2.right: "+root2.right.val);
			
			boolean right = isSameTree(root1.right, root2.right); 
			System.out.println("left: "+left+" right: "+right);
			
			return  left && right; 
		}
		return false;
	}
	
	public static void main(String[] args) {
		/*
		 				   1         1
				          / \       / \
				         2   1     1   1
		*/
		SameTree tree1 = new SameTree();
		
		tree1.root = new TreeNode(1);
		tree1.root.left = new TreeNode(2);
		tree1.root.right = new TreeNode(1);
		
		SameTree tree2 = new SameTree();
		
		tree2.root = new TreeNode(1);
		tree2.root.left = new TreeNode(1);
		tree2.root.right = new TreeNode(1);
		
		System.out.println(isSameTree(tree1.root, tree2.root));
	}
}
