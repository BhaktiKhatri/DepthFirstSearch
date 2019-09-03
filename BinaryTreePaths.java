package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/description/
 * Given a binary tree, return all root-to-leaf paths.
 *
 */

public class BinaryTreePaths {

	TreeNode root;
	
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		
		if(root != null) { 
			searchBT(root, "", answer);
		}
		
		System.out.println("answer: "+answer);
		
		return answer;
	}
	
	/*
	 			   1
				 /   \
				2     3
				 \
				  5
	 */
	public static void searchBT(TreeNode root, String path, List<String> answer) {
		System.out.println("root: "+root.val+" path: "+path+" answer: "+answer);
		
		if(root.left == null && root.right == null) {
			answer.add(path + root.val);
		}
		
		System.out.println("root: "+root.val+" path: "+path+" answer: "+answer);
		
		if(root.left != null) {
			searchBT(root.left, path + root.val + "->", answer);
		}
		
		System.out.println("root: "+root.val+" path: "+path+" answer: "+answer);
		
		if(root.right != null) {
			searchBT(root.right, path + root.val + "->", answer);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreePaths tree = new BinaryTreePaths();
	    
		/*
		 			   1
					 /   \
					2     3
					 \
					  5
		 */
	    tree.root = new TreeNode(1);
	    tree.root.left = new TreeNode(2);
	    tree.root.right = new TreeNode(3);
	    tree.root.left.right = new TreeNode(5);
	    
	    System.out.println(binaryTreePaths(tree.root));
	}
}