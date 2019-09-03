package DepthFirstSearch;

/**
 * Leetcode 114. Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 * Given a binary tree, flatten it to a linked list in-place.
 * Explanation and Code from: http://qa.geeksforgeeks.org/3976/qa.geeksforgeeks.org/3976/flattening-a-binary-tree
 * For example, given the following tree:
 * 	    1
 * 	   / \
 * 	  2   5
 * 	 / \   \
 * 	3   4   6
 * The flattened tree should look like:
 * 	1
 * 	 \
 * 	  2
 * 	   \
 * 	    3
 * 	     \
 * 	      4
 * 	       \
 * 	        5
 * 	         \
 * 	          6
 * Microsoft
 * Medium
 */

public class FlattenBinaryTreeToLinkedList {

	public TreeNode root;
	
	public void flatten(TreeNode root) {
		if(root == null)
			return;

		System.out.println(root.val);
		
		while(root != null)
		{
			// Attaches the right sub-tree to the rightmost leaf of the left sub-tree:
			if(root.left!=null)
			{
				TreeNode rightMost = root.left;		//2
				System.out.println("rightMost: "+rightMost.val);
				
				while(rightMost.right!=null)
				{
					System.out.println("rightMost.right: "+rightMost.right.val);
					rightMost = rightMost.right;	//4
				}
				System.out.println("rightMost: "+rightMost.val);
				rightMost.right = root.right;		//5

				System.out.println("root: "+root.val+" root.left: "+root.left.val+" root.right: "+root.right.val);
				// Makes the left sub-tree to the right sub-tree:
				root.right = root.left;
				root.left = null;
			}
			// Flatten the rest of the tree:
			root = root.right;
			
			if(root != null) { 
				System.out.println(root.val);
			}
		}
	}
	
	public static void main(String args[]) {
		FlattenBinaryTreeToLinkedList tree = new FlattenBinaryTreeToLinkedList();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.right = new TreeNode(6);
        
        tree.flatten(tree.root);
	}
}
