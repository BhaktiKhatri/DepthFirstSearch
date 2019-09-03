package DepthFirstSearch;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/discuss/
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * Example 1: Given the following tree [3,9,20,null,null,15,7]:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 * Example 2: Given the following tree [1,2,2,3,3,null,null,4,4]:
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 * Time Complexity is O(N)
 * Bloomberg
 * Easy
 */

/* Java program to determine if binary tree is height balanced or not */

class Node {
	int val;
	Node left;
	Node right;
	
	public Node(int data) {
		val = data;
	}
}

public class BalancedBinaryTree {
	
	Node root;
	/* 
    	Constructed binary tree is
    
              1
            /   \
          2      3
         / \    /
        4   5  6
       /
      7 
     
      Returns true if binary tree with root as root is height-balanced
   */
 
	public boolean isBalanced(Node root) {
	     if(root == null) {
			return true;
	     }
	     System.out.println("root: "+root.val);
	     
	     int height = getHeight(root);
	     System.out.println("height: "+height);
	     
		 if(height == -1) {
			 return false;       
		 }
	
		return true;
	}

 /**
  * This method is based on DFS. Instead of calling getHeight() explicitly for each child node, we return the height of the current node in DFS recursion. 
  * When the sub tree of the current node (inclusive) is balanced, the function getHeight() returns a non-negative value as the height. Otherwise -1 is returned. 
  * According to the leftHeight and rightHeight of the two children, the parent node could check if the sub tree is balanced, and decides its return value.
  * In this bottom up approach, each node in the tree only need to be accessed once. Thus the time complexity is O(N).
  * @param root - Node - root of the tree
  * @return
  */
  public int getHeight(Node root) {
		if(root == null) {
			return 0;
		}
		System.out.println("root: "+root.val);
		
		int left = getHeight(root.left);
		System.out.println("left: "+left);
		
		int right = getHeight(root.right);
		System.out.println("right: "+right);
		
		if(left == -1 || right == -1) {
			return -1;
		}

		if(Math.abs(left - right) > 1) { 
			return -1;
		}

		return Math.max(left, right) + 1;
	}
  
 public static void main(String args[])
 {
     /* 
      Constructed binary tree is
      
                1
              /   \
            2      3
           / \    /
          4   5  6
         /
        7 
                
    */
	 
     BalancedBinaryTree tree = new BalancedBinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.right.right = new Node(6);
     tree.root.left.left.left = new Node(7);

     if (tree.isBalanced(tree.root))
         System.out.println("Tree is balanced");
     else
         System.out.println("Tree is not balanced");
 }
}
