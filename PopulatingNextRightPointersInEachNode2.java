package DepthFirstSearch;

/*
 * 117. Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 * Given a binary tree
 * 
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note: You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * Example: Given the following binary tree,
 * 	
 * 	     1
 * 	   /  \
 * 	  2    3
 * 	 / \    \
 * 	4   5    7
 * After calling your function, the tree should look like:
 * 
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 * Explanation and Code from: @reeclapple https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution?page=2
 * Time Complexity: O(n); Space Complexity: O(1)
 * Microsoft, Facebook, Bloomberg
 * Medium
 */

public class PopulatingNextRightPointersInEachNode2 {

	//Definition for binary tree with next pointer.
	public static class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) {
		    	  val = x; 
		      }
		 }
		 
    TreeLinkNode root;
	
    public static void connect(TreeLinkNode root) {
        TreeLinkNode head = root;		//The left most node in the lower level
        TreeLinkNode prev = null;		//The previous node in the lower level
        TreeLinkNode curr = null;		//The current node in the upper level
        
        System.out.println("root: "+root.val);
        
        while(head != null) {
            curr = head;
            prev = null;
            head = null;
            
            while(curr != null) {
            	
            	System.out.println("curr: "+curr.val);
            	
                if(curr.left != null) {
                	System.out.println("curr.left: "+curr.left.val);
                	
                    if(prev != null) {
                    	System.out.println("prev: "+prev.val);
                        prev.next = curr.left;
                    }
                    else {
                    	//System.out.println("head: "+head);
                        head = curr.left;
                    }
                    prev = curr.left;
                    System.out.println("prev: "+prev.val);
                }
                
                if(curr.right != null) {
                	System.out.println("curr.right: "+curr.right.val);
                	
                	if(prev != null) {
                		System.out.println("prev: "+prev.val);
                        prev.next = curr.right;
                    }
                    else { 
                    	System.out.println("head: "+head.val);
                        head = curr.right;
                    }
                    prev=curr.right;
                }
                curr=curr.next;
            }
        }
	}
		    
	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode2 tree = new PopulatingNextRightPointersInEachNode2();
		
		tree.root = new TreeLinkNode(1);
		tree.root.left = new TreeLinkNode(2);
		tree.root.right = new TreeLinkNode(3);
		tree.root.left.left = new TreeLinkNode(4);	
		tree.root.left.right = new TreeLinkNode(5);
		tree.root.right.right = new TreeLinkNode(7);
		connect(tree.root);
		System.out.println();
	}

}
