package DepthFirstSearch;

import DepthFirstSearch.PopulatingNextRightPointersInEachNode2.TreeLinkNode;

/**
 * Leetcode 116. Populating Next Right Pointers in Each Node
 * @author NisuBhakti
 *
 */
public class PopulateNextRightPointers {

	 //Definition for binary tree with next pointer.
	 static class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) {
	    	  val = x; 
	      }
	 }
	 
	 TreeLinkNode root;
	 //Refer this
	 public static void connect(TreeLinkNode root) {
		 if(root == null)
			 return;
		 
		 if(root.left != null) {
			 root.left.next = root.right;		// Set the nextRight pointer for root's left child
			 if(root.next != null) {
				 root.right.next = root.next.left;	// Set the next pointer for root's right child. root.next will be NULL if root is the right most child at its level
			 }
		 }
		 connect(root.left);
		 connect(root.right);
	 }
	 
	 public static void connect1(TreeLinkNode root) {
	        if(root == null)
	            return;
	        
	        TreeLinkNode leftStart = root;
	        
	        while(leftStart != null && leftStart.left != null) {
	            populateLowerLevelNextField(leftStart);
				leftStart = leftStart.left;
	        }
	    }
	    
	    public static void populateLowerLevelNextField(TreeLinkNode startNode) {
	        TreeLinkNode curr = startNode;
	        
	        while(curr != null) {
	            curr.left.next = curr.right;
	            
	            if(curr.next != null) {
	                curr.right.next = curr.next.left;
	            }
	            curr = curr.next;
	        }
	    }

	 public static void main(String args[]) {
		 PopulateNextRightPointers tree = new PopulateNextRightPointers();
		    tree.root = new TreeLinkNode(1);
			tree.root.left = new TreeLinkNode(2);
			tree.root.right = new TreeLinkNode(3);
			tree.root.left.left = new TreeLinkNode(4);	
			tree.root.left.right = new TreeLinkNode(5);
			tree.root.right.left = new TreeLinkNode(6);
			tree.root.right.right = new TreeLinkNode(7);
			connect(tree.root);
			System.out.println();
	 }
}
