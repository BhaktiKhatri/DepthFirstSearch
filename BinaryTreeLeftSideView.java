package DepthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 199. Binary Tree Left Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * @author NisuBhakti
 * Same as Leetcode 199. Binary Tree Right Side View
 */
public class BinaryTreeLeftSideView {
	
	TreeNode root;
	
	/*
			 	   1            
				 /   \
				2     3         
				 \     \
				  5     4       
	 */
	public List<Integer> leftSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		leftView(root, result, 0);
		return result;
	}
	
	public void leftView(TreeNode node, List<Integer> result, int nodeDepth) {
		if(node == null)
			return;
		
		System.out.println("node.val: "+node.val+" nodeDepth: "+nodeDepth+" result: "+result);
		if(nodeDepth == result.size()) {
			result.add(node.val);
		}
		
		System.out.println("node.val: "+node.val+" nodeDepth: "+nodeDepth+" result: "+result);
		
		leftView(node.left, result, nodeDepth + 1);
		leftView(node.right, result, nodeDepth + 1);
	}
	
	public void leftViewQueue(TreeNode root) {
		if(root == null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int n = queue.size();
			
			for(int i=1;i<=n;i++) {
				TreeNode node = queue.poll();
				
				if(i == n)
					System.out.print(node.val+" ");
				
				if(node.right != null)
					queue.add(node.right);
				
				if(node.left != null)
					queue.add(node.left);
			}
		}
	}
	
	public static void main(String args[]) {
		BinaryTreeLeftSideView tree = new BinaryTreeLeftSideView();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
        
        List<Integer> list = tree.leftSideView(tree.root);
        System.out.println(list);
        
        tree.leftViewQueue(tree.root);
	}

}
