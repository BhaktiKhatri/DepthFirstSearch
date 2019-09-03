package DepthFirstSearch;

import java.util.Stack;

/**
 * Leetcode 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * Given a binary tree, determine if it is a valid binary search tree (BST)
 * Assume a BST is defined as follows: The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees.
 * Example 1:
 *    2
 *   / \
 *  1   3
 * Binary tree [2,1,3], return true.
 * Example 2:
 *    1
 *   / \
 *  2   3
 * Binary tree [1,2,3], return false.
 * Explanation and Code from: My simple Java solution in 3 lines https://leetcode.com/problems/validate-binary-search-tree/discuss/
 * @author NisuBhakti
 * Medium
 * Facebook, Microsoft, Amazon, Bloomberg
 */

public class ValidateBinarySearchTree {
	
		TreeNode root;
	
		//Basically what I am doing is recursively iterating over the tree while defining interval <minVal, maxVal> for each node which value must 
		//fit in
	 	public static boolean isValidBST(TreeNode root) {
	        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }
	    
	    public static boolean isValidBST(TreeNode root, long minVal, long maxVal) {
	        if(root == null) {
	        	return true;
	        }
	        System.out.println("root: "+root.val+" minval: "+minVal+" maxval: "+maxVal);
	        
	        if(root.val >= maxVal || root.val <= minVal) { 
	        	return false;
	        }
	        
	        boolean leftBST = isValidBST(root.left, minVal, root.val);
	        System.out.println("leftBST: "+leftBST);
	        
	        boolean rightBST = isValidBST(root.right, root.val, maxVal);
	        System.out.println("root: "+root.val+" leftBST: "+leftBST+" rightBST: "+rightBST);
	        
	        //return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
	        return leftBST && rightBST;
	    }
	
	    public static boolean isValidBST1(TreeNode root) {
	        if(root == null) {
	            return true;
	        }
	        
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        
	        while(!stack.isEmpty()) {
	            root = stack.pop();
	            
	            System.out.println("root: "+root.val+" stack: "+stack);
	            
	            if(((root.left != null) && (root.left.val > root.val)) || ((root.right != null) && (root.right.val < root.val))) {
	                return false;
	            }
	        
	            if(root.left != null) {
	            	stack.push(root.left);
	            }
	            
	            if(root.right != null) {
	            	stack.push(root.right);
	            }
	        }
	        return true;
	    }

	    
	public static void main(String[] args) {
		ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
		
		bst.root = new TreeNode(4);
		bst.root.left = new TreeNode(1);
		bst.root.right = new TreeNode(6);
		bst.root.right.left = new TreeNode(5);
		bst.root.right.right = new TreeNode(7);
		
//		bst.root = new TreeNode(5);
//		bst.root.left = new TreeNode(1);
//		bst.root.right = new TreeNode(4);
//		bst.root.right.left = new TreeNode(3);
//		bst.root.right.right = new TreeNode(6);
		
		
		System.out.println(isValidBST1(bst.root));
	}

}
