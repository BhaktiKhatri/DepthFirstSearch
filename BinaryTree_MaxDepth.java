package DepthFirstSearch;

/**
 * Leetcode_104
 * Java program to find maximum height or depth of a binary tree
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/
 * Time Complexity: O(n)
 * @author NisuBhakti
 *
 */
// Definition for a binary tree node.
  class TreeNode2 {
     int val;
     TreeNode2 left;
     TreeNode2 right;
     TreeNode2(int x) {
    	 val = x;
    }
 }

public class BinaryTree_MaxDepth {

	TreeNode2 root;
	 public int maxDepth(TreeNode2 root) {
	 
		 if(root == null)
			 return 0;
		 else 
			 return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	 }

	 /* Driver program to test above functions */
	    public static void main(String[] args) 
	    {
	    	BinaryTree_MaxDepth tree = new BinaryTree_MaxDepth();
	  
	        tree.root = new TreeNode2(1);
	        tree.root.left = new TreeNode2(2);
	        tree.root.right = new TreeNode2(3);
	        tree.root.left.left = new TreeNode2(4);
	        tree.root.left.right = new TreeNode2(5);
	  
	        System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
	    }
}
