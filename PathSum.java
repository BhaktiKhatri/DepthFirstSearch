package DepthFirstSearch;

/**
 * Leetcode 112. Path Sum
 * https://leetcode.com/problems/path-sum/description/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 * Example: Given the below binary tree and sum = 22,
 * 
 * 		      5
 * 		     / \
 * 		    4   8
 * 		   /   / \
 * 		  11  13  4
 * 		 /  \      \
 * 		7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * Microsoft
 * Easy
 */

public class PathSum {
	
	TreeNode root;
	/*
						      5
						     / \
						    4   8
						   /   / \
						  11  13  4
						 /  \      \
						7    2      1
						
		sum = 22
		
		The basic idea is to subtract the value of current node from sum until it reaches a leaf node and the subtraction equals 0,
		then we know that we got a hit. Otherwise the subtraction at the end could not be 0.
	 */
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) {
			return false;
		}
		System.out.println("root: "+root.val+" sum: "+sum);
		
		if(root.left == null && root.right == null && sum - root.val == 0) {	//leaf node
			return true;
		}
		
		boolean leftPath = hasPathSum(root.left, sum - root.val);
		System.out.println("root: "+root.val+" leftPath: "+leftPath);
		
		boolean rightPath = hasPathSum(root.right, sum - root.val);
		System.out.println("root: "+root.val+" leftPath: "+leftPath+" rightPath: "+rightPath);
		
		return  leftPath || rightPath; 
	}

	public static void main(String[] args) 
    {
		/*
				      5
				     / \
				    4   8
				   /   / \
				  11  13  4
				 /  \      \
				7    2      1
		*/
		PathSum tree = new PathSum();
  
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(4);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(11);
        tree.root.left.left.left = new TreeNode(7);
        tree.root.left.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(13);
        tree.root.right.right = new TreeNode(4);
        tree.root.right.right.right = new TreeNode(1);
        
        int sum = 22;
        System.out.println(hasPathSum(tree.root, sum));
    }
	
}
