package DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 513. Find Bottom Left Tree Value
 * https://leetcode.com/problems/find-bottom-left-tree-value/description/
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * Example 1: Input:
 *					    2
 *					   / \
 *					  1   3
 *
 * Output: 1
 * Example 2: Input:
 *        1
 *       / \
 *      2   3
 *     /   / \
 *   4   5   6
 *       /
 *      7
 * Output: 7 
 * Note: You may assume the tree (i.e., the given root node) is not NULL
 * Explanation and Code from: https://leetcode.com/problems/find-bottom-left-tree-value/discuss/
 * Microsoft
 * Medium
 */

public class FindBottomLeftTreeValue {

	TreeNode root;
	/*
	 	Doing BFS right-to-left means we can simply return the last node's value and don't have to keep track of the first node in the current row
	 	or even care about rows at all. Inspired by @fallcreek's solution (not published) which uses two nested loops to go row by row but already
	 	had the right-to-left idea making it easier. I just took that further.
				 	        1
					       / \
					      2   3
					     /   / \
					    4   5   6
					       /
					      7
					      
		Queue insert from rear (back) and pop from front; poll removes head which is in the front
		https://www.google.com/search?q=queue+insert&rlz=1C1CHBF_enUS777US777&source=lnms&tbm=isch&sa=X&ved=0ahUKEwju0drzkK7bAhVS-qwKHWy3BDEQ_AUICygC&biw=1600&bih=737#imgrc=YUm3qZVtRegHZM:
	 */
	public static int findLeftMostNode(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);							//1,3,2,6,5,4,7
	    
	    while(!queue.isEmpty()) {
	    	System.out.println("queue: "+queue);
	    	
	    	root = queue.poll();
	        System.out.println("root: "+root.val);
	        
	        if(root.right != null) {
	            queue.add(root.right);
	        }
	        
	        if(root.left != null) {
	            queue.add(root.left);
	        }
	    }
	    return root.val;
	}
	
	public static void main(String[] args) {
		FindBottomLeftTreeValue tree = new FindBottomLeftTreeValue();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.right = new TreeNode(3);
		tree.root.right.left = new TreeNode(5);
		tree.root.right.left.left = new TreeNode(7);
		tree.root.right.right = new TreeNode(6);
		
		System.out.println(findLeftMostNode(tree.root));
	}

}
