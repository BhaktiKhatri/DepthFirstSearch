package DepthFirstSearch;

/**
 * Leetcode 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Explanation and Code from: @caiqi8877 https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/36045
 * Time complexity of above solution is O(n) as it traverses the tree only once.
 * Easy
 */

public class MinimumDepthOfBinaryTree {

	TreeNode root;
	
	/*
	 	Let's take a look at a very simple example, the BST with [1,2].

		If it goes with your code, 1 is the root, then left is 1, and right is 0. So in the top layer of the code, Math.min(left, right) + 1 only picks up the 0 (which is the right), and add one to that, then the result is 1.

		It is incorrect since the path is 1 -> 2, and the correct result should be 2. Because node 2 is the leaf and your code should pick up node 2, not simply pick the minimum number of (1, 0).

		Let's go back to the code. root.left == null || root.right == null ? left + right + 1 means that if root.left is null or root.right is null, then adds left, right and 1. There are three conditions here.
		[1] root.left is null, we need to pick right.
		[2] root.left is null, we need to pick left.
		[3] root.left and root.right are all 0, we need to return 1.
		Combined them together, it is left + right + 1
	 */
	
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		
		System.out.println("root: "+root.val);
		
		int left = minDepth(root.left);
		System.out.println("left: "+left);
		
		int right = minDepth(root.right);
		System.out.println("left: "+left+" right: "+right);
		
		if(left == 0 || right == 0) {
			return left + right + 1;
		}
		else { 
			return Math.min(left, right) + 1;
		}
	}
	
	public static void main(String[] args) 
    {
		MinimumDepthOfBinaryTree tree = new MinimumDepthOfBinaryTree();
  
//        tree.root = new TreeNode(1);
//        tree.root.left = new TreeNode(2);
//        tree.root.right = new TreeNode(3);
//        tree.root.left.left = new TreeNode(4);
//        tree.root.left.right = new TreeNode(5);
//  
		
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.left.right = new TreeNode(3);
  
		
        System.out.println("Minimum Depth of tree is : " + tree.minDepth(tree.root));
    }

}
