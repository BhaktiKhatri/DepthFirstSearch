package DepthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 199. Binary Tree Right Side View
 * The Right view contains all nodes that are last nodes in their levels.
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example: Given the following binary tree,
 *	   1            <---
 *	 /   \
 *	2     3         <---
 *	 \     \
 *	  5     4       <---
 * You should return [1, 3, 4].
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * Explanation and Code from: @zwangbo https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012
 * Time Complexity: The function does a simple traversal of the tree, so the complexity is O(n)
 * Amazon
 * Medium
 */

public class BinaryTreeRightSideView {
	
	TreeNode root;
	/*
	 	The Right view contains all nodes that are last nodes in their levels.
	 	The core idea of this algorithm:
	 	1.Each depth of the tree only select one node.
		2. View depth is current size of result list.
	 */
	
		/*
			   1            
			 /   \
			2     3         
		  /  \     \
		 6	  5     4
		     /
		     7  
		*/
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		rightView(root, result, 0);
		return result;
	}
	
	public void rightView(TreeNode node, List<Integer> result, int nodeDepth) {
		if(node == null)
			return;
		
		System.out.println("node.val: "+node.val+" nodeDepth: "+nodeDepth+" result: "+result);
		if(nodeDepth == result.size()) {
			result.add(node.val);
		}
		System.out.println("node.val: "+node.val+" nodeDepth: "+nodeDepth+" result: "+result);
		
		rightView(node.right, result, nodeDepth + 1);
		rightView(node.left, result, nodeDepth + 1);
	}
	
	public List<Integer> rightViewQueue(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int count = queue.size();
			System.out.println("count: "+count);
			
			for(int i=1;i<=count;i++) {
				System.out.println("i: "+i+" count: "+count);
				
				TreeNode node = queue.poll();
				System.out.println("node: "+node.val);
				
				if(i == count) {
					System.out.print(node.val+" ");
					result.add(node.val);
				}
				
				if(node.left != null) {
					queue.add(node.left);
				}
				
				if(node.right != null) {
					queue.add(node.right);
				}
			}
		}
		System.out.println(result);
		return result;
	}
	
	//Refer the 1st one
	public static void main(String args[]) {
		BinaryTreeRightSideView tree = new BinaryTreeRightSideView();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(4);
        tree.root.left.right.left = new TreeNode(7);
        
        List<Integer> list = tree.rightSideView(tree.root);
        //List<Integer> list = tree.rightViewQueue(tree.root);
        System.out.println(list);
        //tree.rightViewQueue(tree.root);
	}

}
