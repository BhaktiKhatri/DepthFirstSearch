package DepthFirstSearch;

/**
 * Leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 * In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences. 
 * By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on right are in right subtree.
 * @author NisuBhakti
 * Time Complexity: O(n^2)
 */
public class ConstructPreInOrderTree {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	            break;
	        }
	    }
	    
	    //System.out.println("root: "+root.val+" inIndex: "+inIndex+" preStart: "+preStart+" inStart: "+inStart+" inEnd: "+inEnd);
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper( inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	public static void main(String args[]) 
    {
		ConstructPreInOrderTree tree = new ConstructPreInOrderTree();
        int in[] = new int[]{'4', '2', '5', '1', '6', '3'};
        int pre[] = new int[]{'1', '2', '4', '5', '3', '6'};
        tree.buildTree(pre, in);
    }

}
