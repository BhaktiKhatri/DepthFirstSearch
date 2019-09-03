package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 366. Find Leaves of Binary Tree
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * Example: Given binary tree 
 *          1
 *         / \
 *        2   3
 *       / \     
 *      4   5    
 * Returns [4, 5, 3], [2], [1]
 * Explanation: 1. Removing the leaves [4, 5, 3] would result in this tree:
 *          1
 *         / 
 *        2          
 * 2. Now removing the leaf [2] would result in this tree:
 *         1          
 * 3. Now removing the leaf [1] would result in the empty tree:
 *         []         
 * Returns [4, 5, 3], [2], [1].
 * Explanation and Code from: @sky-xu https://leetcode.com/problems/find-leaves-of-binary-tree/discuss/83778
 * @author NisuBhakti
 * LinkedIn
 * Medium
 */

public class FindLeavesOfBinaryTree {

	TreeNode root;
	
	/*
	 		          1
			         / \
			        2   3
			       / \     
			      4   5    
	 */
	
	public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
	
    public static int height(TreeNode node, List<List<Integer>> res){
        if(node == null)  {
        	return -1;
        }
        
        System.out.println("node: "+node.val+" res: "+res);
        
        int leftHeight = height(node.left, res);
        int rightHeight = height(node.right, res);
        
        System.out.println("node: "+node.val+" leftHeight: "+leftHeight+" rightHeight: "+rightHeight);
        
        int level = 1 + Math.max(leftHeight, rightHeight);
        System.out.println("level: "+level+" res.size(): "+res.size()+" node: "+node.val);
        
        if(res.size() < level+1)  {
        	res.add(new ArrayList<>());
        }
        
        res.get(level).add(node.val);
        return level;
    }
	
	public static void main(String[] args) {
		FindLeavesOfBinaryTree tree = new FindLeavesOfBinaryTree();
		
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right = new TreeNode(3);
		
		System.out.println(findLeaves(tree.root));
		
	}
}